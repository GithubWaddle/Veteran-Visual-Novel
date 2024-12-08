package main.java.visual;

import main.java.Configuration;
import main.java.actor.Actor;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Objek window GUI yang digunakan program.
 * (Tidak digunakan dalam build ini)
 */
public class NovelWindow extends JFrame implements NovelWindowManipulate {
    private JPanel NovelPanel;

    public NovelWindow() {
        super("Veteran Java Visual Novel");
        setSize(Configuration.WINDOW_WIDTH_PIXELS, Configuration.WINDOW_HEIGHT_PIXELS);



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    /**
     * @param text
     * @param speaker
     */
    @Override
    public void dialogBoxTalk(String text, Actor speaker) {

    }

    /**
     * @param choices
     * @return
     */
    @Override
    public int choiceListAsk(ArrayList<String> choices) {
        return 0;
    }

    /**
     * @param imagePath
     */
    @Override
    public void setBackground(String imagePath) {

    }

    /**
     * @param actor
     * @param expression
     */
    @Override
    public void addActorSprite(Actor actor, String expression) {

    }

    /**
     * @param actor
     * @param expression
     */
    @Override
    public void setActorSpriteExpression(Actor actor, String expression) {

    }

    /**
     * @param actor
     * @param xPixels
     * @param yPixels
     */
    @Override
    public void moveActorSprite(Actor actor, int xPixels, int yPixels) {

    }

    /**
     * @param actor
     */
    @Override
    public void removeActorSprite(Actor actor) {

    }
}
