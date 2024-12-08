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
                    "Character C",
                    new HashMap<>()
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
