package io.github.algorys.agshmne.quest;

import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.items.fruits.Apple;
import io.github.algorys.agshmne.movement.Position;

public class AppleQuest {
	private Position questPosition;
	private Apple apple;
	
	public AppleQuest(Character pj) {
		this.questPosition = pj.getPosition();
	}
	
	public boolean isWin(Character pj) {
		if(pj.getInventory().count(Apple.class) >= 3) {
			for(int i = 0; i < 3; i++) {
				apple = new Apple();
				pj.getInventory().removeItem(apple);
			}
			return true;
		}
		return false;
	}

	public String getName() {
		return "Trouver des Pommes";
	}

	public String getGoal() {
		return "Vous devez trouvez au moins 3 pommes et les rapporter en ("
	+ questPosition.getX() + ", " 
	+ questPosition.getY() + ")";
	}

	public Position getQuestPosition() {
		return questPosition;
	}
}
