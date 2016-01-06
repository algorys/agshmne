package io.github.algorys.agshmne.objets;

import io.github.algorys.agshmne.inventory.InventoryItem;

public class Orange implements InventoryItem {

	@Override
	public String getName() {
		return "Orange";
	}

	@Override
	public int getWeight() {
		return 1;
	}

}
