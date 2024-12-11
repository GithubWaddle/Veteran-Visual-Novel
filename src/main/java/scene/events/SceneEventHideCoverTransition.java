package main.java.scene.events;

import main.java.scene.ScenePlayer;
import main.java.visual.NovelWindow;

public class SceneEventHideCoverTransition extends SceneEvent {

    @Override
    public void execute(ScenePlayer scenePlayer, NovelWindow novelWindow, Runnable onFinish) {
        novelWindow.hideCoverTransition(onFinish);
    }
}
