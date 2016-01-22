package io.github.algorys.agshmne.quest;

import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.inventory.QuestItem;
import io.github.algorys.agshmne.movement.Position;
import io.github.algorys.agshmne.movement.RandomCoordinated;

public class BringQuest {
	private Position questDestination;
	private Position initialPos;
	private QuestItem itemQ;
	
	public BringQuest(Character pj, QuestItem item) {
		this.initialPos = pj.getPosition();
		this.questDestination = this.defineDestination(initialPos);
		this.itemQ = item;
		// TODO gérer les objets de quêtes différement des objets normaux.
		pj.getInventory().addItem(item);
	}
	
	private Position defineDestination(Position position) {
		int maxX = position.getX() + 10;
		int minX = position.getX() - 10;
		int maxY = position.getX() + 10;
		int minY = position.getX() - 10;
		RandomCoordinated newY = new RandomCoordinated(maxY, minY);
		RandomCoordinated newX = new RandomCoordinated(maxX, minX);	
		Position questDestination = new Position(newX.getCoordinated(), newY.getCoordinated());
		return questDestination;
	}
	
	public boolean isWin(Character pj) {
		return pj.getPosition() == questDestination && pj.getInventory().contains(itemQ.getClass());
	}
	
	public void terminate(Character pj) {
		pj.getInventory().removeItem(itemQ);
		// TODO prévoir une récompense.
	}

	public Position getQuestDestination() {
		return questDestination;
	}

	public Position getInitialPos() {
		return initialPos;
	}
}
