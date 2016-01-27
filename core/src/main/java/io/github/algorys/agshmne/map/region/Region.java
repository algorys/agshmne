package io.github.algorys.agshmne.map.region;

import java.util.Arrays;

import io.github.algorys.agshmne.items.ItemFactory;
import io.github.algorys.agshmne.map.Position;
import io.github.algorys.agshmne.map.city.factory.CityFactory;
import io.github.algorys.agshmne.map.tile.Tile;
import io.github.algorys.agshmne.map.tile.TileType;

public class Region {
	private final static int WIDTH = (Position.MAX_X - Position.MIN_X + 1);
	private final static int HEIGHT = (Position.MAX_Y - Position.MIN_Y + 1);
	final static int SIZE = WIDTH * HEIGHT;
	private Tile[] tiles = new Tile[SIZE];
	
	public Region() {
		CityFactory cityFactory = new CityFactory();
		DescFactory descFactory = new DescFactory();
		for (int i = 0; i < SIZE; i++) {
			Tile currentTile;
			
			currentTile = createOneTile(cityFactory, descFactory);

			tiles[i] = currentTile;
		}
	}

	private Tile createOneTile(CityFactory cityFactory, DescFactory descFactory) {
		Tile currentTile;
		TileType type = TileType.values()[io.github.algorys.agshmne.tools.Tools.dice(TileType.values().length)];
		String desc = descFactory.randomDesc(type);
		if(Math.random() < .25) {
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

	public Tile getTileFromPosition(Position p) {		
		int z = (p.getY() - Position.MIN_Y) * WIDTH + (p.getX() - Position.MIN_X);
		return tiles[z];
	}
	


	@Override
	public String toString() {
		return Arrays.toString(tiles);
	}
}
