package main.java.visual.transition;

import main.java.visual.NovelWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoverTransition {
    private static final Color DEFAULT_COVER_COLOR = new Color(11, 12, 39, 255);
    private static final int ALPHA_DIFFERENCE = 32;
    private JLabel cover;
    private Timer fadeTimer;

    public CoverTransition(JPanel transitionPanel) {
        boolean DEFAULT_IS_VISIBLE = true;

        this.cover = new JLabel();
        transitionPanel.add(this.cover);
        this.cover.setBounds(0, 0, transitionPanel.getWidth(), transitionPanel.getHeight());
        this.cover.setBackground(DEFAULT_COVER_COLOR);
        this.cover.setOpaque(true);
        this.cover.setVisible(DEFAULT_IS_VISIBLE);
    }

    public void show(Runnable onFinish) {
        this.cover.setVisible(true);
        onFinish.run();
    }

    public void hide(Runnable onFinish) {
        this.cover.setVisible(false);
        onFinish.run();
    }

    public void fadeShow(Runnable onFinish) {
        this.fadeTimer = new Timer(16, actionEvent -> {
            if (this.cover.getBackground().getAlpha() > 255) {
                this.fadeTimer.stop();
                this.cover.setBackground(new Color(
                        11, 12, 39, 255
                ));
                this.cover.repaint();
                onFinish.run();
                return;
            }
            this.cover.setBackground(new Color(
                    11, 12, 39, Math.min(this.cover.getBackground().getAlpha() + ALPHA_DIFFERENCE, 255)
            ));
            this.cover.repaint();
        });
        this.fadeTimer.start();
    }

    public void fadeHide(Runnable onFinish) {
        this.fadeTimer = new Timer(16, actionEvent -> {
            if (this.cover.getBackground().getAlpha() < 0) {
                this.fadeTimer.stop();
                this.cover.setBackground(new Color(
                        11, 12, 39, 0
                ));
                this.cover.repaint();
                onFinish.run();
                return;
            }
            this.cover.setBackground(new Color(
                    11, 12, 39, Math.max(this.cover.getBackground().getAlpha() - ALPHA_DIFFERENCE, 0)
            ));
            this.cover.repaint();
        });
        this.fadeTimer.start();
    }
}
