package io.github.algorys.agshmne.inventory;

public abstract class StackableItemAdapter implements StackableItem {
	protected int count = 1;

	@Override
	public int getCount() {
		return count;
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
