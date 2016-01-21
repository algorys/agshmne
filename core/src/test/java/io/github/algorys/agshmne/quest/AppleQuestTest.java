package io.github.algorys.agshmne.quest;

import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.items.fruits.Apple;
import io.github.algorys.agshmne.region.Region;

public class AppleQuestTest {

	public static void main(String[] args) {
		Region region = new Region();
		Character pj = new Character(region);
		AppleQuest appleQ = new AppleQuest(pj);
		System.out.println(appleQ.getGoal());
		
		boolean win = appleQ.isWin(pj);
		System.out.println("Quête finie ? " + win);
		for(int i = 0; i < 3; i++) {
			pj.getInventory().addItem(new Apple());
		}
		System.out.println("Il vous reste " + pj.getInventory().count(Apple.class) + " pommes !");
		win = appleQ.isWin(pj);
		System.out.println("Quête finie ? " + win);
		System.out.println("Il vous reste " + pj.getInventory().count(Apple.class) + " pommes !");
	}

}
