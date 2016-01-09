package io.github.algorys.agshmne.items.factory;

import io.github.algorys.agshmne.inventory.InventoryItem;
import io.github.algorys.agshmne.items.fruits.Orange;

public class OrangeFactory implements InventoryItemFactory {

	@Override
	public Orange createDefault() {
		return new Orange();
	}

	@Override
	public Orange createRandom() {
		return this.createDefault();
	}

}
