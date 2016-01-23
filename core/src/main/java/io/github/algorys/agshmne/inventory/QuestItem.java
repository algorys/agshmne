package io.github.algorys.agshmne.inventory;

import io.github.algorys.agshmne.movement.Position;

public interface QuestItem extends InventoryItem {
	
	public Position getDestination();
	
	public void setDestination(Position destination);

}
