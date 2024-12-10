package main.java.visual.background;

import javax.swing.*;
import java.net.URL;

public class Background {
    private JPanel backgroundPane;
    private JLabel backgroundImageLabel;

    public Background(JPanel backgroundPane) {
        this.backgroundPane = backgroundPane;
        this.backgroundImageLabel = new JLabel();
        this.backgroundPane.add(this.backgroundImageLabel, JLayeredPane.DEFAULT_LAYER);
    }

    public void set(String imageResourcePath, Runnable onFinish) {
        ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource(imageResourcePath));
        this.backgroundImageLabel.setIcon(imageIcon);
        this.backgroundImageLabel.setBounds(0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        onFinish.run();
    }

}
