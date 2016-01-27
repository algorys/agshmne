package io.github.algorys.agshmne.quest;

import io.github.algorys.agshmne.character.Player;
import io.github.algorys.agshmne.events.quest.BringQuest;
import io.github.algorys.agshmne.items.ItemDirectFactory;
import io.github.algorys.agshmne.map.Position;
import io.github.algorys.agshmne.map.region.Region;

public class BringQuestTest {

	public static void main(String[] args) {
		Region region = new Region();
		Player pj = new Player(region);
		BringQuest bringQ = new BringQuest(pj, new ItemDirectFactory().createLetters());
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
