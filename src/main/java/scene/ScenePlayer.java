package main.java.scene;

import main.java.scene.events.SceneEvent;

public class ScenePlayer {
    private Scene scene;
    private int currentEventIndex;
    private boolean isPlaying = false;
    
    public ScenePlayer(Scene scene) {
        this.scene = scene;
        this.currentEventIndex = 0;
    }

    public void parseEvent(SceneEvent event) {
        Thread thread = new Thread(() -> event.execute(this));
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        nextEvent();
    }

    public void parseCurrentEvent() {
        parseEvent(scene.getEvents().get(currentEventIndex));
    }

    public void nextEvent() {
        if (!(currentEventIndex < scene.getEvents().size() - 1) || !isPlaying) {
            System.out.println("Cerita selesai.");
            return;
        }

        currentEventIndex++;
        parseCurrentEvent();
    }

    public void previousEvent() {
        if (currentEventIndex > 0) {
            currentEventIndex--;
            parseCurrentEvent();
        } else {
            System.out.println("Sudah di adegan pertama.");
        }
    }

    public void play() {
        this.currentEventIndex = 0;
        this.isPlaying = true;
        parseCurrentEvent();
    }

    public void stop() {
        this.isPlaying = false;
    }

    public void setCurrentEventIndex(int currentEventIndex) {
        this.currentEventIndex = currentEventIndex;
    }
}
