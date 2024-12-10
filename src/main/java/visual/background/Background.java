package main.java.visual.background;

import javax.swing.*;
import java.net.URL;

public class Background {
    private JPanel backgroundPane;
    private JLabel backgroundImageLabel;

    public Background(JPanel backgroundPane) {
        this.backgroundPane = backgroundPane;
        this.backgroundImageLabel = new JLabel();
        this.backgroundPane.add(this.backgroundImageLabel);
    }

    public void set(String imageResourcePath) {
        URL imageURL = getClass().getClassLoader().getResource(imageResourcePath);
        this.backgroundImageLabel.setIcon(new ImageIcon(imageURL));
        this.backgroundImageLabel.setBounds(0, 0, this.backgroundImageLabel.getIcon().getIconWidth(), this.backgroundImageLabel.getIcon().getIconHeight());
        this.backgroundPane.repaint();
    }

}
