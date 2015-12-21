package io.github.algorys.agshmne.region;

import io.github.algorys.agshmne.Apple;
import io.github.algorys.agshmne.InventoryItem;
import io.github.algorys.agshmne.Tile;
import io.github.algorys.agshmne.TileType;

public class AquaticRegionFactory implements RegionFactory {

	@Override
	public Region create() {
		TileType[] possibles = {TileType.Eau, TileType.Ville};
		Tile[] tiles = new Tile[Region.SIZE];
		for (int i = 0; i < Region.SIZE; i++) {
			TileType type = possibles[io.github.algorys.agshmne.Outils.dice(possibles.length)];
			tiles[i] = new Tile(type);
			while (Math.random() < .2) {
				InventoryItem e = new Apple();
				tiles[i].addItem(e);
			}
		}
		return new Region(tiles);
	}

}
