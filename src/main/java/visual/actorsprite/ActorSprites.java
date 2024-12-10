package main.java.visual.actorsprite;

import main.java.Configuration;
import main.java.actor.Actor;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class ActorSprites {
    public enum Position {
        BOTTOM_LEFT,
        BOTTOM_CENTER_LEFT,
        BOTTOM_CENTER,
        BOTTOM_CENTER_RIGHT,
        BOTTOM_RIGHT
    }

    private final int BOTTOM_LEFT_X = Configuration.WINDOW_WIDTH_PIXELS / 4;
    private final int BOTTOM_CENTER_X = Configuration.WINDOW_WIDTH_PIXELS / 2;
    private final int BOTTOM_RIGHT_X = 3 * Configuration.WINDOW_WIDTH_PIXELS / 4;
    private final int BOTTOM_CENTER_LEFT_X = Configuration.WINDOW_WIDTH_PIXELS / 3;
    private final int BOTTOM_CENTER_RIGHT_X = 2 * Configuration.WINDOW_WIDTH_PIXELS / 3;

    private JPanel actorSpritesPanel;
    private Map<Actor, ActorSprite> sprites;
    private Map<Actor, Position> actorToPosition;

    public ActorSprites(JPanel actorSpritesPanel) {
        this.actorSpritesPanel = actorSpritesPanel;
        this.sprites = new HashMap<>();
        this.actorToPosition = new HashMap<>();
    }

    public void addActor(Actor actor, String expression, Position position, Runnable onFinish) {
        ActorSprite actorSprite = new ActorSprite(actor, expression);

        this.sprites.put(actor, actorSprite);

        this.actorSpritesPanel.add(actorSprite);
        this.setActorPosition(actor, position);

        onFinish.run();
    }

    public void setActorExpression(Actor actor, String expression, Runnable onFinish) {
        sprites.get(actor).setExpression(expression);
        setActorPosition(actor, actorToPosition.get(actor));
        onFinish.run();
    }

    public void setActorPosition(Actor actor, int xPixels, int yPixels) {
        sprites.get(actor).setLocation(xPixels, yPixels);
    }

    public void setActorPosition(Actor actor, Position position) {
        actorToPosition.put(actor, position);
        ActorSprite actorSprite = sprites.get(actor);
        int yPixels = Configuration.WINDOW_HEIGHT_PIXELS - actorSprite.getHeight();
        int halfWidthPixels = actorSprite.getWidth() / 2;
        switch (position) {
            case BOTTOM_LEFT -> setActorPosition(
                    actor,
                    BOTTOM_LEFT_X - halfWidthPixels,
                    yPixels
            );
            case BOTTOM_CENTER_LEFT -> setActorPosition(
                    actor,
                    BOTTOM_CENTER_LEFT_X - halfWidthPixels,
                    yPixels
            );
            case BOTTOM_CENTER -> setActorPosition(
                    actor,
                    BOTTOM_CENTER_X - halfWidthPixels,
                    yPixels
            );
            case BOTTOM_CENTER_RIGHT -> setActorPosition(
                    actor,
                    BOTTOM_CENTER_RIGHT_X - halfWidthPixels,
                    yPixels
            );
            case BOTTOM_RIGHT -> setActorPosition(
                    actor,
                    BOTTOM_RIGHT_X - halfWidthPixels,
                    yPixels
            );
        }
    }

    public void moveActor(Actor actor, int xEndPixels, int yEndPixels, int durationMilliseconds, Runnable onFinish) {
        this.setActorPosition(actor, xEndPixels, yEndPixels);
        new Timer().schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        onFinish.run();
                    }
                }, durationMilliseconds);

        /* too laggy, need to find less laggy way
        if (durationMilliseconds <= 0) {
            this.setActorPosition(actor, xEndPixels, yEndPixels);
            onFinish.run();
            return;
        }

        AtomicInteger currentFrame = new AtomicInteger();
        currentFrame.set(0);
        int frames = durationMilliseconds / 32;

        ActorSprite actorSprite = sprites.get(actor);
        int xStartPixels = actorSprite.getX();
        int yStartPixels = actorSprite.getY();;

        int xDeltaPixels = (xEndPixels - xStartPixels) / frames;
        int yDeltaPixels = (yEndPixels - yStartPixels) / frames;

        Timer timer = new javax.swing.Timer(16, null);
        timer.addActionListener(actionEvent -> {
            if (currentFrame.get() >= frames) {
                actorSprite.setLocation(xEndPixels, yEndPixels);
                timer.stop();
                onFinish.run();
                return;
            }

            int xInBetweenPixels = xStartPixels + xDeltaPixels * currentFrame.get();
            int yInBetweenPixels = yStartPixels + yDeltaPixels * currentFrame.get();
            actorSprite.setLocation(xInBetweenPixels, yInBetweenPixels);
            currentFrame.getAndIncrement();
        });

        timer.start();
         */
    }

    public void moveActor(Actor actor, Position position, int durationMilliseconds, Runnable onFinish) {
        actorToPosition.put(actor, position);
        ActorSprite actorSprite = sprites.get(actor);
        int yEndPixels = Configuration.WINDOW_HEIGHT_PIXELS - actorSprite.getHeight();
        int halfWidthPixels = actorSprite.getWidth() / 2;
        switch (position) {
            case BOTTOM_LEFT -> moveActor(
                    actor,
                    BOTTOM_LEFT_X - halfWidthPixels,
                    yEndPixels,
                    durationMilliseconds,
                    onFinish
            );
            case BOTTOM_CENTER_LEFT -> moveActor(
                    actor,
                    BOTTOM_CENTER_LEFT_X - halfWidthPixels,
                    yEndPixels,
                    durationMilliseconds,
                    onFinish
            );
            case BOTTOM_CENTER -> moveActor(
                    actor,
                    BOTTOM_CENTER_X - halfWidthPixels,
                    yEndPixels,
                    durationMilliseconds,
                    onFinish
            );
            case BOTTOM_CENTER_RIGHT -> moveActor(
                    actor,
                    BOTTOM_CENTER_RIGHT_X - halfWidthPixels,
                    yEndPixels,
                    durationMilliseconds,
                    onFinish
            );
            case BOTTOM_RIGHT -> moveActor(
                    actor,
                    BOTTOM_RIGHT_X - halfWidthPixels,
                    yEndPixels,
                    durationMilliseconds,
                    onFinish
            );
        }
    }

    public void removeActor(Actor actor, Runnable onFinish) {
        this.actorSpritesPanel.remove(sprites.get(actor));
        this.sprites.remove(actor);
        onFinish.run();
    }
}
