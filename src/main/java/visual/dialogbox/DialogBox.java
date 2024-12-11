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
        speakerName = new JLabel();
        speakerName.setFont(new Font("Comic Sans", Font.BOLD, 16));
        speakerName.setForeground(Color.WHITE);
        speakerName.setHorizontalAlignment(SwingConstants.CENTER);
        speakerName.setBounds(0,0,200,30);
        // Label for dialog text
        speakerText = new JLabel();
        speakerText.setBounds(10, 10, 780, 130);
        speakerText.setFont(new Font("Comic Sans", Font.PLAIN, 16));
        speakerText.setForeground(Color.WHITE);
        speakerText.setVerticalAlignment(SwingConstants.TOP);
        speakerText.setHorizontalAlignment(SwingConstants.LEFT);
        speakerText.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Add a mouse listener to the speakerText to skip the animation
        speakerText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Skip the text animation by stopping the timer and showing the full text

                if (timer != null && timer.isRunning()) {
                    timer.stop();
                }
                System.out.println("Text Skipped");
                speakerText.setText("<html>" + currentText.replace("\n", "<br>") + "</html>");
            }
        });

        speakerBox.add(speakerName);
        dialogBox.add(speakerText);

        dialogLayer.add(speakerBox, Integer.valueOf(1));
        dialogLayer.add(dialogBox, Integer.valueOf(1));
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
    public void talk(String text, Actor speaker) {
        // Update current speaker and text
        currentText = text;
        currentCharIndex = 0;
        if(speaker!=null) {
            currentSpeaker = speaker.name; // Set current speaker's name
        }else{
            currentSpeaker = "Narrator";
        }
        // Update UI
        speakerName.setText(currentSpeaker);

        // Stop the timer if it's already running

        if (timer != null && timer.isRunning()) {
            timer.stop();
        }

        // Typing effect using a Timer
        timer = new Timer(35, e -> {
            if (currentCharIndex < currentText.length()) {
                String formattedText = "<html>" + currentText.substring(0, currentCharIndex + 1).replace("\n", "<br>") + "</html>";
                speakerText.setText(formattedText);
                currentCharIndex++;
            } else {
                timer.stop(); // Stop the timer when the text is fully displayed

            }
        });

        timer.start(); // Start the animation


    }
}
