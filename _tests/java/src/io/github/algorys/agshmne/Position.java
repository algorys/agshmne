package io.github.algorys.agshmne;

public class Position {
	public static final int MAX_X = 4;
	public static final int MIN_X = -4;
	public static final int MAX_Y = 4;
	public static final int MIN_Y = -4;

	private final int x;
	private final int y;

	public Position(int x, int y) {
		if (x < MIN_X || x > MAX_X || y < MIN_Y || y > MAX_Y) {
			throw new IllegalArgumentException(
					String.format("(x,y) devrait être compris entre (%d, %d) et (%d, %d) mais (%d,%d) reçu.", MIN_X,
							MIN_Y, MAX_X, MAX_Y, x, y));
		}
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
