package main.java.scene.events;

import main.java.actor.Actor;
import main.java.actor.DefinedActors;
import main.java.scene.ScenePlayer;
import main.java.visual.NovelWindow;

import java.io.IOException;

public class SceneEventDialog extends SceneEvent {
    public String text;
    public Actor speaker = null;

    public SceneEventDialog(String text, Actor speaker) {
        this.text = text;
        this.speaker = speaker;
    }
    public SceneEventDialog(String text, String speakerName) {
        this.text = text;
        this.speaker = DefinedActors.getActorByName(speakerName);
    }

    public SceneEventDialog(String text) {
        this.text = text;
    }

    @Override
    public void execute(ScenePlayer scenePlayer, NovelWindow novelWindow, Runnable onFinish) {
        novelWindow.dialogBoxTalk(
                scenePlayer.processTextForVariables(this.text),
                this.speaker,
                onFinish
        );
    }
}
