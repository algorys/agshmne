package io.github.algorys.agshmne.items.factory;

import io.github.algorys.agshmne.items.potions.PotionMana;

public class PotionManaFactory implements InventoryItemFactory{

	@Override
	public PotionMana createDefault() {
		return new PotionMana();
	}

	@Override
	public PotionMana createRandom() {
		return this.createDefault() ;
	}

}
