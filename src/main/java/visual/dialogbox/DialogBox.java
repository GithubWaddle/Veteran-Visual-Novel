package main.java.visual.dialogbox;

import main.java.Configuration;
import main.java.actor.Actor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Manages the dialogue box in the visual novel.
 */
public class DialogBox {
    enum DialogState {
        NOTHING,
        DISPLAYING,
        WAITING_TO_CONTINUE
    }

    private DialogState currentDialogState;
    private Runnable onContinue;

    private JLabel speakerText;
    private JLabel speakerName;
    private JLayeredPane dialogLayer;
    private Timer timer;  // Timer for controlling text animation
    private String currentText;  // Current full text to be displayed
    private int currentCharIndex;  // Index of the current character being displayed
    private String currentSpeaker;


    public DialogBox() {

        dialogLayer = new JLayeredPane();
        dialogLayer.setBounds(0, 0, Configuration.WINDOW_WIDTH_PIXELS, Configuration.WINDOW_HEIGHT_PIXELS);
        dialogLayer.setLayout(null);

        // Dialog box panel
        JPanel dialogBox = new JPanel();
        dialogBox.setBounds(200, Configuration.WINDOW_HEIGHT_PIXELS - 200, 800, 150);
        dialogBox.setLayout(null);
        dialogBox.setBackground(new Color(128, 0, 0, 180));
        // Speaker box panel
        JPanel speakerBox = new JPanel();
        speakerBox.setBounds(200, Configuration.WINDOW_HEIGHT_PIXELS - 250, 200, 30);
        speakerBox.setLayout(null);
        speakerBox.setBackground(new Color(128, 0, 0, 180));

        // Label for speaker name
        this.speakerName = new JLabel();
        this.speakerName.setFont(new Font("Comic Sans", Font.BOLD, 16));
        this.speakerName.setForeground(Color.WHITE);
        this.speakerName.setHorizontalAlignment(SwingConstants.CENTER);
        this.speakerName.setBounds(0,0,200,30);
        // Label for dialog text
        this.speakerText = new JLabel();
        this.speakerText.setBounds(10, 10, 780, 130);
        this.speakerText.setFont(new Font("Comic Sans", Font.PLAIN, 16));
        this.speakerText.setForeground(Color.WHITE);
        this.speakerText.setVerticalAlignment(SwingConstants.TOP);
        this.speakerText.setHorizontalAlignment(SwingConstants.LEFT);
        this.speakerText.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Add a mouse listener to the speakerText to skip the animation and continue to next event
        this.speakerText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Skip the text animation by stopping the timer and showing the full text
                switch (currentDialogState) {
                    case DialogState.DISPLAYING -> {
                        timer.stop();
                        System.out.println("Text Skipped");
                        speakerText.setText("<html>" + currentText.replace("\n", "<br>") + "</html>");
                        currentDialogState = DialogState.WAITING_TO_CONTINUE;
                    }
                    case DialogState.WAITING_TO_CONTINUE -> {
                        currentDialogState = DialogState.NOTHING;
                        onContinue.run();
                    }
                }
            }
        });

        speakerBox.add(speakerName);
        dialogBox.add(speakerText);

        this.dialogLayer.add(speakerBox, Integer.valueOf(1));
        this.dialogLayer.add(dialogBox, Integer.valueOf(1));
    }

    public JLayeredPane getDialogLayer() {
        return dialogLayer;
    }

    /**
     * Updates the text in the dialog box with the speaker's name and the dialogue.
     *
     * @param text    The dialogue text.
     * @param speaker The actor speaking the dialogue.
     */
    public void talk(String text, Actor speaker, Runnable onContinue) {
        this.currentDialogState = DialogState.DISPLAYING;
        this.onContinue = onContinue;

        // Update current speaker and text
        this.currentText = text;
        this.currentCharIndex = 0;
        if(speaker != null) {
            this.currentSpeaker = speaker.name; // Set current speaker's name
        }
        else
        {
            this.currentSpeaker = "Narrator";
        }
        // Update UI
        this.speakerName.setText(this.currentSpeaker);

        // Stop the timer if it's already running
        if (this.timer != null && this.timer.isRunning()) {
            this.timer.stop();
        }

        // Typing effect using a Timer
        this.timer = new Timer(35, e -> {
            if (this.currentCharIndex < this.currentText.length()) {
                String formattedText = "<html>" + this.currentText.substring(0, this.currentCharIndex + 1).replace("\n", "<br>") + "</html>";
                this.speakerText.setText(formattedText);
                this.currentCharIndex++;
            } else {
                this.timer.stop(); // Stop the timer when the text is fully displayed
                this.currentDialogState = DialogState.WAITING_TO_CONTINUE;
            }
        });

        this.timer.start(); // Start the animation
    }

    public void clear() {
        this.speakerName.setText("");
        this.speakerText.setText("");
    }
}
