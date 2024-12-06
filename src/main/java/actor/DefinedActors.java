package main.java.actor;

import main.java.scene.Scene;

import java.util.ArrayList;
import java.util.List;

public class DefinedActors {
  private static List<Actor> actors = new ArrayList<>();

  static {
    actors.add(
            new Actor(
                    "Character A"
            )
    );
    actors.add(
            new Actor(
                    "Character B"
            )
    );
    actors.add(
            new Actor(
                    "Character C"
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
