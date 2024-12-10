package main.java.scene.events;

import main.java.scene.ScenePlayer;
import main.java.visual.NovelWindow;

import java.util.ArrayList;
import java.util.Map;

public class SceneEventChoice extends SceneEvent {
    public Map<String, Integer> choicesToJumpIndex;

    public SceneEventChoice(Map<String, Integer> choicesToJumpIndex) {
        this.choicesToJumpIndex = choicesToJumpIndex;
    }

    @Override
    public void execute(ScenePlayer scenePlayer, NovelWindow novelWindow, Runnable onFinish) {
        ArrayList<String> choices = new ArrayList<>(choicesToJumpIndex.keySet());
        Runnable onChoicePicked = () -> {
            SceneEventJump.jumpScenePlayer(scenePlayer, choicesToJumpIndex.get(novelWindow.getChoicePicked()));
            onFinish.run();
        };

        novelWindow.choiceListAsk(choices, onChoicePicked);
    }
}