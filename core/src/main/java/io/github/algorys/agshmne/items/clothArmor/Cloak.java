package io.github.algorys.agshmne.items.clothArmor;

import io.github.algorys.agshmne.inventory.InventoryItem;

public class Cloak implements Cloth, InventoryItem {
	private final int level;
	
	public Cloak() {
		this.level = 1;
	}
	
	@Override
	public int getLevel() {
		return level;
	}
	
	@Override
	public String getName() {
		return "Manteau ("+this.getLevel()+")";
	}
	
	@Override
	public String toString(){
		return "Manteau ("+level+")";
	}

	@Override
	public int getWeight() {
		// TODO Auto-generated method stub
		return 0;
	}

}
