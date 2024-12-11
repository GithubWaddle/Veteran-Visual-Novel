package main.java.scene;

import main.java.actor.DefinedActors;
import main.java.scene.events.*;
import main.java.visual.actorsprite.ActorSprites;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DefinedScenes {
    private static List<Scene> scenes = new ArrayList<>();

    // Inisialisasi scene yang tersedia
    static {
        // REAL
        scenes.add(new Scene(
            "intro",
            Arrays.asList(
                    new SceneEventAddActorSprite(
                            "Clara",
                            "default",
                            ActorSprites.Position.BOTTOM_RIGHT
                    ),
                    new SceneEventAddActorSprite(
                            "Juan",
                            "default",
                            ActorSprites.Position.BOTTOM_LEFT
                    ),
                    new SceneEventWait(2000),
                    new SceneEventMoveActorSprite(
                            "Clara",
                            ActorSprites.Position.BOTTOM_CENTER_RIGHT,
                            0
                    ),
                    new SceneEventMoveActorSprite(
                            "Juan",
                            ActorSprites.Position.BOTTOM_CENTER_LEFT,
                            0
                    ),
                    new SceneEventSetActorSpriteExpression(
                            "Clara",
                            "smile"
                    ),
                    new SceneEventSetActorSpriteExpression(
                            "Juan",
                            "smile2"
                    )
            )
        ));



        // TEST
        scenes.add(new Scene(
            "testScene",
            Arrays.asList(
                    new SceneEventDialog(
                            "Hello there!",
                            DefinedActors.getActorByName("Character A")
                    ),
                    new SceneEventDialog(
                            "Hi! How are you?",
                            DefinedActors.getActorByName("Character B")
                    ),
                    new SceneEventDialog(
                            "I'm good, thank you!",
                            DefinedActors.getActorByName("Character C")
                    )
            )
        ));
        scenes.add(new Scene(
                "testSceneWithChoices",
                Arrays.asList(
                        new SceneEventDialog(
                          "Hello!",
                          DefinedActors.getActorByName("Character A")
                        ),
                        new SceneEventDialog(
                                "What do you like?",
                                DefinedActors.getActorByName("Character A")
                        ),
                        new SceneEventChoice(
                                Map.of(
                                        "Banana", 3,
                                        "Apple",5,
                                        "Meowmeowmeowmeoww...",7,
                                        "iNFINITY",0
                                )
                        ),
                        //CHOICE:Banana
                        new SceneEventDialog(
                                "I liek banna",
                                DefinedActors.getActorByName("Character B")
                        ),
                        new SceneEventJump(10),
                        //CHOICE:Apple
                        new SceneEventDialog(
                                "I liek appel",
                                DefinedActors.getActorByName("Character B")
                        ),
                        new SceneEventJump(10),
                        //CHOICE:Meowmeowmeowmeoww...
                        new SceneEventDialog(
                                "Meowmeowmeowmeoww...",
                                DefinedActors.getActorByName("Character B")
                        ),
                        new SceneEventDialog(
                                "Meowmeowmeowmeoww...meow...",
                                DefinedActors.getActorByName("Character A")
                        ),
                        new SceneEventEnd(),

                        //CHOICE:!END_BRANCH
                        new SceneEventDialog(
                                "what.",
                                DefinedActors.getActorByName("Character A")
                        )
                )
        ));

        scenes.add(new Scene(
                "testActorSprites",
                Arrays.asList(
                        new SceneEventSetBackground(
                                "images/background/background_test.png"
                        ),
                        new SceneEventAddActorSprite(
                                DefinedActors.getActorByName("Test:Rectangle"),
                                "default",
                                ActorSprites.Position.BOTTOM_CENTER
                        ),
                        new SceneEventWait(2000),
                        new SceneEventSetActorSpriteExpression(
                                DefinedActors.getActorByName("Test:Rectangle"),
                                "default_talk"
                        ),
                        new SceneEventMoveActorSprite(
                                DefinedActors.getActorByName("Test:Rectangle"),
                                ActorSprites.Position.BOTTOM_LEFT,
                                1000
                        ),
                        new SceneEventMoveActorSprite(
                                DefinedActors.getActorByName("Test:Rectangle"),
                                ActorSprites.Position.BOTTOM_RIGHT,
                                2000
                        ),
                        new SceneEventAddActorSprite(
                                DefinedActors.getActorByName("Test:Triangle"),
                                "default",
                                ActorSprites.Position.BOTTOM_LEFT
                        ),
                        new SceneEventAddActorSprite(
                                DefinedActors.getActorByName("Test:Circle"),
                                "default",
                                ActorSprites.Position.BOTTOM_CENTER
                        )
                )
        ));

        scenes.add(new Scene(
                "testChoiceList",
                Arrays.asList(
                        new SceneEventAddActorSprite(
                                DefinedActors.getActorByName("Test:Rectangle"),
                                "default",
                                ActorSprites.Position.BOTTOM_CENTER
                        ),
                        new SceneEventWait(2000),
                        new SceneEventChoice(
                                Map.of(
                                        "Left", 3,
                                        "Center Left",5,
                                        "Right",7
                                )
                        ),
                        new SceneEventAddActorSprite(
                                DefinedActors.getActorByName("Test:Circle"),
                                "default",
                                ActorSprites.Position.BOTTOM_LEFT
                        ),
                        new SceneEventEnd(),
                        new SceneEventAddActorSprite(
                                DefinedActors.getActorByName("Test:Circle"),
                                "default",
                                ActorSprites.Position.BOTTOM_CENTER_LEFT
                        ),
                        new SceneEventEnd(),
                        new SceneEventAddActorSprite(
                                DefinedActors.getActorByName("Test:Circle"),
                                "default",
                                ActorSprites.Position.BOTTOM_RIGHT
                        )
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
