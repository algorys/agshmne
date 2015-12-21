package io.github.algorys.agshmne;

import io.github.algorys.agshmne.region.Region;

/*
 * Définit le Personnage
 */
public class Personnage {
	public static enum Direction {
		NORTH, EAST, SOUTH, WEST
	}

	private Position position = new Position(0, 0);
	private Region region;

	public Personnage(Region region) {
		this.region = region;
	}

	public Position getPosition() {
		return position;
	}

	public Region getRegion() {
		return this.region;
	}

	public void move(Direction direction) {
		switch (direction) {
		case NORTH:
			if(this.position.getY() < Position.MAX_Y) {
				this.position = new Position(this.position.getX(), this.position.getY() + 1);
			} else {
				// changer de region (si possible?)
				// partir du bas de la region
			}
			break;
		case EAST:
			if(this.position.getX() < Position.MAX_X) {
				this.position = new Position(this.position.getX() + 1, this.position.getY());
			} else {
				// changer de region (si possible?)
				// partir de l'ouest de la region
			}
			break;
		case SOUTH:
			if(this.position.getY() > Position.MIN_Y) {
				this.position = new Position(this.position.getX(), this.position.getY() -1);
			} else {
				// changer de region (si possible?)
				// partir du haut de la region
			}
			break;
		case WEST:
			if(this.position.getX() > Position.MIN_X) {
				this.position = new Position(this.position.getX() -1, this.position.getY());
			} else {
				// changer de region (si possible?)
				// partir de l'est de la region
			}
			break;
		}
	}
}
