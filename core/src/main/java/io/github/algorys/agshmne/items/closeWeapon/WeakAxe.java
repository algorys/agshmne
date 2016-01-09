package io.github.algorys.agshmne.items.closeWeapon;

import io.github.algorys.agshmne.inventory.InventoryItem;

public class WeakAxe implements Axe, InventoryItem {
	private final int level;
	
	public WeakAxe() {
		this.level = 1;
	}
	@Override
	public int getLevel() {
		return level;
	}

	@Override
	public String getName() {
		return "Hache";
	}

	@Override
	public int getWeight() {
		return 1;
	}
	
	@Override
	public String toString() {
		return "Hache renforcée ("+level+")";
	}
}
