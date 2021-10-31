package com.sldd.handlers;

import com.google.gson.Gson;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collections;
import java.util.Map;

public class LambdaResponse {

    private final int statusCode;
    private final String body;
    private final Map<String, String> headers;
    private final boolean isBase64Encoded;

    public LambdaResponse(int statusCode, String body, Map<String, String> headers, boolean isBase64Encoded) {
        this.statusCode = statusCode;
        this.body = body;
        this.headers = headers;
        this.isBase64Encoded = isBase64Encoded;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getBody() {
        return body;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    // API Gateway expects the property to be called "isBase64Encoded" => isIs
    public boolean isIsBase64Encoded() {
        return isBase64Encoded;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private static final Gson GSON = new Gson();

        private int statusCode = 200;
        private Map<String, String> headers = Collections.emptyMap();
        private String stringBody;
        private Object objectBody;
        private byte[] binaryBody;
        private boolean base64Encoded;

        public Builder setStatusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public Builder setHeaders(Map<String, String> headers) {
            this.headers = headers;
            return this;
        }
        
        public Builder setstringBody(String stringBody) {
            this.stringBody = stringBody;
            return this;
        }
        
        public Builder setObjectBody(Object objectBody) {
            this.objectBody = objectBody;
            return this;
        }
        
        public Builder setBinaryBody(byte[] binaryBody) {
            this.binaryBody = binaryBody;
            setBase64Encoded(true);
            return this;
        }
        
        public Builder setBase64Encoded(boolean base64Encoded) {
            this.base64Encoded = base64Encoded;
            return this;
        }

        public LambdaResponse build() {
            String body = null;
            if (stringBody != null) {
                body = stringBody;
            } else if (objectBody != null) {
                body = GSON.toJson(objectBody);
            } else if (binaryBody != null) {
                body = new String(Base64.getEncoder().encode(binaryBody), StandardCharsets.UTF_8);
            }
            return new LambdaResponse(statusCode, body, headers, base64Encoded);
        }
    }

    public static LambdaResponse badRequest(String msg) {
        return LambdaResponse.builder()
                .setStatusCode(400)
                .setObjectBody(msg)
                .build();
    }

    public static LambdaResponse unauthorized() {
        return LambdaResponse.builder()
                .setStatusCode(401)
                .setObjectBody("Unauthorized")
                .build();
    }

    public static LambdaResponse notFound(String msg) {
        return LambdaResponse.builder()
                .setStatusCode(404)
                .setObjectBody(msg)
                .build();
    }

    public static LambdaResponse successBody() {
        return LambdaResponse.builder()
                .setStatusCode(200)
                .build();
    }

    public static LambdaResponse successWithBody(Object bodyObject) {
        return LambdaResponse.builder()
                .setStatusCode(200)
                .setObjectBody(bodyObject)
                .build();
    }

    public static LambdaResponse serverInternalError() {
        return LambdaResponse.builder()
                .setStatusCode(500)
                .setObjectBody("Internal Server Error")
                .build();
    }
}
