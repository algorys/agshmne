package io.github.algorys.agshmne.region;

import java.util.Arrays;

import io.github.algorys.agshmne.Apple;
import io.github.algorys.agshmne.InventoryItem;
import io.github.algorys.agshmne.Position;
import io.github.algorys.agshmne.Tile;
import io.github.algorys.agshmne.TileType;

public class Region {
	private final static int WIDTH = (Position.MAX_X - Position.MIN_X + 1);
	private final static int HEIGHT = (Position.MAX_Y - Position.MIN_Y + 1);
	final static int SIZE = WIDTH * HEIGHT;
	private Tile[] tiles = new Tile[SIZE];

	Region(Tile[] tiles) {
		this.tiles = tiles;
	}

	public Region() {
		for (int i = 0; i < SIZE; i++) {
			TileType type = TileType.values()[io.github.algorys.agshmne.Outils.dice(TileType.values().length)];
			tiles[i] = new Tile(type);
			while (Math.random() < .5) {
				InventoryItem e = new Apple();
				tiles[i].addItem(e);
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
