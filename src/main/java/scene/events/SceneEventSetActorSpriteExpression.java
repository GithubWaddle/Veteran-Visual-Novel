package main.java.scene.events;

import main.java.actor.Actor;
import main.java.scene.ScenePlayer;
import main.java.visual.NovelWindow;

public class SceneEventSetActorSpriteExpression extends SceneEvent {
    private Actor actor;
    private String expression;

    public SceneEventSetActorSpriteExpression(Actor actor, String expression) {
        this.actor = actor;
        this.expression = expression;
    }

    @Override
    public void execute(ScenePlayer scenePlayer, NovelWindow novelWindow, Runnable onFinish) {
        novelWindow.setActorSpriteExpression(
                actor,
                expression,
                onFinish
        );
    }
}
