package main.java.visual.background;

import javax.swing.*;
import java.net.URL;

public class Background extends JLabel {

    public Background(String imageResourcePath) {
        set(imageResourcePath);
    }

    public void set(String imageResourcePath) {
        URL imageURL = getClass().getClassLoader().getResource(imageResourcePath);
        this.setIcon(new ImageIcon(imageURL));
        this.setBounds(0, 0, this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
    }

}
