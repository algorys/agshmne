package io.github.algorys.agshmne.region;

import java.util.Arrays;

import io.github.algorys.agshmne.city.factory.CityFactory;
import io.github.algorys.agshmne.inventory.InventoryFactory;
import io.github.algorys.agshmne.movement.Position;
import io.github.algorys.agshmne.tile.Tile;
import io.github.algorys.agshmne.tile.TileType;

public class Region {
	private final static int WIDTH = (Position.MAX_X - Position.MIN_X + 1);
	private final static int HEIGHT = (Position.MAX_Y - Position.MIN_Y + 1);
	final static int SIZE = WIDTH * HEIGHT;
	private Tile[] tiles = new Tile[SIZE];
	private int danger;
	

	Region(Tile[] tiles) {
		this.tiles = tiles;
	}

	public Region() {
		CityFactory cityFactory = new CityFactory();
		for (int i = 0; i < SIZE; i++) {
			TileType type = TileType.values()[io.github.algorys.agshmne.tools.Tools.dice(TileType.values().length)];
			if(Math.random() < .25) {
				tiles[i] = new Tile(type, cityFactory.createCity(type));
			} else {
				tiles[i] = new Tile(type);
			}

			while (Math.random() < .5) {
				InventoryFactory invFact = new InventoryFactory();
				tiles[i].addItem(invFact.getInventItem());
			}
		}
	}

	public Tile getTileFromPosition(Position p) {		
		int z = (p.getY() - Position.MIN_Y) * WIDTH + (p.getX() - Position.MIN_X);
		return tiles[z];
	}
	


	@Override
	public String toString() {
		return Arrays.toString(tiles);
	}
}
