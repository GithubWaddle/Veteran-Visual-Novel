package main.java.scene;

import main.java.scene.events.SceneEvent;
import main.java.visual.NovelWindow;

/**
 * Pemain suatu Scene.
 */
public class ScenePlayer {
    private Scene scene;
    private NovelWindow novelWindow;
    private int currentEventIndex;
    private boolean isPlaying = false;

    /**
     * Konstruktor ScenePlayer
     * @param scene Scene untuk dimainkan.
     */
    public ScenePlayer(Scene scene, NovelWindow novelWindow) {
        this.scene = scene;
        this.novelWindow = novelWindow;
        this.currentEventIndex = 0;
    }

    /**
     * Eksekusi suatu SceneEvent
     * @param event SceneEvent yang akan dieksekusi.
     */
    public void parseEvent(SceneEvent event) {
        Thread thread = new Thread(() -> event.execute(this, this.novelWindow));
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
        return ((this.currentEventIndex < this.scene.getEvents().size()) && this.isPlaying);
    }

    /**
     * Menjalankan ScenePlayer.
     */
    public void play() {
        setCurrentEventIndex(0);
        this.isPlaying = true;

        while (checkIfCanPlay()) {
            parseCurrentEvent();
            currentEventIndex++;
        }

        System.out.println("Cerita selesai!");
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

    public void switchScene(Scene scene) {
        this.scene = scene;
        setCurrentEventIndex(0);
    }
}
