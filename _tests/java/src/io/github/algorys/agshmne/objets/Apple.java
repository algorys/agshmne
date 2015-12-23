package io.github.algorys.agshmne.objets;

import io.github.algorys.agshmne.inventory.InventoryItem;

public class Apple implements InventoryItem {

	@Override
	public String getName() {
		return "Pomme";
	}

	@Override
	public int getWeight() {
		return 1;
	}

}
