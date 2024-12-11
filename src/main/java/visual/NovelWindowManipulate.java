package main.java.visual;

import main.java.actor.Actor;
import main.java.visual.actorsprite.ActorSprites;

import java.util.ArrayList;

public interface NovelWindowManipulate {
    void dialogBoxTalk(String text, Actor speaker, Runnable onFinish);
    void choiceListAsk(ArrayList<String> choices, Runnable onChoicePicked);
    String getChoicePicked();
    void setBackground(String imagePath, Runnable onComplete);
    void addActorSprite(Actor actor, String expression, ActorSprites.Position position, Runnable onComplete);
    void setActorSpriteExpression(Actor actor, String expression, Runnable onComplete);
    void moveActorSprite(Actor actor, ActorSprites.Position position, int durationMilliseconds, Runnable onComplete);
    void removeActorSprite(Actor actor, Runnable onComplete);
    void clearActorSprites();
    void clearDialogueBox();
    void showCoverTransition(Runnable onFinish);
    void hideCoverTransition(Runnable onFinish);
}
