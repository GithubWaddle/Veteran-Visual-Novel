package main.java.scene;

import main.java.actor.DefinedActors;
import main.java.scene.events.*;
import main.java.visual.actorsprite.ActorSprites;

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
                    new SceneEventWait(1000),
                    new SceneEventHideCoverTransition(),
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
                            "Home Thoughts of Decision"
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
                        ),
                        new SceneEventDialog(
                                "Belum, Bu. Aku bingung. Tawaran itu bagus, tapi ada Clara... dia ingin kita mencoba lagi.",
                                "Juan"
                        ),
                        new SceneEventDialog(
                                "Hidup memang penuh pilihan sulit. Tapi, kau harus tahu apa yang membuatmu bahagia. Apakah karir besar di luar negeri, atau seseorang yang kau cintai di sini?",
                                "Ibu"
                        ),
                        new SceneEventDialog(
                                "Tapi kalau aku memilih Clara dan gagal? Atau kalau aku pergi dan merasa kesepian?",
                                "Juan"
                        ),
                        new SceneEventDialog(
                                "Hanya kau yang bisa menjawab itu, Nak. Tapi, ingat ini: kebahagiaan sejati tidak diukur dari uang atau jabatan. Itu tentang perasaanmu saat bangun di pagi hari.",
                                "Ibu"
                        ),
                        new SceneEventShowCoverTransition(),
                        new SceneEventSwitchScene(
                                "Career or Love"
                        )
                )
        ));

        scenes.add(new Scene(
                "Career or Love",
                Arrays.asList(
                        new SceneEventSetBackground(
                                "images/background/park.png"
                        ),
                        new SceneEventAddActorSprite(
                                "Juan",
                                "default",
                                ActorSprites.Position.BOTTOM_LEFT
                        ),
                        new SceneEventAddActorSprite(
                                "Clara",
                                "default",
                                ActorSprites.Position.BOTTOM_RIGHT
                        ),
                        new SceneEventWait(1000),
                        new SceneEventHideCoverTransition(),
                        new SceneEventDialog(
                                "Juan, terima kasih sudah datang. Aku tahu kamu pasti sibuk.",
                                "Clara"
                        ),
                        new SceneEventDialog(
                                "Aku selalu punya waktu untukmu, Clara. Bagaimana kabarmu?",
                                "Juan"
                        ),
                        new SceneEventDialog(
                                "Aku baik, tapi jujur saja, aku masih memikirkan pesan yang kukirimkan kemarin. Aku ingin kita bicara tentang... kita.",
                                "Clara"
                        ),
                        new SceneEventDialog(
                                "Aku tahu. Pesanmu membuatku banyak berpikir. Tapi aku juga sedang dihadapkan pada pilihan besar di pekerjaannya.",
                                "Juan"
                        ),
                        new SceneEventDialog(
                                "Aku hanya ingin tahu, Juan... apa aku masih menjadi bagian dari pilihanmu?",
                                "Clara"
                        ),
                        new SceneEventChoice(
                                Map.of(
                                        "Pilih karir di luar negeri", 11,
                                        "Tetap tinggal dan mengejar hubungan dengan Clara", 13
                                )
                        ),
                        new SceneEventShowCoverTransition(),
                        new SceneEventSwitchScene(
                                "Career Focus"
                        ),
                        new SceneEventShowCoverTransition(),
                        new SceneEventSwitchScene(
                                "Failed Career Focus"
                        )
                )
        ));

        scenes.add(new Scene(
                "Career Focus",
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
                                "Bos Rafi",
                                "default",
                                ActorSprites.Position.BOTTOM_RIGHT
                        ),
                        new SceneEventWait(1000),
                        new SceneEventHideCoverTransition(),
                        new SceneEventDialog(
                                "Juan, kita sedang berada di jalur yang tepat, tapi aku membutuhkan komitmenmu sepenuhnya. Ini kesempatan besar untuk kita. Apa kau siap mengambil tantangan ini?",
                                "Bos Rafi"
                        ),
                        new SceneEventDialog(
                                "Tentu, Pak. Saya akan pastikan proyek ini sukses.",
                                "Juan"
                        ),
                        new SceneEventDialog(
                                "Aku tahu kau bisa melakukannya. Jangan lupa, Juan, kadang kita harus menemukan keseimbangan dalam hidup kita, bukan hanya karir. Jangan sampai pekerjaan menguasai segalanya.",
                                "Bos Rafi"
                        ),
                        new SceneEventShowCoverTransition(),
                        new SceneEventSwitchScene(
                                "Elena Love?"
                        )
                )
        ));

        scenes.add(new Scene(
                "Elena Love?",
                Arrays.asList(
                        new SceneEventSetBackground(
                                "images/background/cafe.png"
                        ),
                        new SceneEventAddActorSprite(
                                "Juan",
                                "default",
                                ActorSprites.Position.BOTTOM_LEFT
                        ),
                        new SceneEventAddActorSprite(
                                "Elena",
                                "default",
                                ActorSprites.Position.BOTTOM_RIGHT
                        ),
                        new SceneEventWait(1000),
                        new SceneEventHideCoverTransition(),
                        new SceneEventDialog(
                                "Juan, hidup bukan cuma soal kerja. Apa kau pernah berpikir tentang apa yang benar-benar kau inginkan?",
                                "Elena"
                        ),
                        new SceneEventDialog(
                                "Aku ingin sukses. Aku ingin memastikan hidupku berarti.",
                                "Juan"
                        ),
                        new SceneEventDialog(
                                "Tapi sukses tanpa kebahagiaan itu kosong, Juan.",
                                "Elena"
                        ),
                        new SceneEventChoice(
                                Map.of(
                                        "Mengejar hubungan dengan Elena", 9,
                                        "Tetap tinggal dan mengejar hubungan dengan Clara", 14
                                )
                        ),
                        new SceneEventDialog(
                                "Elena, aku merasa ada koneksi yang kuat antara kita.",
                                "Juan"
                        ),
                        new SceneEventDialog(
                                "Kita bisa saling mendukung dan membuat hidup kita lebih berarti.",
                                "Elena"
                        ),
                        new SceneEventChoice(
                                Map.of(
                                        "Kurangi fokus pada pekerjaan untuk Elena", 12,
                                        "Tetap prioritaskan startup", 14
                                )
                        ),
                        new SceneEventShowCoverTransition(),
                        new SceneEventSwitchScene(
                                "The Ending"
                        ),
                        new SceneEventShowCoverTransition(),
                        new SceneEventSwitchScene(
                                "Still Career Focus"
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
