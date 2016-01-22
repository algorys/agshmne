package io.github.algorys.agshmne.items.lowQuest;

import io.github.algorys.agshmne.inventory.QuestItem;
import io.github.algorys.agshmne.movement.Position;

public class Letters implements QuestItem {
	private Position position;
	
	public Letters(Position position){
		this.position = position;
	}
	
	@Override
	public String getName() {
		return "Lettres";
	}

	@Override
	public int getWeight() {
		return 0;
	}

	@Override
	public Position getDestination() {
		return this.position;
	}

	@Override
	public Position setDestination(Position destination) {
		this.position = destination;
		return position;
	}

}
