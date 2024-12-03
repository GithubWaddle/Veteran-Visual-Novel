package main.java.input;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClickListener {
    public ClickListener(JPanel clickPanel, ClickSubscriber subscriber) {
        clickPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                subscriber.mouseClicked();
            }
        });
    }


}
