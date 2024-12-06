package main.java.scene.events;

import main.java.scene.ScenePlayer;

public abstract class SceneEvent {
    public boolean execute(ScenePlayer scenePlayer) {
        return true;
    };
}
