package main.java.character;

public class Character {
  public String name;
    public java.util.Map<String, String> sprites;

    public Character(String name) {
        this.name = name;
        this.sprites = new java.util.HashMap<>();
    }
}
