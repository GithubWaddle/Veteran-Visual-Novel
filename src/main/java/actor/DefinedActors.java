package main.java.actor;

import java.util.*;

public class DefinedActors {
  private static List<Actor> actors = new ArrayList<>();

  static {
    actors.add(
            new Actor(
                    "Character A",
                    new HashMap<>()
            )
    );
    actors.add(
            new Actor(
                    "Character B",
                    new HashMap<>()
            )
    );
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

  /*
  Nama semua aktor harus unik.
  Todo: tambah fungsionalitas keunikan nama aktor dalam list `actors`
   */
}
