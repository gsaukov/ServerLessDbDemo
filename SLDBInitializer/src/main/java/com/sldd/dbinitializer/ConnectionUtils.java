package com.sldd.dbinitializer;

import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

    public static final String DATABASE_SECRETS = "DATABASE_SECRETS";

    private final LambdaLogger logger;

    public ConnectionUtils(LambdaLogger logger) {
        this.logger = logger;
    }

    public Connection createConnection() {
        var properties = getConnectionProperties();
        logger.log("Recieved connection properties: \n" + properties);
        Connection conn;
        try {
            var url = properties.getUrl();
            var user = properties.getUsername();
            var password = properties.getPassword();
            logger.log("Establishing Database connection.\n");
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            logger.log("Connection failed. " + e.getMessage());
            return null;
        }
        return conn;
    }

    public ConnectionProperties getConnectionProperties() {
        var secretArn = System.getenv(DATABASE_SECRETS);
        logger.log("AWSSecretsManager resolving secret: " + secretArn);
        final AWSSecretsManager sm = AWSSecretsManagerClientBuilder.defaultClient();
        GetSecretValueRequest req = new GetSecretValueRequest().withSecretId(secretArn);
        GetSecretValueResult secret = sm.getSecretValue(req);
        logger.log("AWSSecretsManager recieved: " + secret.getName());
        return toConnectionProperties(secret.getSecretString());
    }

    // sample secret responce:
    //{"dbClusterIdentifier":"aurora-db-dbcluster-y0u68onssbsm","password":"NKZ3nHXyvVL8E9P8","dbname":"AuroraPostgresServerlessDB","engine":"postgres","port":5432,"host":"aurora-db-dbcluster-y0u68onssbsm.cluster-c5cp4a45gt3k.us-east-1.rds.amazonaws.com","username":"postgres"}
    private ConnectionProperties toConnectionProperties(String secret) {
        return new Gson().fromJson(secret, ConnectionProperties.class);
    }
}
