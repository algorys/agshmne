package io.github.algorys.agshmne.events.quest;

import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.items.Item;
import io.github.algorys.agshmne.movement.Position;

public class FetchQuest {
	private Position questPosition;
	private Item item;
	private int count;

	public FetchQuest(Character pj, Item item, int count) {
		this.questPosition = pj.getPosition();
		this.count = count;
		this.item = item;
	}
	
	public boolean isWin(Character pj) {
		return (pj.getInventory().count(item) >= count) ;
	}
	
	public void terminate(Character pj) {
		for(int i = 0; i < count; i ++) {
			pj.getInventory().removeItem(item);
		}
		
		// TODO Rajouter une récompense
	}

	public String getName() {
		return "Trouver des " + item.getName();
	}

	public String getGoal() {
		return "Vous devez trouvez au moins " + count + " "+item.getName()+" et les rapporter en ("
	+ questPosition.getX() + ", " 
	+ questPosition.getY() + ")";
	}

	public Position getQuestPosition() {
		return questPosition;
	}
}
