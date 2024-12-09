package main.java.visual;

import main.java.Configuration;
import main.java.actor.Actor;
import main.java.visual.actorsprite.ActorSprites;
import main.java.visual.background.Background;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Objek window GUI program.
 * Digunakan oleh SceneEvent untuk akses output visual (melalu interface NovelWindowManipulate)
 */
public class NovelWindow extends JFrame implements NovelWindowManipulate {
    private ActorSprites actorSprites;
    private Background background;

    private JLayeredPane novelPane;
    private JPanel backgroundPanel;
    private JPanel actorSpritesPanel;

    public NovelWindow() {
        super("Veteran Java Visual Novel");
        setSize(Configuration.WINDOW_WIDTH_PIXELS, Configuration.WINDOW_HEIGHT_PIXELS);
        setResizable(false);

        this.novelPane = new JLayeredPane();
        this.novelPane.setLayout(null);
        add(this.novelPane);

        this.backgroundPanel = new JPanel();
        this.actorSpritesPanel = new JPanel();
        this.actorSpritesPanel.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.actorSpritesPanel.setLayout(null);

        this.novelPane.add(this.backgroundPanel, 0);
        this.novelPane.add(this.actorSpritesPanel, 1);

        this.actorSprites = new ActorSprites(this.actorSpritesPanel);
        this.background = new Background("images/background/background_test.png");
        this.backgroundPanel.add(this.background);

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
     * @param onFinish
     */
    @Override
    public void setBackground(String imagePath, Runnable onFinish) {
        background.set(imagePath);
    }

    @Override
    public void addActorSprite(Actor actor, String expression, ActorSprites.Position position, Runnable onFinish) {
        actorSprites.addActor(actor, expression, position, onFinish);
    }

    /**
     * @param actor
     * @param expression
     */
    @Override
    public void setActorSpriteExpression(Actor actor, String expression, Runnable onFinish) {
        actorSprites.setActorExpression(actor, expression);
    }

    @Override
    public void moveActorSprite(Actor actor, ActorSprites.Position position, int durationMilliseconds, Runnable onFinish) {
        actorSprites.moveActor(actor, position, durationMilliseconds, onFinish);
    }

    /**
     * @param actor
     */
    @Override
    public void removeActorSprite(Actor actor, Runnable onFinish) {
        actorSprites.removeActor(actor, onFinish);
    }
}
