package io.github.algorys.agshmne;

import io.github.algorys.agshmne.region.Region;

/*
 * Définit le Personnage
 */
public class Personnage {
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
	
	public void setPosition(Position position) {
		this.position = position;
	}
//	public void move(Direction direction) {
//		switch (direction) {
//		case NORTH:
//			if(this.position.getY() < Position.MAX_Y) {
//				this.position = new Position(this.position.getX(), this.position.getY() + 1);
//			} else {
//				// changer de region (si possible?)
//				// partir du bas de la region
//				System.out.println("Vous êtes au bord du monde !");
//			}
//			break;
//		case EAST:
//			if(this.position.getX() < Position.MAX_X) {
//				this.position = new Position(this.position.getX() + 1, this.position.getY());
//			} else {
//				// changer de region (si possible?)
//				// partir de l'ouest de la region
//				System.out.println("Vous êtes au bord du monde !");
//			}
//			break;
//		case SOUTH:
//			if(this.position.getY() > Position.MIN_Y) {
//				this.position = new Position(this.position.getX(), this.position.getY() -1);
//			} else {
//				// changer de region (si possible?)
//				// partir du haut de la region
//				System.out.println("Vous êtes au bord du monde !");
//			}
//			break;
//		case WEST:
//			if(this.position.getX() > Position.MIN_X) {
//				this.position = new Position(this.position.getX() -1, this.position.getY());
//			} else {
//				// changer de region (si possible?)
//				// partir de l'est de la region
//				System.out.println("Vous êtes au bord du monde !");
//			}
//			break;
//		}
	}

