package io.github.algorys.agshmne.items.craft;

import io.github.algorys.agshmne.inventory.CraftItem;
import io.github.algorys.agshmne.inventory.StackableItemAdapter;

public class lowOre extends StackableItemAdapter implements CraftItem {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Minerai de mauvaise qualité";
	}

	@Override
	public int getWeight() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String toString() {
		return "Minerai de mauvaise qualité (" + lowOre.this.getCount() + ")";
	}

}
