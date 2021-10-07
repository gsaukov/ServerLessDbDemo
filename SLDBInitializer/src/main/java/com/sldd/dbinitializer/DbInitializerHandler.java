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
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

public class DbInitializerHandler implements RequestHandler<Map<String, Object>, Object> {

    private static enum Status {
        SUCCESS, FAILED
    }

    @Override
    public Object handleRequest(Map<String, Object> input, Context context) {
        LambdaLogger logger = context.getLogger();
        String requestType = input.get("RequestType").toString();
        logger.log(String.format("[INFO] RequestType is %s\n", requestType));

        // Get Values from the event
        @SuppressWarnings("unchecked")
        Map<String,Object> resourceProps = (Map<String,Object>)input.get("ResourceProperties");
        String dbHost = resourceProps.get("DBHost").toString();
        // Start the DB Connection
        logger.log(String.format("[INFO] Connecting to %s\n", dbHost));
        Connection conn = null;
        try {
            conn = ConnectionUtils.createConnection();
            logger.log("[INFO] Connected to DB!\n");
            Database dataBase = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(conn));
            Liquibase liquiBase = new liquibase.Liquibase("MyChangeLog", new ClassLoaderResourceAccessor(), dataBase);
            liquiBase.update(new Contexts(), new LabelExpression());
        } catch (LiquibaseException e) {
            return Status.FAILED;
        } finally {
            try {
                if (!conn.isClosed() || conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                logger.log(e.getMessage());
            }
        }
        logger.log(String.format("[INFO] %s provisioned\n", dbHost));
        return Status.SUCCESS;
    }

}
