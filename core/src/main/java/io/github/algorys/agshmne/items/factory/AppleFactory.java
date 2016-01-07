package io.github.algorys.agshmne.objets.factory;

import io.github.algorys.agshmne.objets.Apple;

/**
 * Fabrique de pommes.
 * 
 * Note: <code>createDefault</code> et <code>createRandom</code> renvoit la
 * valeur par défaut, il n'y a qu'un seul type de pomme dans le jeu.
 */
public class AppleFactory implements InventoryItemFactory {

	@Override
	public Apple createDefault() {
		return new Apple();
	}

	@Override
	public Apple createRandom() {
		return this.createDefault();
	}

}
