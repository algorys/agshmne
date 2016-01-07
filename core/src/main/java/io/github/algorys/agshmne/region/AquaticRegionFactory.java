package io.github.algorys.agshmne.region;

import io.github.algorys.agshmne.inventory.InventoryItem;
import io.github.algorys.agshmne.items.Apple;
import io.github.algorys.agshmne.tile.Tile;
import io.github.algorys.agshmne.tile.TileType;

public class AquaticRegionFactory implements RegionFactory {

	@Override
	public Region create() {
		TileType[] possibles = {TileType.Water, TileType.Wood};
		Tile[] tiles = new Tile[Region.SIZE];
		for (int i = 0; i < Region.SIZE; i++) {
			TileType type = possibles[io.github.algorys.agshmne.outils.Outils.dice(possibles.length)];
			tiles[i] = new Tile(type);
			while (Math.random() < .2) {
				InventoryItem e = new Apple();
				tiles[i].addItem(e);
			}
		}
		return new Region(tiles);
	}

}
