package io.github.algorys.agshmne.quest;

import io.github.algorys.agshmne.character.Player;
import io.github.algorys.agshmne.events.quest.FetchQuest;
import io.github.algorys.agshmne.items.StackableItemDirectFactory;
import io.github.algorys.agshmne.map.region.Region;

public class FetchQuestTest {

	public static void main(String[] args) {
		Region region = new Region();
		Player pj = new Player(region);
		FetchQuest appleQ = new FetchQuest(pj, new StackableItemDirectFactory().createApple(), 3);
		System.out.println(appleQ.getGoal());
		
		boolean win = appleQ.isWin(pj);
		System.out.println("Quête finie ? " + win);
		for(int i = 0; i < 3; i++) {
			pj.getInventory().addItem(new StackableItemDirectFactory().createApple());
		}
		System.out.println("Il vous reste " + pj.getInventory().count(new StackableItemDirectFactory().createApple()) + " pommes !");
		win = appleQ.isWin(pj);
		System.out.println("Quête finie ? " + win);
		
		appleQ.terminate(pj);
		System.out.println("Il vous reste " + pj.getInventory().count(new StackableItemDirectFactory().createApple()) + " pommes !");

	}

}
