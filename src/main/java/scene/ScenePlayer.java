package main.java.scene;

import main.java.input.ClickSubscriber;
import java.util.List;

public class ScenePlayer implements ClickSubscriber {
    private List<Scene> scenes;
    private int currentSceneIndex;
    private boolean isPlaying;
    
    public ScenePlayer(List<Scene> scenes) {
        this.scenes = scenes;
        this.currentSceneIndex = 0;
        this.isPlaying = true;
    }

    @Override
    public void mouseClicked() {
        if (isPlaying) {
            System.out.println("Mouse clicked!");
            nextScene();
        }
    }

    public void showScene() {
        if (currentSceneIndex < scenes.size()) {
            Scene currentScene = scenes.get(currentSceneIndex);
            System.out.println("Menampilkan adegan: " + currentScene.getName());
            System.out.println(currentScene.getContent());
        } else {
            System.out.println("Cerita selesai.");
            isPlaying = false;
        }
    }

    public void nextScene() {
        if (currentSceneIndex < scenes.size() - 1) {
            currentSceneIndex++;
            showScene();
        } else {
            System.out.println("Sudah di adegan terakhir.");
            isPlaying = false;
        }
    }

    public void previousScene() {
        if (currentSceneIndex > 0) {
            currentSceneIndex--;
            showScene();
        } else {
            System.out.println("Sudah di adegan pertama.");
        }
    }

    public void play() {
        currentSceneIndex = 0;
        isPlaying = true;
        showScene();
    }
}
