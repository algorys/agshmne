package io.github.algorys.agshmne.items.stackable;

import io.github.algorys.agshmne.items.Item;

public interface IStackableItem extends Item {
	int getCount();
	
	public void addCount(int amount);
	
	public void removeCount(int amount);
}
