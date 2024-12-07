package main.java.scene;

import main.java.scene.events.SceneEvent;

/**
 * Pemain suatu Scene.
 */
public class ScenePlayer {
    private Scene scene;
    private int currentEventIndex;
    private boolean isPlaying = false;

    /**
     * Konstruktor ScenePlayer
     * @param scene Scene untuk dimainkan.
     */
    public ScenePlayer(Scene scene) {
        this.scene = scene;
        this.currentEventIndex = 0;
    }

    /**
     * Eksekusi suatu SceneEvent
     * @param event SceneEvent yang akan dieksekusi.
     */
    public void parseEvent(SceneEvent event) {
        Thread thread = new Thread(() -> event.execute(this));
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Eksekusi SceneEvent terkini/di indeks currentEventIndex di dalam properti events.
     */
    public void parseCurrentEvent() {
        parseEvent(this.scene.getEvents().get(currentEventIndex));
    }

    /**
     * Memeriksa jika ScenePlayer masih bisa menjalankan scene
     * @return Boolean jika ScenePlayer masih bisa menjalankan scene
     */
    public boolean checkIfCanPlay() {
        return ((this.currentEventIndex < (this.scene.getEvents().size() - 1)) && this.isPlaying);
    }

    /**
     * Menjalankan ScenePlayer.
     */
    public void play() {
        this.currentEventIndex = 0;
        this.isPlaying = true;

        while (checkIfCanPlay()) {
            parseCurrentEvent();
            currentEventIndex++;
        }
    }

    /**
     * Menghentikan ScenePlayer.
     */
    public void stop() {
        this.isPlaying = false;
    }

    /**
     * Menetapkan nilai untuk properti private currentEventIndex.
     * @param currentEventIndex Nilai untuk ditetapkan.
     */
    public void setCurrentEventIndex(int currentEventIndex) {
        this.currentEventIndex = currentEventIndex;
    }
}
