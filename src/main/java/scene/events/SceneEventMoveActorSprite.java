package main.java.scene.events;

import main.java.actor.Actor;
import main.java.scene.ScenePlayer;
import main.java.visual.NovelWindow;
import main.java.visual.actorsprite.ActorSprites;

public class SceneEventMoveActorSprite extends SceneEvent {
    private Actor actor;
    private ActorSprites.Position position;
    private int durationMilliseconds;

    public SceneEventMoveActorSprite(Actor actor, ActorSprites.Position position, int durationMilliseconds) {
        this.actor = actor;
        this.position = position;
        this.durationMilliseconds = durationMilliseconds;
    }

    @Override
    public void execute(ScenePlayer scenePlayer, NovelWindow novelWindow, Runnable onFinish) {
        novelWindow.moveActorSprite(
                actor,
                position,
                durationMilliseconds,
                onFinish
        );
    }
}