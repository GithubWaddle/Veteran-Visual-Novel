package main.java.actor;

public class Actor {
  public String name;
    public java.util.Map<String, String> sprites;

    public Actor(String name) {
        this.name = name;
        this.sprites = new java.util.HashMap<>();
    }
}
