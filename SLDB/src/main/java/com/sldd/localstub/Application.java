package com.sldd.localstub;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.sldd.handlers.account.GetAccount;
import com.sldd.handlers.product.GetProduct;

public class Application {

    public static void main(String[] args) {
        GetAccount accountHandler = new GetAccount();
        System.out.println(accountHandler.handleRequest(new APIGatewayProxyRequestEvent(), new ContextStub()));
        GetProduct productHandler = new GetProduct();
        System.out.println(productHandler.handleRequest(new APIGatewayProxyRequestEvent(), new ContextStub()));
        GetProduct productHandler2 = new GetProduct();
        System.out.println(productHandler.handleRequest(new APIGatewayProxyRequestEvent(), new ContextStub()));
        GetProduct productHandler3 = new GetProduct();
        System.out.println(productHandler.handleRequest(new APIGatewayProxyRequestEvent(), new ContextStub()));
    }

}
