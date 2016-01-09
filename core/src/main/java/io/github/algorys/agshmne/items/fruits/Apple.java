package io.github.algorys.agshmne.items.fruits;

import io.github.algorys.agshmne.inventory.StackableItemAdapter;

public class Apple extends StackableItemAdapter {

	@Override
	public String getName() {
		return "Pomme";
	}

	@Override
	public int getWeight() {
		return 1;
	}

	@Override
	public String toString() {
		return "Pomme";
	}
}
