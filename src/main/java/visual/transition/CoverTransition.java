package main.java.visual.transition;

import main.java.visual.NovelWindow;

import javax.swing.*;
import java.awt.*;

public class CoverTransition {
    private JLabel cover;

    public CoverTransition(JPanel transitionPanel) {
        boolean DEFAULT_IS_VISIBLE = false;
        Color DEFAULT_COVER_COLOR = new Color(0, 0, 0);

        this.cover = new JLabel();
        this.cover.setBounds(0, 0, transitionPanel.getWidth(), transitionPanel.getHeight());
        this.cover.setBackground(DEFAULT_COVER_COLOR);
        this.cover.setVisible(DEFAULT_IS_VISIBLE);
        transitionPanel.add(this.cover);
    }

    public void show(Runnable onFinish) {
        this.cover.setVisible(true);
        onFinish.run();
    }

    public void hide(Runnable onFinish) {
        this.cover.setVisible(false);
        onFinish.run();
    }
}
