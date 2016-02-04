package io.github.algorys.agshmne.items;

public interface Item {
	public String getName();
	public String toString();
	public boolean isSameType(Item item);
	public int getPrice();
}
