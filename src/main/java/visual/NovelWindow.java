package main.java.visual;

import javax.swing.*;

/**
 * Objek window GUI yang digunakan program.
 * (Tidak digunakan dalam build ini)
 */
public class NovelWindow extends JFrame {
    public JPanel clickPane;

    public NovelWindow() {
        super("Veteran Java Visual Novel");
        /* nanti akan menggunakan nilai dalam class Configuration */
        setSize(1080, 720);

        clickPane = new JPanel();
        getContentPane().add(clickPane);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


}
