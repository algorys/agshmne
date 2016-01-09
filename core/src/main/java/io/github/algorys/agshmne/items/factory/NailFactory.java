package io.github.algorys.agshmne.items.factory;

import io.github.algorys.agshmne.inventory.InventoryItem;
import io.github.algorys.agshmne.items.misc.Nail;

public class NailFactory implements InventoryItemFactory {

	@Override
	public Nail createDefault() {
		return new Nail();
	}

	@Override
	public Nail createRandom() {
		return this.createDefault();
	}

}
