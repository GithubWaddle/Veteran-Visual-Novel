package main.java.visual.choicelist;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ChoiceList {
    private JLayeredPane choiceListPanel;
    private ArrayList<JButton> buttons;
    private Runnable onChoicePicked;
    private String choicePicked;

    public ChoiceList(JLayeredPane choiceListPanel, JButton buttonTop, JButton buttonMiddle, JButton buttonBottom) {
        this.choiceListPanel = choiceListPanel;

        this.buttons = new ArrayList<>();
        this.buttons.add(buttonTop);
        this.buttons.add(buttonMiddle);
        this.buttons.add(buttonBottom);

        for (JButton button : buttons) {
            button.addActionListener(actionEvent -> {
                this.choicePicked = button.getText();
                hide();
                onChoicePicked.run();
            });
            button.setVisible(false);
        }
    }

    public void show(ArrayList<String> choices) {
        for (int i = 0; i < choices.size(); i++) {
            buttons.get(i).setVisible(true);
            buttons.get(i).setText(choices.get(i));
        }

        this.choiceListPanel.setVisible(true);
    }

    public void hide() {
        this.choiceListPanel.setVisible(false);
        for (JButton button : buttons) {
            button.setVisible(false);
        }
    }

    public void ask(ArrayList<String> choices, Runnable onChoicePicked) {
        this.onChoicePicked = onChoicePicked;
        show(choices);
    }

    public String getChoicePicked() {
        return choicePicked;
    }

}
