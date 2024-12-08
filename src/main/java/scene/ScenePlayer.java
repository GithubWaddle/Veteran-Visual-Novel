package main.java.scene;

import main.java.scene.events.SceneEvent;
import main.java.visual.NovelWindow;

import java.util.List;

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

        ScenePlayer scenePlayer = this;
        List<SceneEvent> events = scenePlayer.scene.getEvents();

        Runnable nextEvent = new Runnable() {
            @Override
            public void run() {
                if (!checkIfCanPlay()) {
                    return;
                }

                SceneEvent event = events.get(scenePlayer.currentEventIndex);
                scenePlayer.currentEventIndex++;
                event.execute(
                        scenePlayer,
                        novelWindow,
                        this
                );
            }
        };

        nextEvent.run();
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
}
