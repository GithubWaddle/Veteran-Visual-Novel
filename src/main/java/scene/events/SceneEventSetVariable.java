package main.java.scene.events;

import main.java.scene.ScenePlayer;
import main.java.visual.NovelWindow;

public class SceneEventSetVariable extends SceneEvent {
    private String name;
    private String value;

    public SceneEventSetVariable(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public void execute(ScenePlayer scenePlayer, NovelWindow novelWindow, Runnable onFinish) {
        scenePlayer.setVariable(this.name, this.value);
        onFinish.run();
    }
}
