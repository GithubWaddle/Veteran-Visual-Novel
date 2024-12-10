package main.java.visual;

import main.java.Configuration;
import main.java.actor.Actor;
import main.java.actor.DefinedActors;
import main.java.visual.actorsprite.ActorSprites;
import main.java.visual.background.Background;
import main.java.visual.dialogbox.DialogBox;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Objek window GUI program.
 * Digunakan oleh SceneEvent untuk akses output visual (melalu interface NovelWindowManipulate)
 */
public class NovelWindow extends JFrame implements NovelWindowManipulate {
    private ActorSprites actorSprites;
    private Background background;
    private DialogBox dialogBox;
    private JLayeredPane novelPane;
    private JPanel backgroundPanel;
    private JPanel actorSpritesPanel;
    private JPanel dialogBoxPanel;
    public NovelWindow() {
        super("Veteran Java Visual Novel");
        setSize(Configuration.WINDOW_WIDTH_PIXELS, Configuration.WINDOW_HEIGHT_PIXELS);
        setResizable(false);

        // Initialize layered pane
        this.novelPane = new JLayeredPane();
        this.novelPane.setLayout(null);
        add(this.novelPane);

        // Background panel
        this.backgroundPanel = new JPanel();
        this.backgroundPanel.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.backgroundPanel.setLayout(null);

        // Actor sprites panel
        this.actorSpritesPanel = new JPanel();
        this.actorSpritesPanel.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.actorSpritesPanel.setLayout(null);

        // Dialog box panel
        this.dialogBoxPanel = new JPanel();
        this.dialogBoxPanel.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.dialogBoxPanel.setLayout(null);

        // Add panels to layered pane
        this.novelPane.add(this.backgroundPanel, 0);
        this.novelPane.add(this.actorSpritesPanel, 1);
        this.novelPane.add(this.dialogBoxPanel, 2);

        // Initialize components
        this.actorSprites = new ActorSprites(this.actorSpritesPanel);
        this.background = new Background(this.backgroundPanel);
        this.dialogBox = new DialogBox(); // Using the new DialogBox implementation

        // Add the dialog box to the dialog panel
        this.dialogBoxPanel.add(this.dialogBox.getDialogLayer());

        // Set window properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Displays a dialogue with the actor's name.
     *
     * @param text    The dialogue text.
     * @param speaker The actor speaking the dialogue.
     */
    @Override
    public void dialogBoxTalk(String text, Actor speaker) {
        this.dialogBox.talk(text, speaker);
    }

    /**
     * Displays a dialogue without a specific speaker.
     *
     * @param text The dialogue text.
     */
    public void dialogBoxTalk(String text) {
        this.dialogBox.talk(text, null);
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
        actorSprites.setActorExpression(actor, expression, onFinish);
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


    public static void main(String[] args) {
        // Create the window
        NovelWindow window = new NovelWindow();

        // Test dialogue
        window.dialogBoxTalk("Hello, welcome to the visual novel!", DefinedActors.getActorByName("Character A"));
    }
}
