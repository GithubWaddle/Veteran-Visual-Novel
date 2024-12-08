package main.java.scene.events;

import main.java.actor.Actor;
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

    public SceneEventDialog(String text) {
        this.text = text;
    }

    @Override
    public void execute(ScenePlayer scenePlayer, NovelWindow novelWindow) {
        if (this.speaker != null) {
            System.out.println(
                    this.speaker.name + ": " + this.text
            );
        }
        else {
            System.out.println(
                    this.text
            );
        }

        try {
            System.out.print("Press Enter to Continue: ");
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
