package com.sldd.dbinitializer;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.CloudFormationCustomResourceEvent;
import com.google.gson.Gson;
import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class DbInitializerHandler implements RequestHandler<CloudFormationCustomResourceEvent, String> {

    private LambdaLogger logger;

    private static final String CHANGE_LOG = "/db/changelog-master.yaml";

    @Override
    public String handleRequest(CloudFormationCustomResourceEvent input, Context context) {
        logger = context.getLogger();
        logger.log("Log lambda input and environment\n");
        logger.log(input + "\n");
        logMap(System.getenv());

        // Start the DB Connection
        ConnectionUtils connectionUtils = new ConnectionUtils(logger);
        Connection conn = null;
        try {
            conn = connectionUtils.createConnection();
            Database dataBase = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(conn));
            Liquibase liquiBase = new Liquibase(CHANGE_LOG, new ClassLoaderResourceAccessor(), dataBase);
            liquiBase.update(new Contexts(), new LabelExpression());
        } catch (Exception e) {
            logger.log(e.getMessage());
            return cloudformationResponse(input, Status.FAILED, context);
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                logger.log(e.getMessage());
            }
        }
        return cloudformationResponse(input, Status.SUCCESS, context);
    }

    private String cloudformationResponse(CloudFormationCustomResourceEvent input, Status status, Context context) {

        String responseUrl = input.getResponseUrl();
        logger.log("ResponseURL: " + responseUrl);

        URL url;
        try {
            url = new URL(responseUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("PUT");

            Map<String, String> response = new HashMap<>();
            response.put("Status", status.toString());
            response.put("PhysicalResourceId", context.getLogStreamName());
            response.put("StackId", input.getStackId());
            response.put("RequestId", input.getRequestId());
            response.put("LogicalResourceId", input.getLogicalResourceId());

            OutputStreamWriter cfnResponse = new OutputStreamWriter(connection.getOutputStream());
            cfnResponse.write(new Gson().toJson(response));
            cfnResponse.close();
            logger.log("Response Code: " + connection.getResponseCode());
        } catch (Exception e) {
            logger.log("Error reporting to CFN "+e.getMessage());
        }

        return status.toString();
    }

    private void logMap (Map<String, ?> map) {
        for(Map.Entry<String, ?> item : map.entrySet()) {
            var key = nvl(item.getKey());
            var val = nvl(item.getValue());
            logger.log(key + " " + val + "\n");
        }
    }

    private String nvl(Object o) {
        return o == null?"null":o.toString();
    }

    private enum Status {
        SUCCESS, FAILED
    }

}
