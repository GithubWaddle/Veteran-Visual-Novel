package main.java.scene;

import main.java.scene.events.SceneEvent;

import java.util.List;

/**
 * Representasi scene
 */
public class Scene {
    private String name;          // Nama scene
    private String background;    // Path gambar latar belakang
    private List<SceneEvent> events;  // Daftar event dalam scene

    // Konstruktor
    public Scene(String name, String background, List<SceneEvent> events) {
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

    public List<SceneEvent> getEvents() {
        return events;
    }

    public void setEvents(List<SceneEvent> events) {
        this.events = events;
    }

    // Method untuk mencetak isi scene
    public String getContent() {
        StringBuilder content = new StringBuilder();
        content.append("Background: ").append(background).append("\n");
        for (SceneEvent event : events) {
            content.append(event).append("\n");
        }
        return content.toString();
    }
}
