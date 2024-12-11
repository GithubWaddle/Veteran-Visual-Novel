package main.java.scene.events;

import main.java.scene.DefinedScenes;
import main.java.scene.Scene;
import main.java.scene.ScenePlayer;
import main.java.visual.NovelWindow;

public class SceneEventSwitchScene extends SceneEvent {

    private Scene scene;
    private String sceneName;

    public SceneEventSwitchScene(Scene scene) {
        this.scene = scene;
    }
    public SceneEventSwitchScene(String sceneName) {
        this.sceneName = sceneName;
    }

    @Override
    public void execute(ScenePlayer scenePlayer, NovelWindow novelWindow, Runnable onFinish) {
        if (sceneName != null) {
            this.scene = DefinedScenes.getSceneByName(sceneName);
        }

        scenePlayer.setScene(this.scene);

        novelWindow.clearActorSprites();
        novelWindow.clearDialogueBox();
        onFinish.run();
    }
}
