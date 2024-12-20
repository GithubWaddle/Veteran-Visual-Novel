package main.java.scene.events;

import main.java.actor.Actor;
import main.java.actor.DefinedActors;
import main.java.scene.ScenePlayer;
import main.java.visual.NovelWindow;

public class SceneEventRemoveActorSprite extends SceneEvent {
    Actor actor;

    public SceneEventRemoveActorSprite(String actorName) {
        this.actor = DefinedActors.getActorByName(actorName);
    }

    public SceneEventRemoveActorSprite(Actor actor) {
        this.actor = actor;
    }

    @Override
    public void execute(ScenePlayer scenePlayer, NovelWindow novelWindow, Runnable onFinish) {
        novelWindow.removeActorSprite(actor, onFinish);
    }
}