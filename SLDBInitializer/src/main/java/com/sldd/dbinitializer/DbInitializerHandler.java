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

    @Override
    public Object handleRequest(Map<String, Object> input, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("Log lambda input and environment\n");
        logStrMap(logger, System.getenv());
        logObjMap(logger, input);

        // Start the DB Connection
        Connection conn = null;
        ConnectionProperties properties = null;
        try {
            properties = ConnectionUtils.getConnectionProperties();
            logger.log("Recieved connection properties!\n" + properties);
            conn = ConnectionUtils.createConnection(properties);
            logger.log("Connected to DB!\n");
            Database dataBase = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(conn));
            Liquibase liquiBase = new Liquibase("classpath:/db/changelog-master.yaml", new ClassLoaderResourceAccessor(), dataBase);
            liquiBase.update(new Contexts(), new LabelExpression());
        } catch (LiquibaseException e) {
            logger.log(e.getMessage());
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
        return Status.SUCCESS;
    }

    private void logObjMap (LambdaLogger logger, Map<String, Object> map) {
        for(Map.Entry<String, Object> item : map.entrySet()) {
            logger.log(item.getKey() + " " + item.getValue());
        }
    }

    private void logStrMap (LambdaLogger logger, Map<String, String> map) {
        for(Map.Entry<String, String> item : map.entrySet()) {
            logger.log(item.getKey() + " " + item.getValue());
        }
    }

    private enum Status {
        SUCCESS, FAILED
    }

}
