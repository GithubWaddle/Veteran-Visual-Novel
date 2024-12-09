package main.java.visual.actorsprite;

import main.java.actor.Actor;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ActorSprite extends JLabel {
    private Actor actor;

    public ActorSprite(Actor actor, String expression) {
        this.actor = actor;
        this.setExpression(expression);
    }

    public void setExpression(String expression) {
        URL imageURL = getClass().getClassLoader().getResource(actor.getExpressionResourcePath(expression));
        this.setIcon(new ImageIcon(imageURL));
        this.setBounds(0, 0, this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
    }
}
