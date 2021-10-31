package com.sldd.dbinitializer;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;

import java.sql.Connection;
import java.util.Map;

public class DbInitializerHandler implements RequestHandler<Map<String, Object>, Object> {

    private LambdaLogger logger;

    private static String CHANGE_LOG = "/db/changelog-master.yaml";

    @Override
    public Object handleRequest(Map<String, Object> input, Context context) {
        logger = context.getLogger();
        logger.log("Log lambda input and environment\n");
        logMap(System.getenv());
        logMap(input);

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
            return Status.FAILED;
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
        return Status.SUCCESS;
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
