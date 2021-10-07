package com.sldd.dbinitializer;

import com.amazonaws.SdkClientException;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagement;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagementClientBuilder;
import com.amazonaws.services.simplesystemsmanagement.model.GetParameterRequest;
import com.amazonaws.services.simplesystemsmanagement.model.GetParameterResult;

import java.io.IOException;
import java.io.InputStream;
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
            String user = getSSMParameter(System.getenv("DB_USER"));
            String password = getSSMParameter(System.getenv("DB_PASS"));

            conn = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            return null;
        }

        return conn;
    }

    /**
     * Gets the SSM Parameter Value from AWS using the paramName
     * @param paramName the name of the param to fetch
     * @return the string value of the param
     */
    private static String getSSMParameter(String paramName) {
        AWSSimpleSystemsManagement ssm = AWSSimpleSystemsManagementClientBuilder.defaultClient();
        if (paramName != null && !paramName.isEmpty()) {
            GetParameterRequest request = new GetParameterRequest()
                    .withName(paramName)
                    .withWithDecryption(true);
            GetParameterResult result = ssm.getParameter(request);
            if (result != null) {
                return result.getParameter().getValue();
            }
        }
        return null;
    }

}
