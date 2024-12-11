package main.java.scene;

import main.java.actor.DefinedActors;
import main.java.scene.events.*;
import main.java.visual.actorsprite.ActorSprites;
import main.java.visual.choicelist.ChoiceList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DefinedScenes {
    private static final List<Scene> scenes = new ArrayList<>();

    // Inisialisasi scene yang tersedia
    static {
        // REAL
        scenes.add(new Scene(
            "Work Thoughts of Decision",
            Arrays.asList(
                    new SceneEventSetBackground(
                            "images/background/busy_office.png"
                    ),
                    new SceneEventAddActorSprite(
                            "Juan",
                            "default",
                            ActorSprites.Position.BOTTOM_LEFT
                    ),
                    new SceneEventAddActorSprite(
                            "Nanda",
                            "default",
                            ActorSprites.Position.BOTTOM_RIGHT
                    ),
                    new SceneEventDialog(
                            "Kamu kelihatan nggak fokus hari ini, bro. Apa ini soal tawaran dari Pak Rafi?",
                            "Nanda"
                    ),
                    new SceneEventDialog(
                            "Iya. Tawaran itu besar, tapi Clara mengirim pesan, dan itu memunculkan banyak kenangan lama.",
                            "Juan"
                    ),
                    new SceneEventDialog(
                            "Kenangan itu bagus, Juan, tapi nggak bikin rekening bankmu penuh. Aku nggak bermaksud kasar, tapi hidup ini butuh keseimbangan. Dan kadang, prioritas itu harus jelas.",
                            "Nanda"
                    ),
                    new SceneEventDialog(
                            "Aku tahu. Tapi entah kenapa, aku merasa seperti kehilangan sesuatu kalau meninggalkan Clara.",
                            "Juan"
                    ),
                    new SceneEventDialog(
                            "Kalau itu benar-benar masalahnya, cari tahu apa yang lebih penting untukmu. Tapi ingat, kesempatan kayak tawaran ini nggak datang dua kali.",
                            "Nanda"
                    ),
                    new SceneEventShowCoverTransition(),
                    new SceneEventSwitchScene(
                            "Still Career Focus"
                    )
            )
        ));

        scenes.add(new Scene(
                "Home Thoughts of Decision",
                Arrays.asList(
                        new SceneEventSetBackground(
                                "images/background/home.png"
                        ),
                        new SceneEventAddActorSprite(
                                "Juan",
                                "default",
                                ActorSprites.Position.BOTTOM_LEFT
                        ),
                        new SceneEventAddActorSprite(
                                "Ibu",
                                "default",
                                ActorSprites.Position.BOTTOM_RIGHT
                        ),
                        new SceneEventWait(1000),
                        new SceneEventHideCoverTransition(),
                        new SceneEventDialog(
                                "Jadi, Nak, kau sudah membuat keputusan tentang tawaran itu?",
                                "Ibu"
                        )
                )
        ));

        scenes.add(new Scene(
                "Career or Love",
                Arrays.asList(

                )
        ));

        scenes.add(new Scene(
                "Career Focus",
                Arrays.asList(

                )
        ));

        scenes.add(new Scene(
                "Elena Love?",
                Arrays.asList(

                )
        ));

        scenes.add(new Scene(
                "Still Elena Love?",
                Arrays.asList(

                )
        ));

        scenes.add(new Scene("Still Career Focus",
                Arrays.asList(
                        new SceneEventSetBackground("images/background/office2.png"),
                        new SceneEventAddActorSprite(DefinedActors.getActorByName("Juan"),"default",ActorSprites.Position.BOTTOM_CENTER),
                        new SceneEventDialog(".......",DefinedActors.getActorByName("Juan")),
                        new SceneEventWait(500),
                        new SceneEventSetActorSpriteExpression(DefinedActors.getActorByName("Juan"),"smile1"),
                        new SceneEventDialog("Satu-satunya hal yang penting sekarang adalah karirku. Aku akan fokus total.",DefinedActors.getActorByName("Juan")),
                        new SceneEventShowCoverTransition(),
                        new SceneEventSwitchScene("Failed Career Focus")

                )));

        scenes.add(new Scene("Failed Career Focus",Arrays.asList(
                new SceneEventSetBackground("images/background/empty_office.png"),
                new SceneEventAddActorSprite(DefinedActors.getActorByName("Bos Rafi"),"angry1",ActorSprites.Position.BOTTOM_RIGHT),
                new SceneEventWait(500),
                new SceneEventSetActorSpriteExpression(DefinedActors.getActorByName("Bos Rafi"),"angry2"),
                new SceneEventAddActorSprite(DefinedActors.getActorByName("Juan"),"default",ActorSprites.Position.BOTTOM_LEFT),
                new SceneEventDialog("Juan, proyek ini tidak berjalan sesuai harapan. Kami harus mengurangi beberapa posisi. Posisimu akan dihapuskan.",DefinedActors.getActorByName("Bos Rafi")),
                new SceneEventWait(500),
                new SceneEventSetActorSpriteExpression(DefinedActors.getActorByName("Juan"),"shocked"),
                new SceneEventDialog("Ini sangat mengecewakan, Pak. Saya merasa sudah memberikan yang terbaik.",DefinedActors.getActorByName("Juan")),
                new SceneEventWait(1000),
                new SceneEventChoice(
                        Map.of(
                                "Kembali ke negara asal dan bertemu Clara",12,/*Return to clara*/
                                "Mencoba bangkit membangun karir kembali di luar negeri",14/*Make it Big Outside*/
                        )
                ),
                new SceneEventShowCoverTransition(),
                new SceneEventSwitchScene("Return to Clara?"),
                new SceneEventShowCoverTransition(),
                new SceneEventSwitchScene("Make it Big Outside")

        )));

        scenes.add(new Scene("Return to Clara?",Arrays.asList(
                new SceneEventSetBackground("images/background/park.png"),
                new SceneEventAddActorSprite(DefinedActors.getActorByName("Juan"),"default",ActorSprites.Position.BOTTOM_LEFT),
                new SceneEventAddActorSprite(DefinedActors.getActorByName("Clara"),"default",ActorSprites.Position.BOTTOM_RIGHT),
                new SceneEventDialog(".......",DefinedActors.getActorByName("Clara")),
                new SceneEventSetActorSpriteExpression(DefinedActors.getActorByName("Clara"),"delighted2"),
                new SceneEventDialog("Aku tahu kau sedang sulit, tapi aku masih percaya kita bisa saling mendukung. Aku ada di sini untukmu.",DefinedActors.getActorByName("Clara")),
                new SceneEventWait(1000),
                new SceneEventSetActorSpriteExpression(DefinedActors.getActorByName("Juan"),"sad"),
                new SceneEventDialog("Aku tidak yakin apakah aku pantas untukmu sekarang.",DefinedActors.getActorByName("Juan")),
                new SceneEventWait(1000),
                new SceneEventChoice(
                        Map.of(
                                "Terima dukungan Clara",12,/*Love For Clara?*/
                                "Tolak bantuan Clara",14/*New Happiness*/
                        )
                ),

                new SceneEventShowCoverTransition(),
                new SceneEventSwitchScene("Love For Clara?"),

                new SceneEventShowCoverTransition(),
                new SceneEventSwitchScene("New Happiness")

                )));

        scenes.add(new Scene("Make it Big Outside",Arrays.asList(
                new SceneEventSetBackground("images/background/office2.png"),
                new SceneEventWait(1000),
                new SceneEventAddActorSprite(DefinedActors.getActorByName("Juan"),"sad",ActorSprites.Position.BOTTOM_CENTER),
                new SceneEventWait(100),
                new SceneEventSetActorSpriteExpression(DefinedActors.getActorByName("Juan"),"default"),
                new SceneEventWait(100),
                new SceneEventSetActorSpriteExpression(DefinedActors.getActorByName("Juan"),"smile2"),
                new SceneEventWait(100),
                new SceneEventSetActorSpriteExpression(DefinedActors.getActorByName("Juan"),"smile1"),

                new SceneEventDialog("Aku akan mencoba bangkit dan membangun karirku kembali.",DefinedActors.getActorByName("Juan")),
                new SceneEventShowCoverTransition(),
                new SceneEventSwitchScene("The Ending")

        )));

        scenes.add(new Scene("Love For Clara?",Arrays.asList(
                new SceneEventSetBackground("images/background/busy_office.png"),
                new SceneEventAddActorSprite(DefinedActors.getActorByName("Juan"),"default",ActorSprites.Position.BOTTOM_LEFT),
                new SceneEventAddActorSprite(DefinedActors.getActorByName("Clara"),"angry1",ActorSprites.Position.BOTTOM_RIGHT),
                new SceneEventDialog("..   .....   ......",DefinedActors.getActorByName("Clara")),
                new SceneEventSetActorSpriteExpression(DefinedActors.getActorByName("Clara"),"angry2"),
                new SceneEventSetActorSpriteExpression(DefinedActors.getActorByName("Juan"),"shocked"),
                new SceneEventDialog("Kau bahkan tidak punya waktu untuk makan malam bersama. Apa ini yang kau sebut hubungan?",DefinedActors.getActorByName("Clara")),
                new SceneEventWait(1000),
                new SceneEventSetActorSpriteExpression(DefinedActors.getActorByName("Juan"),"angry2"),
                new SceneEventDialog("Aku melakukan ini untuk masa depan kita.",DefinedActors.getActorByName("Juan")),
                new SceneEventWait(1000),
                new SceneEventChoice(
                        Map.of(
                                "Kurangi fokus pada pekerjaan untuk menjaga hubungan",13,/*The Ending*/
                                "Memprioritaskan pertumbuhan startup",15/*New Happiness*/
                        )
                ),

                new SceneEventShowCoverTransition(),
                new SceneEventSwitchScene("The Ending"),
                new SceneEventShowCoverTransition(),
                new SceneEventSwitchScene("New Happiness")

        )));

        scenes.add(new Scene("New Happiness",Arrays.asList(
                new SceneEventSetBackground("images/background/park_night.png"),
                new SceneEventAddActorSprite(DefinedActors.getActorByName("Juan"),"sad",ActorSprites.Position.BOTTOM_LEFT),
                new SceneEventDialog("..   ....   .......",DefinedActors.getActorByName("Juan")),
                new SceneEventAddActorSprite(DefinedActors.getActorByName("Nanda"),"default",ActorSprites.Position.BOTTOM_RIGHT),
                new SceneEventSetActorSpriteExpression(DefinedActors.getActorByName("Juan"),"default"),
                new SceneEventDialog("Kadang, Juan, kita harus melepas sesuatu untuk menemukan kebahagiaan sejati.",DefinedActors.getActorByName("nanda")),
                new SceneEventSetActorSpriteExpression(DefinedActors.getActorByName("Juan"),"angry2"),
                new SceneEventSetActorSpriteExpression(DefinedActors.getActorByName("Nanda"),"shocked"),
                new SceneEventDialog("Tapi aku sudah melepas banyak hal, Nanda. Aku hanya ingin memulai lagi.",DefinedActors.getActorByName("Juan")),

                new SceneEventChoice(
                        Map.of(
                                "Terima tawaran kerja di luar negeri",11,
                                "Memulai hidup baru di kota sendiri",13
                        )
                ),

                new SceneEventShowCoverTransition(),
                new SceneEventSwitchScene("The Ending"),
                new SceneEventShowCoverTransition(),
                new SceneEventSwitchScene("The Ending")

        )));

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
