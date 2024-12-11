package main.java.scene;

import main.java.scene.events.SceneEvent;
import main.java.visual.NovelWindow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Pemain suatu Scene.
 */
public class ScenePlayer {
    private Scene scene;
    private NovelWindow novelWindow;
    private int currentEventIndex;
    private boolean isPlaying = false;
    private Map<String, Object> variables;

    /**
     * Konstruktor ScenePlayer
     * @param scene Scene untuk dimainkan.
     */
    public ScenePlayer(Scene scene, NovelWindow novelWindow) {
        this.scene = scene;
        this.novelWindow = novelWindow;
        this.currentEventIndex = 0;
        this.variables = new HashMap<>();
    }

    /**
     * Memeriksa jika ScenePlayer masih bisa menjalankan scene
     * @return Boolean jika ScenePlayer masih bisa menjalankan scene
     */
    public boolean checkIfCanPlay() {
        return ((this.currentEventIndex < this.scene.getEvents().size()) && this.isPlaying);
    }

    public void setScene(Scene scene) {
        this.scene = scene;
        this.currentEventIndex = 0;
    }

    /**
     * Menjalankan ScenePlayer.
     */
    public void play() {
        setCurrentEventIndex(0);
        this.isPlaying = true;

        ScenePlayer scenePlayer = this;

        Runnable nextEvent = new Runnable() {
            @Override
            public void run() {
                if (!checkIfCanPlay()) {
                    System.out.println("Cerita selesai!");
                    return;
                }

                SceneEvent event = scenePlayer.scene.getEvents().get(scenePlayer.currentEventIndex);
                scenePlayer.currentEventIndex++;
                event.execute(
                        scenePlayer,
                        novelWindow,
                        this
                );
            }
        };

        nextEvent.run();
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

    public void setVariable(String name, Object value) {
        this.variables.put(name, value);
    }

    public Object getVariable(String name) {
        return this.variables.get(name);
    }

    public String processTextForVariables(String raw) {
        Pattern variablePattern = Pattern.compile("\\$(\\w+)");
        Matcher matcher = variablePattern.matcher(raw);
        return matcher.replaceAll(matchResult -> {
            String variableName = matchResult.group(1);
            return (String) getVariable(variableName);
        });
    }
}
