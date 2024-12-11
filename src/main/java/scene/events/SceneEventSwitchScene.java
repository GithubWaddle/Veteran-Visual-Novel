package main.java.scene.events;

import main.java.scene.Scene;
import main.java.scene.ScenePlayer;
import main.java.visual.NovelWindow;

public class SceneEventSwitchScene extends SceneEvent {
    private Scene scene;

    @Override
    public void execute(ScenePlayer scenePlayer, NovelWindow novelWindow, Runnable onFinish) {
        scenePlayer.setScene(this.scene);
        onFinish.run();
    }
}
