package main.java.scene.events;

import main.java.scene.ScenePlayer;
import main.java.visual.NovelWindow;

public class SceneEventSetBackground extends SceneEvent {
    private String imagePath;

    public SceneEventSetBackground(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public void execute(ScenePlayer scenePlayer, NovelWindow novelWindow, Runnable onFinish) {
        novelWindow.setBackground(imagePath, onFinish);
    }
}
