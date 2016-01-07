package io.github.algorys.agshmne.world;

import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.deplacement.Direction;
import io.github.algorys.agshmne.deplacement.Position;
import io.github.algorys.agshmne.region.Region;

public class World {
	private Region[][] regions;
	
	World(Region[][] regions) {
		this.regions = regions;
	}
	
	public Region getRegion(Region origin, Character direction) {
		// TODO retrouver les coordonnées de la région <code>origin</origin> pour donner la bonne région de retour, ou envoyer une erreur pour mauvaises entrées
		return null;
	}
	
	public Region getDefaultRegion() {
		return regions[1][1];
	}
	

	public void move(Direction direction, Character personnage) {
		Position position = personnage.getPosition();
		switch (direction) {
		case NORTH:
			if(position.getY() < Position.MAX_Y) {
				personnage.setPosition(new Position(position.getX(), position.getY() + 1));
			} else {
				// changer de region (si possible?)
				// partir du bas de la region
				System.out.println("Vous êtes au bord de la région !");
			}
			break;
		case EAST:
			if(position.getX() < Position.MAX_X) {
				personnage.setPosition(new Position(position.getX() + 1, position.getY()));
			} else {
				// changer de region (si possible?)
				// partir de l'ouest de la region
				System.out.println("Vous êtes au bord de la région !");
			}
			break;
		case SOUTH:
			if(position.getY() > Position.MIN_Y) {
				personnage.setPosition(new Position(position.getX(), position.getY() -1));
			} else {
				// changer de region (si possible?)
				// partir du haut de la region
				System.out.println("Vous êtes au bord de la région !");
			}
			break;
		case WEST:
			if(position.getX() > Position.MIN_X) {
				personnage.setPosition(new Position(position.getX() -1, position.getY()));
			} else {
				// changer de region (si possible?)
				// partir de l'est de la region
				System.out.println("Vous êtes au bord de la région !");
			}
			break;
		}
	}
}
