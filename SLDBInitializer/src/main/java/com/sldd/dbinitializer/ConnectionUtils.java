package com.sldd.dbinitializer;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtils {

    public static Connection createConnection() {
        Properties prop = new Properties();
        Connection conn;

        try {
            String url = prop.getProperty("url");
            String user = getSecretManager();
            String password = getSecretManager();

            conn = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            return null;
        }

        return conn;
    }

    private static String getSecretManager() {
        final AWSSecretsManager sm = AWSSecretsManagerClientBuilder.defaultClient();
        GetSecretValueRequest req = new GetSecretValueRequest().withSecretId(System.getenv("SECRET_ID"));
        String secret = sm.getSecretValue(req).getSecretString();
        return "";
    }

    // sample secret responce:
    //{"dbClusterIdentifier":"aurora-db-dbcluster-y0u68onssbsm","password":"NKZ3nHXyvVL8E9P8","dbname":"AuroraPostgresServerlessDB","engine":"postgres","port":5432,"host":"aurora-db-dbcluster-y0u68onssbsm.cluster-c5cp4a45gt3k.us-east-1.rds.amazonaws.com","username":"postgres"}
}
