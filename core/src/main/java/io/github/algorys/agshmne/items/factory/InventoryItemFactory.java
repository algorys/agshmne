package io.github.algorys.agshmne.items.factory;

import io.github.algorys.agshmne.inventory.InventoryItem;

public interface InventoryItemFactory {
	/**
	 * Crée une instance de base.
	 * 
	 * @return L'instance créée
	 */
	InventoryItem createDefault();

	/**
	 * Crée une instance avec des valeurs au hasard.
	 * 
	 * @return l'instance créée
	 */
	InventoryItem createRandom();
}
