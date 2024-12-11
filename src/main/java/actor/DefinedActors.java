package main.java.actor;

import java.util.*;

public class DefinedActors {
  private static List<Actor> actors = new ArrayList<>();

  static {
    actors.add(
            new Actor(
                    "Test:Rectangle",
                    Map.of(
                            "default", "images/actorsprite/testactor/rectangle_default.png",
                            "default_talk", "images/actorsprite/testactor/rectangle_default_talk.png"
                    )
            )
    );
    actors.add(
            new Actor(
                    "Test:Triangle",
                    Map.of(
                            "default", "images/actorsprite/testactor/triangle_default.png",
                            "default_talk", "images/actorsprite/testactor/triangle_default_talk.png"
                    )
            )
    );
    actors.add(
            new Actor(
                    "Test:Circle",
                    Map.of(
                            "default", "images/actorsprite/testactor/circle_default.png",
                            "default_talk", "images/actorsprite/testactor/circle_default_talk.png"
                    )
            )
    );
    actors.add(
            new Actor(
                    "Bos Rafi",
                    Map.of(
                            "angry1", "images/actorsprite/bosrafi/angry1.png",
                            "angry2", "images/actorsprite/bosrafi/angry2.png",
                            "default", "images/actorsprite/bosrafi/default.png",
                            "laugh", "images/actorsprite/bosrafi/laugh.png",
                            "sad", "images/actorsprite/bosrafi/sad.png",
                            "shocked", "images/actorsprite/bosrafi/shocked.png",
                            "smile1", "images/actorsprite/bosrafi/smile1.png",
                            "smile2", "images/actorsprite/bosrafi/smile2.png"
                    )
            )
    );
    actors.add(
              new Actor(
                      "Clara",
                      Map.of(
                              "angry1", "images/actorsprite/clara/angry1.png",
                              "angry2", "images/actorsprite/clara/angry2.png",
                              "annoyed", "images/actorsprite/clara/annoyed.png",
                              "crying", "images/actorsprite/clara/crying.png",
                              "default", "images/actorsprite/clara/default.png",
                              "delighted1", "images/actorsprite/clara/delighted.png",
                              "delighted2", "images/actorsprite/clara/delighted2.png",
                              "sad", "images/actorsprite/clara/sad.png",
                              "shocked", "images/actorsprite/clara/shocked.png",
                              "smile", "images/actorsprite/clara/smile1.png"
                      )
              )
    );
    actors.add(
              new Actor(
                      "Elena",
                      Map.of(
                              "annoyed", "images/actorsprite/elena/annoyed.png",
                              "crying", "images/actorsprite/elena/crying.png",
                              "default", "images/actorsprite/elena/default.png",
                              "delighted1", "images/actorsprite/elena/delighted.png",
                              "delighted2", "images/actorsprite/elena/delighted2.png",
                              "sad", "images/actorsprite/elena/sad.png",
                              "shocked", "images/actorsprite/elena/shocked.png",
                              "smile1", "images/actorsprite/elena/smile1.png",
                              "smile2", "images/actorsprite/elena/smile2.png"
                      )
              )
    );
    actors.add(
              new Actor(
                      "Ibu",
                      Map.of(
                              "default", "images/actorsprite/ibu/default.png",
                              "delighted1", "images/actorsprite/ibu/delighted.png",
                              "delighted2", "images/actorsprite/ibu/delighted2.png",
                              "smile1", "images/actorsprite/ibu/smile1.png",
                              "smile2", "images/actorsprite/ibu/smile2.png"
                      )
              )
    );
    actors.add(
              new Actor(
                      "Juan",
                      Map.of(
                              "angry1", "images/actorsprite/juan/angry1.png",
                              "angry2", "images/actorsprite/juan/angry2.png",
                              "default", "images/actorsprite/juan/default.png",
                              "laugh", "images/actorsprite/juan/laugh.png",
                              "sad", "images/actorsprite/juan/sad.png",
                              "shocked", "images/actorsprite/juan/shocked.png",
                              "smile1", "images/actorsprite/juan/smile1.png",
                              "smile2", "images/actorsprite/juan/smile2.png"
                      )
              )
      );
      actors.add(
              new Actor(
                      "Nanda",
                      Map.of(
                              "default", "images/actorsprite/nanda/default.png",
                              "shocked", "images/actorsprite/nanda/shocked.png",
                              "smile1", "images/actorsprite/nanda/smile1.png",
                              "smile2", "images/actorsprite/nanda/smile2.png"
                      )
              )
      );
  }

  public static Actor getActorByName(String name) {
    for (Actor actor : actors) {
      if (!actor.name.equals(name)) {
        continue;
      }
      return actor;
    }

    return null;
  }
}
