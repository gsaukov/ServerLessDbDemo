package com.sldd.dbinitializer.localstub;

import com.sldd.dbinitializer.DbInitializerHandler;

import java.util.HashMap;

public class Application {

    public static void main(String[] args) {
        DbInitializerHandler handler = new DbInitializerHandler();
        handler.handleRequest(new HashMap<>(), new ContextStub());
    }
}
