package io.github.algorys.agshmne.items.factory;

import io.github.algorys.agshmne.items.clothArmor.Cloak;

public class CloakFactory implements InventoryItemFactory{

	@Override
	public Cloak createDefault() {
		return new Cloak();
	}

	@Override
	public Cloak createRandom() {
		return this.createDefault();
	}

}
