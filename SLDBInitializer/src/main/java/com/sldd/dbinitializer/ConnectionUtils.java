package com.sldd.dbinitializer;

import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtils {

    public static final String DATABASE_SECRETS = "DATABASE_SECRETS";

    private final LambdaLogger logger;

    public ConnectionUtils(LambdaLogger logger) {
        this.logger = logger;
    }

    public Connection createConnection() throws Exception {
        var properties = getConnectionProperties();
        logger.log(properties + "\n");
        Connection conn;
        var url = properties.getUrl();
        var user = properties.getUsername();
        var password = properties.getPassword();
        logger.log("Establishing Database connection.\n");
        conn = DriverManager.getConnection(url, user, password);
        logger.log("Connected to Database!\n");
        return conn;
    }

    public ConnectionProperties getConnectionProperties() {
        var secretArn = System.getenv(DATABASE_SECRETS);
        logger.log("AWSSecretsManager resolving secret: " + secretArn + "\n");
        AWSSecretsManager sm = AWSSecretsManagerClientBuilder.defaultClient();
        GetSecretValueRequest req = new GetSecretValueRequest().withSecretId(secretArn);
        GetSecretValueResult secret = sm.getSecretValue(req);
        logger.log("AWSSecretsManager recieved: " + secret.getName() + "\n");
        return toConnectionProperties(secret.getSecretString());
    }

    // sample secret responce:
    //{"dbClusterIdentifier":"aurora-db-dbcluster-y0u68onssbsm","password":"NKZ3nHXyvVL8E9P8","dbname":"AuroraPostgresServerlessDB","engine":"postgres","port":5432,"host":"aurora-db-dbcluster-y0u68onssbsm.cluster-c5cp4a45gt3k.us-east-1.rds.amazonaws.com","username":"postgres"}
    private ConnectionProperties toConnectionProperties(String secret) {
        return new Gson().fromJson(secret, ConnectionProperties.class);
    }

    private ConnectionProperties getLocalConnectionProperties() {
        var properties = new ConnectionProperties();
        properties.setHost("localhost");
        properties.setPort(5432);
        properties.setUsername("serveles_db");
        properties.setPassword("serveles_db");
        return properties;
    }
}
