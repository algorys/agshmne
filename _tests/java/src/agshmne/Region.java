package agshmne;

import java.util.Arrays;

public class Region {
	private final static int WIDTH = (Position.MAX_X - Position.MIN_X + 1);
	private final static int HEIGHT = (Position.MAX_Y - Position.MIN_Y + 1);
	private final static int SIZE = WIDTH * HEIGHT;
	private Tile[] tiles = new Tile[SIZE];

	public Region() {
		for (int i = 0; i < SIZE; i++) {
			TileType type = TileType.values()[agshmne.Outils.dice(TileType.values().length)];
			tiles[i] = new Tile(type);
			while (Math.random() < .5) {
				tiles[i].addItem(new Apple());
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
