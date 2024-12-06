package main.java.scene.events;

import main.java.scene.ScenePlayer;

/**
 * Membuat ScenePlayer lompat ke event tertentu dalam himpunan events Scene.
 */
public class SceneEventJump extends SceneEvent {
    public int index;

    public SceneEventJump(int index) {
        this.index = index;
    }

    @Override
    public boolean execute(ScenePlayer scenePlayer) {
        jumpScenePlayer(scenePlayer, this.index);
        return super.execute(scenePlayer);
    }

    public static void jumpScenePlayer(ScenePlayer scenePlayer, int index) {
        scenePlayer.setCurrentEventIndex(index - 1);
    }
}