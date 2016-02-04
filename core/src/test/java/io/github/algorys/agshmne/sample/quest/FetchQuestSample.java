package io.github.algorys.agshmne.sample.quest;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.events.quest.FetchQuest;
import io.github.algorys.agshmne.items.stackable.StackableItem;

public class FetchQuestSample {

	public static void main(String[] args) {
		Player pj = new Player(null);
		FetchQuest appleQ = new FetchQuest(pj, new StackableItem("Pomme", 1, 5), 3);
		System.out.println(appleQ.getGoal());

		boolean win = appleQ.isWin(pj);
		System.out.println("Quête finie ? " + win);
		for (int i = 0; i < 3; i++) {
			pj.getInventory().addItem(new StackableItem("Pomme", 1, 5));
		}
		System.out.println("Il vous reste " + pj.getInventory().count(new StackableItem("Pomme", 1, 5)) + " pommes !");
		win = appleQ.isWin(pj);
		System.out.println("Quête finie ? " + win);

		appleQ.reward(pj);
		System.out.println("Il vous reste " + pj.getInventory().count(new StackableItem("Pomme", 1, 5)) + " pommes !");

	}

}
