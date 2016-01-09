package io.github.algorys.agshmne.items.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.github.algorys.agshmne.inventory.InventoryItem;
import io.github.algorys.agshmne.items.fruits.Apple;

public class RandomFactory implements InventoryItemFactory {

	private List<InventoryItemFactory> factories = new ArrayList<>();
	
	@Override
	public InventoryItem createDefault() {
		return new Apple();
	}

	@Override
	public InventoryItem createRandom() {
		int factoryIndex = new Random().nextInt(factories.size());
		InventoryItemFactory chosenFactory = factories.get(factoryIndex);
		return chosenFactory.createRandom();
	}

	public void addFactory(InventoryItemFactory factory) {
		this.factories.add(factory);
	}
}
