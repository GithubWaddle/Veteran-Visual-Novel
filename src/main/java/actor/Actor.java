package main.java.actor;

import java.util.Map;

public class Actor {
    public String name;
    private Map<String, String> expressionImagePaths;

    public Actor(String name, Map<String, String> expressionImagePaths) {
        this.name = name;
        this.expressionImagePaths = new java.util.HashMap<>();
    }

    String getSpritePathByExpression(String expression) {
        return null;
    }
}
