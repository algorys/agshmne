package io.github.algorys.agshmne.objets;

import io.github.algorys.agshmne.inventory.InventoryItem;

public class StrongAxe implements Axe, InventoryItem {

	@Override
	public int getLevel() {
		return 5;
	}

	@Override
	public String getName() {
		return "Hache renforcée";
	}

	@Override
	public int getWeight() {
		return 3;
	}
}
