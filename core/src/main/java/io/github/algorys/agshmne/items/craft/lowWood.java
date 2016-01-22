package io.github.algorys.agshmne.items.craft;

import io.github.algorys.agshmne.inventory.CraftItem;
import io.github.algorys.agshmne.inventory.StackableItemAdapter;

public class lowWood extends StackableItemAdapter implements CraftItem {

	@Override
	public String getName() {
		return "Bois de mauvaise qualité";
	}

	@Override
	public int getWeight() {
		return 0;
	}
	
	@Override
	public String toString() {
		return "Bois de mauvaise qualité (" + lowWood.this.getCount() + ")";
	}
}
