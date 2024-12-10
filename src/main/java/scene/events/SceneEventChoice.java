package main.java.scene.events;

import main.java.scene.ScenePlayer;
import main.java.visual.NovelWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SceneEventChoice extends SceneEvent {
    public Map<String, Integer> choicesToJumpIndex;

    public SceneEventChoice(Map<String, Integer> choicesToJumpIndex) {
        this.choicesToJumpIndex = choicesToJumpIndex;
    }

    @Override
    public void execute(ScenePlayer scenePlayer, NovelWindow novelWindow, Runnable onFinish) {
        List<String> orderedChoices = new ArrayList<>(choicesToJumpIndex.keySet());

        System.out.println("Pick a choice!");
        for (int i = 0; i < orderedChoices.size(); i++) {
            System.out.println((i + 1) + ": " + orderedChoices.get(i));
        }

        Scanner input = new Scanner(System.in);
        System.out.println("[1-" + orderedChoices.size() + "]: ");

        int choiceIndex = input.nextInt();
        String choice = orderedChoices.get(choiceIndex - 1);

        if (choice == null) {
            System.out.println("Invalid input not handled yet! Defaulting to first choice!");
            choice = orderedChoices.getFirst();
        }

        SceneEventJump.jumpScenePlayer(scenePlayer, choicesToJumpIndex.get(choice));
        onFinish.run();
    }
}