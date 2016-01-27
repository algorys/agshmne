package io.github.algorys.agshmne.map.tile;

import io.github.algorys.agshmne.items.ItemFactory;
import io.github.algorys.agshmne.map.city.factory.CityFactory;
import io.github.algorys.agshmne.map.region.DescFactory;

public class TileFactory {
	private DescFactory descFactory = new DescFactory();
	private CityFactory cityFactory = new CityFactory();

	public Tile createRandomTile() {
		Tile currentTile;
		TileType type = TileType.values()[io.github.algorys.agshmne.tools.Tools.dice(TileType.values().length)];
		String desc = descFactory.randomDesc(type);
		if (Math.random() < .25) {
			currentTile = new Tile(type, desc, cityFactory.createCity(type));
		} else {
			currentTile = new Tile(type, desc);
		}

		while (Math.random() < .3) {
			ItemFactory itemFact = new ItemFactory();
			currentTile.addItem(itemFact.createItem());
		}
		return currentTile;
	}
}
