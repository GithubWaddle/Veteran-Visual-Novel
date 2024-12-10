package main.java.visual;

import main.java.Configuration;
import main.java.actor.Actor;
import main.java.visual.actorsprite.ActorSprites;
import main.java.visual.background.Background;
import main.java.visual.choicelist.ChoiceList;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Objek window GUI program.
 * Digunakan oleh SceneEvent untuk akses output visual (melalu interface NovelWindowManipulate)
 */
public class NovelWindow extends JFrame implements NovelWindowManipulate {
    private ActorSprites actorSprites;
    private Background background;
    private ChoiceList choiceList;

    private JLayeredPane novelPane;
    private JPanel backgroundPanel;
    private JPanel actorSpritesPanel;
    private JLayeredPane choiceListPane;

    public NovelWindow() {
        super("Veteran Java Visual Novel");
        setSize(Configuration.WINDOW_WIDTH_PIXELS, Configuration.WINDOW_HEIGHT_PIXELS);
        setResizable(false);

        this.novelPane = new JLayeredPane();
        this.novelPane.setLayout(null);
        add(this.novelPane);

        // background panel
        this.backgroundPanel = new JPanel();
        this.backgroundPanel.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.backgroundPanel.setLayout(null);
        this.backgroundPanel.setOpaque(false);

        // actor sprites panel
        this.actorSpritesPanel = new JPanel();
        this.actorSpritesPanel.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.actorSpritesPanel.setLayout(null);
        this.actorSpritesPanel.setOpaque(false);

        // dialog box panel
        // ...

        // choice list panel
        this.choiceListPane = new JLayeredPane();
        this.choiceListPane.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.choiceListPane.setLayout(null);
        this.choiceListPane.setOpaque(false);

        JPanel choiceListBackground = new JPanel();
        choiceListBackground.setBounds(0, 0, this.getWidth(), this.getHeight());
        choiceListBackground.setBackground(new Color(0,0,0,64));

        JPanel choiceListPanel = new JPanel();
        choiceListPanel.setLayout(new GridLayout(3, 1));
        choiceListPanel.setBounds(256, 64, 768, 256);

        JButton choiceListButtonTop = new JButton("Option Top");
        JButton choiceListButtonMiddle = new JButton("Option Middle");
        JButton choiceListButtonBottom = new JButton("Option Bottom");

        choiceListPanel.add(choiceListButtonTop);
        choiceListPanel.add(choiceListButtonMiddle);
        choiceListPanel.add(choiceListButtonBottom);

        this.choiceListPane.add(choiceListBackground, 0, 0);
        this.choiceListPane.add(choiceListPanel, 1, 0);
        this.choiceListPane.setVisible(false);

        // adding panels to novel pane
        this.novelPane.add(this.backgroundPanel, 0,0);
        this.novelPane.add(this.actorSpritesPanel, 1, 0);
        this.novelPane.add(this.choiceListPane, 3,0);

        this.choiceList = new ChoiceList(
                this.choiceListPane,
                choiceListButtonTop,
                choiceListButtonMiddle,
                choiceListButtonBottom
        );
        this.actorSprites = new ActorSprites(this.actorSpritesPanel);
        this.background = new Background(this.backgroundPanel);

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
    public void choiceListAsk(ArrayList<String> choices, Runnable onChoicePicked) {
        this.choiceList.ask(choices, onChoicePicked);
    }

    @Override
    public String getChoicePicked() {
        return choiceList.getChoicePicked();
    }


    /**
     * @param imagePath
     * @param onFinish
     */
    @Override
    public void setBackground(String imagePath, Runnable onFinish) {
        this.background.set(imagePath, onFinish);
    }

    @Override
    public void addActorSprite(Actor actor, String expression, ActorSprites.Position position, Runnable onFinish) {
        this.actorSprites.addActor(actor, expression, position, onFinish);
    }

    /**
     * @param actor
     * @param expression
     */
    @Override
    public void setActorSpriteExpression(Actor actor, String expression, Runnable onFinish) {
        this.actorSprites.setActorExpression(actor, expression, onFinish);
    }

    @Override
    public void moveActorSprite(Actor actor, ActorSprites.Position position, int durationMilliseconds, Runnable onFinish) {
        this.actorSprites.moveActor(actor, position, durationMilliseconds, onFinish);
    }

    /**
     * @param actor
     */
    @Override
    public void removeActorSprite(Actor actor, Runnable onFinish) {
        this.actorSprites.removeActor(actor, onFinish);
    }
}
