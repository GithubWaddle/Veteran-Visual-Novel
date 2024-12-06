package main.java.scene.events;

import main.java.scene.ScenePlayer;
import main.java.visual.DialogBox;

public class SceneEventEnd extends SceneEvent {
    @Override
    public boolean execute(ScenePlayer scenePlayer) {
        scenePlayer.stop();
        return super.execute(scenePlayer);
    }
}