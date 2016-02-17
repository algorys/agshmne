package io.github.algorys.agshmne.map.region;

import java.util.Arrays;

import io.github.algorys.agshmne.map.Position;
import io.github.algorys.agshmne.map.tile.Tile;
import io.github.algorys.agshmne.map.tile.TileFactory;

public class Region {
	private final static int WIDTH = (Position.MAX_X - Position.MIN_X + 1);
	private final static int HEIGHT = (Position.MAX_Y - Position.MIN_Y + 1);
	private final static int SIZE = WIDTH * HEIGHT;
	private Tile[] tiles = new Tile[SIZE];

	public Region(TileFactory tileFactory) {
		for(int x = Position.MIN_X; x <= Position.MAX_X; x++) {
			for(int y = Position.MIN_Y; y <= Position.MAX_Y; y++) {
				Position position = new Position(x,y);
				tiles[positionToIndex(position)] = tileFactory.createTile(position);
			}
		}
	}

	public Tile getTileFromPosition(Position p) {
		return tiles[positionToIndex(p)];
	}

	private int positionToIndex(Position p) {
		int z = (p.getY() - Position.MIN_Y) * WIDTH + (p.getX() - Position.MIN_X);
		return z;
	}

	@Override
	public String toString() {
		return Arrays.toString(tiles);
	}
}
