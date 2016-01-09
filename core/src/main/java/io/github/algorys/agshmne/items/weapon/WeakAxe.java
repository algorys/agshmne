package io.github.algorys.agshmne.items.weapon;

import io.github.algorys.agshmne.inventory.InventoryItem;

public class WeakAxe implements Axe, InventoryItem {

	@Override
	public int getLevel() {
		return 1;
	}

	@Override
	public String getName() {
		return "Hache de base";
	}

	@Override
	public int getWeight() {
		return 1;
	}

	
}
