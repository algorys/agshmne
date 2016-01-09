package io.github.algorys.agshmne.items.closeWeapon;

import io.github.algorys.agshmne.inventory.InventoryItem;

public class WeakSword implements Sword, InventoryItem{
	@Override
	public int getLevel() {
		return 1;
	}

	@Override
	public String getName() {
		return "Epée";
	}
	
	@Override
	public int getWeight() {
		return 1;
	}
}
