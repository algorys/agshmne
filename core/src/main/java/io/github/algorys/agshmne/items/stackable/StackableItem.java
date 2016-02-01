package io.github.algorys.agshmne.items.stackable;

import io.github.algorys.agshmne.items.Item;

public class StackableItem implements IStackableItem {
	private int count;
	private String name;
	
	public StackableItem(String name, int count) {
		this.name = name;
		this.count = count;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return (String) this.name;
	}
	
	@Override
	public int getCount() {
		return count;
	}

	@Override
	public boolean isSameType(Item other) {
		return (other instanceof IStackableItem) && this.name == other.getName();
	}

	@Override
	public void addCount(int amount) {
		if(amount < 0) throw new IllegalArgumentException("amount should be positive");
		count += amount;		
	}

	@Override
	public void removeCount(int amount) {
		if(amount < 0) throw new IllegalArgumentException("amount should be positive");
		if(amount > count) throw new IllegalStateException("You can't remove so many items from this stack");
		count -= amount;
	}
}
