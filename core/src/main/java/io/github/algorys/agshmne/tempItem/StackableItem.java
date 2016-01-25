package io.github.algorys.agshmne.tempItem;

public interface StackableItem extends Item {
	int getCount();
	boolean isSameType(StackableItem item);
}
