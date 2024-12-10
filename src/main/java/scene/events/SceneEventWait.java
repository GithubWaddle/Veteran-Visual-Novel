package main.java.scene.events;

import main.java.scene.ScenePlayer;
import main.java.visual.NovelWindow;

import java.util.Timer;
import java.util.TimerTask;

public class SceneEventWait extends SceneEvent {
    int durationMilliseconds;

    public SceneEventWait(int durationMilliseconds) {
        this.durationMilliseconds = durationMilliseconds;
    }

    @Override
    public void execute(ScenePlayer scenePlayer, NovelWindow novelWindow, Runnable onFinish) {
        new Timer().schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        onFinish.run();
                    }
                    }, durationMilliseconds);
    }
}
