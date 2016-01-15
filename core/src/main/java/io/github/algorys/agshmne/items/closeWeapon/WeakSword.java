package io.github.algorys.agshmne.items.closeWeapon;

import io.github.algorys.agshmne.inventory.InventoryItem;

public class WeakSword implements Sword, InventoryItem{
	private final int level;
	
	public WeakSword() {
		this.level = 1;
	}
	@Override
	public int getLevel() {
		return level;
	}

	@Override
	public String getName() {
		return "Epée ("+this.getLevel()+")";
	}
	
	@Override
	public int getWeight() {
		return 1;
	}
	
	@Override
	public String toString() {
		return "Epée ["+level+"]";
	}
}
