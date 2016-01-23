package io.github.algorys.agshmne.items.craft;

import io.github.algorys.agshmne.inventory.CraftItem;
import io.github.algorys.agshmne.inventory.StackableItemAdapter;

public class Pine extends StackableItemAdapter implements CraftItem, Wood {
	private WoodType type;
	
	public Pine() {
		type = WoodType.Pine;
	}
	@Override
	public String getName() {
		return "Bois de Pin";
	}

	@Override
	public int getWeight() {
		return 1;
	}
	
	@Override
	public String toString() {
		return "Bois de Pin (" + Pine.this.getCount() + ")";
	}

	@Override
	public WoodType getWoodType() {
		return type;
	}
}
