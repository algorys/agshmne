package io.github.algorys.agshmne.sample.quest;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.events.quest.BringQuest;
import io.github.algorys.agshmne.items.GeneralItem;
import io.github.algorys.agshmne.map.Position;

public class BringQuestSample {

	public static void main(String[] args) {
		Player pj = new Player(null);
		BringQuest bringQ = new BringQuest(pj, new GeneralItem("Lettres"));
		Position questDestination = bringQ.getQuestDestination();
		boolean win = bringQ.isWin(pj);
		System.out.println("Quête finie ? " + win);
		System.out.println("Inventaire = " + pj.getInventory());
		// Mouvement vers la destination
		pj.setPosition(questDestination);
		win = bringQ.isWin(pj);
		System.out.println("Quête finie ? " + win);
		// Validation de la quêtes
		bringQ.terminate(pj);
		System.out.println("Inventaire = " + pj.getInventory());

	}

}
