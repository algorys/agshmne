package io.github.algorys.agshmne.items.craft.wood;

import io.github.algorys.agshmne.inventory.CraftItem;
import io.github.algorys.agshmne.inventory.StackableItemAdapter;

public class Pine extends StackableItemAdapter implements CraftItem, Wood {

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
		return WoodType.Pine;
	}
}
