package main.java.actor;

import java.util.Map;

public class Actor {
    public String name;
    private Map<String, String> expressionResourcePaths;

    public Actor(String name, Map<String, String> expressionResourcePaths) {
        this.name = name;
        this.expressionResourcePaths = expressionResourcePaths;
    }

    public String getExpressionResourcePath(String expression) {
        return this.expressionResourcePaths.get(expression);
    }
}
