package main.java.scene;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefinedScenes {
    private static List<Scene> scenes = new ArrayList<>();

    // Inisialisasi scene yang tersedia
    static {
        scenes.add(new Scene(
            "intro",
            "assets/images/intro_background.png",
            Arrays.asList(
                "Welcome to the Veteran Visual Novel!",
                "Click to continue to the next scene."
            )
        ));

        scenes.add(new Scene(
            "testScene",
            "assets/images/test_background.png",
            Arrays.asList(
                "Character A: Hello there!",
                "Character B: Hi! How are you?",
                "Character A: I'm good, thank you!"
            )
        ));
    }

    // Mendapatkan scene berdasarkan nama
    public static Scene getSceneByName(String name) {
        for (Scene scene : scenes) {
            if (scene.getName().equals(name)) {
                return scene;
            }
        }
        return null; // Jika scene tidak ditemukan
    }

    // Mendapatkan semua scene
    public static List<Scene> getAllScenes() {
        return scenes;
    }
}
