package io.github.algorys.agshmne.events.quest;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.items.Item;
import io.github.algorys.agshmne.map.Position;

public class FetchQuest implements IQuest {
	private Position questPosition;
	private Item item;
	private int count;
	private boolean finish = false;

	public FetchQuest(Player pj, Item item, int count) {
		this.questPosition = pj.getPosition();
		this.count = count;
		this.item = item;
	}
	
	@Override
	public boolean isWin(Player pj) {
		return (pj.getInventory().count(item) >= count) ;
	}
	@Override
	public void reward(Player pj) {
		for(int i = 0; i < count; i ++) {
			pj.getInventory().removeItem(item);
		}
		finish = true;
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

	@Override
	public boolean isFinish() {
		return finish;
	}
}
