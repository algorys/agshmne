package io.github.algorys.agshmne.tempItem;

public interface IStackableItem extends Item {
	int getCount();
	
	boolean isSameType(IStackableItem item);
	
	public void addCount(int amount);
	
	public void removeCount(int amount);
}
