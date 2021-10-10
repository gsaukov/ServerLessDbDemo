package com.sldd.dbinitializer;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

    public static final String DATABASE_SECRETS = "DATABASE_SECRETS";

    public static Connection createConnection(ConnectionProperties properties) {
        Connection conn;
        try {
            String url = properties.getUrl();
            String user = properties.getUsername();
            String password = properties.getPassword();
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            return null;
        }
        return conn;
    }

    public static ConnectionProperties getConnectionProperties() {
        final AWSSecretsManager sm = AWSSecretsManagerClientBuilder.defaultClient();
        GetSecretValueRequest req = new GetSecretValueRequest().withSecretId(System.getenv(DATABASE_SECRETS));
        String secret = sm.getSecretValue(req).getSecretString();
        return toConnectionProperties(secret);
    }

    // sample secret responce:
    //{"dbClusterIdentifier":"aurora-db-dbcluster-y0u68onssbsm","password":"NKZ3nHXyvVL8E9P8","dbname":"AuroraPostgresServerlessDB","engine":"postgres","port":5432,"host":"aurora-db-dbcluster-y0u68onssbsm.cluster-c5cp4a45gt3k.us-east-1.rds.amazonaws.com","username":"postgres"}
    private static ConnectionProperties toConnectionProperties(String secret) {
        return new Gson().fromJson(secret, ConnectionProperties.class);
    }
}
