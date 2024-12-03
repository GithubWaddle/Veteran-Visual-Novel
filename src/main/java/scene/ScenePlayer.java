package main.java.scene;

import main.java.input.ClickSubscriber;

public class ScenePlayer implements ClickSubscriber {
    @Override
    public void mouseClicked() {
        System.out.println("Mouse clicked!");
    }
}