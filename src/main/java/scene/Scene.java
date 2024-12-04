package main.java.scene;

import java.util.List;

public class Scene {
    private String name;          // Nama scene
    private String background;    // Path gambar latar belakang
    private List<String> events;  // Daftar event dalam scene

    // Konstruktor
    public Scene(String name, String background, List<String> events) {
        this.name = name;
        this.background = background;
        this.events = events;
    }

    // Getter dan Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public List<String> getEvents() {
        return events;
    }

    public void setEvents(List<String> events) {
        this.events = events;
    }

    // Method untuk mencetak isi scene
    public String getContent() {
        StringBuilder content = new StringBuilder();
        content.append("Background: ").append(background).append("\n");
        for (String event : events) {
            content.append(event).append("\n");
        }
        return content.toString();
    }
}
