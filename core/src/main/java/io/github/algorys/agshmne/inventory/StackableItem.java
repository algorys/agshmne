package io.github.algorys.agshmne.inventory;

public interface StackableItem extends InventoryItem {
	public int getCount();
	
	public void addCount(int amount);
	
	public void removeCount(int amount);
}
