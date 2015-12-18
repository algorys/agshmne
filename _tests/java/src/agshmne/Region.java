package agshmne;

import java.util.Arrays;

public class Region {
	private Tile[] tiles = new Tile[25];

	public Region() {
		for (int i = 0; i < 25; i++) {
			TileType type = TileType.values()[agshmne.Outils.dice(TileType.values().length)];
			tiles[i] = new Tile(type);
			while(Math.random() < .5) {
				tiles[i].addItem(new Apple());
			}
		}
	}
	
	@Override
	public String toString() {
		return Arrays.toString(tiles);
	}
}
