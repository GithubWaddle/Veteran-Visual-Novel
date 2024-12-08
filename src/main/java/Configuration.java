package main.java;

import main.java.scene.DefinedScenes;
import main.java.scene.Scene;

public class Configuration {
    // Properti untuk konfigurasi program
    public static final Scene STARTING_SCENE = DefinedScenes.getSceneByName("testSceneWithChoices"); // Scene awal
    public static final int WINDOW_WIDTH_PIXELS = 1080;        // Lebar window
    public static final int WINDOW_HEIGHT_PIXELS = 720;       // Tinggi window
}
