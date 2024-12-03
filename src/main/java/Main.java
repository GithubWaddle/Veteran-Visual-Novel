package main.java;

import main.java.input.ClickListener;
import main.java.scene.ScenePlayer;
import main.java.visual.NovelWindow;

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

        ScenePlayer scenePlayer = new ScenePlayer();
        ClickListener clickListener = new ClickListener(
                novelWindow.clickPane,
                scenePlayer
        );
        //scenePlayer.scene = Configuration.STARTING_SCENE
        //scenePlayer.play();
    }
}