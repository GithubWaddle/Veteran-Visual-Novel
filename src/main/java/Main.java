package main.java;

import main.java.scene.ScenePlayer;
import main.java.visual.NovelWindow;

/**
 * Tempat jalan program.
 */
public class Main {
    public static void main(String[] args) {
        /*
        Do: Instansi window program
        Do: Mendengar input mouse dari window
        Do: Instansi ScenePlayer
        Do: Suplai Configuration.STARTING_SCENE ke scene ScenePlayer.
        Do: Jalankan ScenePlayer
         */

        NovelWindow novelWindow = new NovelWindow();
        novelWindow.setVisible(true);

        ScenePlayer scenePlayer = new ScenePlayer(Configuration.STARTING_SCENE, novelWindow);
        scenePlayer.play();
    }
}