package io.github.algorys.agshmne.map.tile;

import io.github.algorys.agshmne.items.ItemFactory;
import io.github.algorys.agshmne.map.city.factory.CityFactory;
import io.github.algorys.agshmne.map.region.DescFactory;
import io.github.algorys.agshmne.tools.Tools;

public class RandomTileFactory implements TileFactory {
	private DescFactory descFactory = new DescFactory();
	private CityFactory cityFactory = new CityFactory();

	/* (non-Javadoc)
	 * @see io.github.algorys.agshmne.map.tile.TileFactory#createTile()
	 */
	@Override
	public Tile createTile() {
		Tile currentTile;
		TileType type = TileType.values()[Tools.dice(TileType.values().length)];
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
		
		if (Math.random() <.25) {
			currentTile.setDanger(true);
		}
		return currentTile;
	}
}
