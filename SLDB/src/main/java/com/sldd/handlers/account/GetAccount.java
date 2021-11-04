package com.sldd.handlers.account;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.sldd.handlers.LambdaResponseBuilder;
import com.sldd.handlers.SharedContext;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class GetAccount implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent input, final Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("INPUT: " + input);
        logger.log("CONTEXT: " + context);
        adjustContext();
        return LambdaResponseBuilder.successWithBody(SharedContext.getContext());
    }

    private void adjustContext() {
        Map<String, Object> ctx = SharedContext.getContext();
        if (ctx.containsKey("GetAccount")) {
            ((AtomicInteger) ctx.get("GetAccount")).incrementAndGet();
        } else {
            ctx.put("GetAccount", new AtomicInteger(1));
        }
    }
}
