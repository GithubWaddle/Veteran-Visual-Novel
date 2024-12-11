package main.java.scene.events;

import main.java.actor.Actor;
import main.java.actor.DefinedActors;
import main.java.scene.ScenePlayer;
import main.java.visual.NovelWindow;
import main.java.visual.actorsprite.ActorSprites;

public class SceneEventAddActorSprite extends SceneEvent {

    private Actor actor;
    private String expression;
    private ActorSprites.Position position;

    public SceneEventAddActorSprite(Actor actor, String expression, ActorSprites.Position position) {
        this.actor = actor;
        this.expression = expression;
        this.position = position;
    }

    public SceneEventAddActorSprite(String actorName, String expression, ActorSprites.Position position) {
        this.actor = DefinedActors.getActorByName(actorName);
        this.expression = expression;
        this.position = position;
    }

    @Override
    public void execute(ScenePlayer scenePlayer, NovelWindow novelWindow, Runnable onFinish) {
        novelWindow.addActorSprite(
                this.actor,
                this.expression,
                this.position,
                onFinish
        );
    }
}