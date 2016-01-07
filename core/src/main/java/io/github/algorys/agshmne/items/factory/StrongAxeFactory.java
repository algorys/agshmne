package io.github.algorys.agshmne.items.factory;

import io.github.algorys.agshmne.items.StrongAxe;

public class StrongAxeFactory implements InventoryItemFactory {

	@Override
	public StrongAxe createDefault() {
		return new StrongAxe();
	}

	@Override
	public StrongAxe createRandom() {
		return new StrongAxe(((int) (Math.random() * 10)) + 5);
	}

}
