package com.sldd.handlers;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collections;
import java.util.Map;

public class LambdaResponseBuilder {

    private static final Gson GSON = new Gson();

    private int statusCode = 200;
    private Map<String, String> headers = Collections.emptyMap();
    private String stringBody;
    private Object objectBody;
    private byte[] binaryBody;
    private boolean base64Encoded;

    public LambdaResponseBuilder setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public LambdaResponseBuilder setHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    public LambdaResponseBuilder setStringBody(String stringBody) {
        this.stringBody = stringBody;
        return this;
    }

    public LambdaResponseBuilder setObjectBody(Object objectBody) {
        this.objectBody = objectBody;
        return this;
    }

    public LambdaResponseBuilder setBinaryBody(byte[] binaryBody) {
        this.binaryBody = binaryBody;
        setBase64Encoded(true);
        return this;
    }

    public LambdaResponseBuilder setBase64Encoded(boolean base64Encoded) {
        this.base64Encoded = base64Encoded;
        return this;
    }

    public APIGatewayProxyResponseEvent build() {
        String body = null;
        if (stringBody != null) {
            body = stringBody;
        } else if (objectBody != null) {
            body = GSON.toJson(objectBody);
        } else if (binaryBody != null) {
            body = new String(Base64.getEncoder().encode(binaryBody), StandardCharsets.UTF_8);
        }
        return new APIGatewayProxyResponseEvent()
                .withStatusCode(statusCode)
                .withBody(body)
                .withHeaders(headers)
                .withIsBase64Encoded(base64Encoded);
    }

    //COMMON RESPONSES

    public static APIGatewayProxyResponseEvent badRequest(String msg) {
        return new LambdaResponseBuilder()
                .setStatusCode(400)
                .setObjectBody(msg)
                .build();
    }

    public static APIGatewayProxyResponseEvent unauthorized() {
        return new LambdaResponseBuilder()
                .setStatusCode(401)
                .setObjectBody("Unauthorized")
                .build();
    }

    public static APIGatewayProxyResponseEvent notFound(String msg) {
        return new LambdaResponseBuilder()
                .setStatusCode(404)
                .setObjectBody(msg)
                .build();
    }

    public static APIGatewayProxyResponseEvent successNoBody() {
        return new LambdaResponseBuilder()
                .setStatusCode(200)
                .build();
    }

    public static APIGatewayProxyResponseEvent successWithBody(Object bodyObject) {
        return new LambdaResponseBuilder()
                .setStatusCode(200)
                .setObjectBody(bodyObject)
                .build();
    }

    public static APIGatewayProxyResponseEvent serverInternalError() {
        return new LambdaResponseBuilder()
                .setStatusCode(500)
                .setObjectBody("Internal Server Error")
                .build();
    }
}
