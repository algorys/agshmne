package io.github.algorys.agshmne.map;

public class Position {
	public static final int MAX_X = 65;
	public static final int MIN_X = -65;
	public static final int MAX_Y = 65;
	public static final int MIN_Y = -65;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Position[" + this.x + ", " + this.y + "]";
	}
}
