package io.github.algorys.agshmne.map.region;

import java.util.Arrays;

import io.github.algorys.agshmne.map.Position;
import io.github.algorys.agshmne.map.tile.Tile;
import io.github.algorys.agshmne.map.tile.TileFactory;

public class Region {
	private final static int WIDTH = (Position.MAX_X - Position.MIN_X + 1);
	private final static int HEIGHT = (Position.MAX_Y - Position.MIN_Y + 1);
	final static int SIZE = WIDTH * HEIGHT;
	private Tile[] tiles = new Tile[SIZE];
	private int turn = 1;

	public Region(TileFactory tileFactory) {
		for (int i = 0; i < SIZE; i++) {
			tiles[i] = tileFactory.createTile();
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
	
	public void newTurn() {
		turn += 1;
	}

	public int getTurn() {
		return turn;
	}
}
