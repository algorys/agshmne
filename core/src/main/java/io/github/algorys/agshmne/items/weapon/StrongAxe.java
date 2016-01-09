package io.github.algorys.agshmne.items.weapon;

import io.github.algorys.agshmne.inventory.InventoryItem;

public class StrongAxe implements Axe, InventoryItem {
	private final int level;

	public StrongAxe() {
		this.level = 5;
	}

	public StrongAxe(int level) {
		this.level = level;
	}

	@Override
	public int getLevel() {
		return level;
	}

	@Override
	public String getName() {
		return "Hache renforcée";
	}

	@Override
	public int getWeight() {
		return 3;
	}
	
	@Override
	public String toString() {
		return "StrongAxe("+level+")";
	}
}
