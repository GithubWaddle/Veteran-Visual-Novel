package main.java.scene.events;

import main.java.scene.ScenePlayer;
import main.java.visual.NovelWindow;

public class SceneEventEnd extends SceneEvent {
    @Override
    public void execute(ScenePlayer scenePlayer, NovelWindow novelWindow, Runnable onFinish) {
        scenePlayer.stop();
        onFinish.run();
    }
}