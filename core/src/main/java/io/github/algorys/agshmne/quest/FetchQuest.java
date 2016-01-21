package io.github.algorys.agshmne.quest;

import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.inventory.StackableItem;
import io.github.algorys.agshmne.movement.Position;

public class FetchQuest {
	private Position questPosition;
	private Class<? extends StackableItem> type;
	private int count;

	public FetchQuest(Character pj, Class<? extends StackableItem> type, int count) {
		this.questPosition = pj.getPosition();
		this.count = count;
		this.type = type;
	}
	
	public boolean isWin(Character pj) {
		return (pj.getInventory().count(type) >= count) ;
	}
	
	public void terminate(Character pj) {
		
		try {
			StackableItem item = type.newInstance();
			item.addCount(count - 1);
			pj.getInventory().removeItem(item);
		} catch (InstantiationException e) {
			e.printStackTrace(); // FIXME
		} catch (IllegalAccessException e) {
			e.printStackTrace(); // FIXME
		}
		
		// TODO Rajouter une récompense
	}

	public String getName() {
		return "Trouver des " + type.getSimpleName();
	}

	public String getGoal() {
		return "Vous devez trouvez au moins " + count + " "+type.getSimpleName()+" et les rapporter en ("
	+ questPosition.getX() + ", " 
	+ questPosition.getY() + ")";
	}

	public Position getQuestPosition() {
		return questPosition;
	}
}
