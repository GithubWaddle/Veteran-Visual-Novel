package main.java.scene.events;

import main.java.scene.ScenePlayer;
import main.java.visual.NovelWindow;

/**
 * Membuat ScenePlayer lompat ke event tertentu dalam himpunan events Scene.
 */
public class SceneEventJump extends SceneEvent {
    public int index;

    public SceneEventJump(int index) {
        this.index = index;
    }

    @Override
    public void execute(ScenePlayer scenePlayer, NovelWindow novelWindow, Runnable onFinish) {
        jumpScenePlayer(scenePlayer, this.index);
        onFinish.run();
    }

    public static void jumpScenePlayer(ScenePlayer scenePlayer, int index) {
        scenePlayer.setCurrentEventIndex(index);
    }
}