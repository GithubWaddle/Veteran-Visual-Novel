package main.java.visual;

import main.java.actor.Actor;

import java.util.ArrayList;
import java.util.Vector;

public interface NovelWindowManipulate {
    void dialogBoxTalk(String text, Actor speaker);
    int choiceListAsk(ArrayList<String> choices);
    void setBackground(String imagePath);
    void addActorSprite(Actor actor, String expression);
    void setActorSpriteExpression(Actor actor, String expression);
    void moveActorSprite(Actor actor, int xPixels, int yPixels);
    void removeActorSprite(Actor actor);
}
