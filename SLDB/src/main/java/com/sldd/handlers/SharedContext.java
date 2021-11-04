package com.sldd.handlers;

import java.util.HashMap;
import java.util.Map;

public final class SharedContext {

    private static final Map<String, Object> CONTEXT = new HashMap<>();

    public static Map<String, Object> getContext() {
        return CONTEXT;
    }

}
