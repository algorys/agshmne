package io.github.algorys.agshmne.items.misc;

import io.github.algorys.agshmne.inventory.StackableItemAdapter;
import io.github.algorys.agshmne.items.fruits.Apple;

public class Nail extends StackableItemAdapter {

	@Override
	public String getName() {
		return "Clou";
	}

	@Override
	public int getWeight() {
		return 0;
	}
	
	@Override
	public String toString() {
		return "Clou (" + Nail.this.getCount() + ")";
	}

}
