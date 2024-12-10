package main.java.scene;

import main.java.scene.events.SceneEvent;

import java.util.List;

/**
 * Representasi scene
 */
public class Scene {
    private String name;          // Nama scene
    private List<SceneEvent> events;  // Daftar event dalam scene

    // Konstruktor
    public Scene(String name, List<SceneEvent> events) {
        this.name = name;
        this.events = events;
    }

    // Getter dan Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        for (SceneEvent event : events) {
            content.append(event).append("\n");
        }
        return content.toString();
    }
}
