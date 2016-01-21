package io.github.algorys.agshmne.quest;

import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.inventory.QuestItem;
import io.github.algorys.agshmne.movement.Position;
import io.github.algorys.agshmne.tools.Tools;

public class BringQuest {
	private Position questDestination;
	private Position  initialPos;
	
	public BringQuest(Character pj, QuestItem item, int count) {
		this.initialPos = pj.getPosition();
		questDestination = this.defineDestination(initialPos);
		pj.getInventory().addItem(item);
	}
	
	private Position defineDestination(Position position) {
		// TODO voir pour un algo plus précis
		int x1 = position.getX() - Tools.dice(10);
		int y1 = position.getX() + Tools.dice(10);
		Position questDestination = new Position(x1, y1);
		return questDestination;
	}
	
	public boolean isWin(Character pj) {
		return false;
	}
	
	public void terminate(Character pj) {
		
		}

	public Position getQuestDestination() {
		return questDestination;
	}

	public Position getInitialPos() {
		return initialPos;
	}
}
