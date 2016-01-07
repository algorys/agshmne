package io.github.algorys.agshmne.objets;

import io.github.algorys.agshmne.inventory.StackableItemAdapter;

public class Orange extends StackableItemAdapter  {

	@Override
	public String getName() {
		return "Orange";
	}

	@Override
	public int getWeight() {
		return 1;
	}

}
