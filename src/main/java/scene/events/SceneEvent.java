package main.java.scene.events;

import main.java.scene.ScenePlayer;
import main.java.visual.NovelWindow;

public abstract class SceneEvent {
    public abstract void execute(ScenePlayer scenePlayer, NovelWindow novelWindow, Runnable onFinish);
}
