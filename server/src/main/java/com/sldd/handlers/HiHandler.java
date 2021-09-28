package com.sldd.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

import java.util.Map;

public class HiHandler implements RequestHandler<Map<String,String>, String>{

    @Override
    public String handleRequest(Map<String,String> event, Context context) {
        LambdaLogger logger = context.getLogger();
        String response = new String("200 OK");
        // log execution details
        logger.log("ENVIRONMENT VARIABLES: " + System.getenv());
        logger.log("CONTEXT: " + context);
        // process event
        logger.log("EVENT: " + event);
        logger.log("EVENT TYPE: " + event.getClass().toString());
        return response;
    }

}
