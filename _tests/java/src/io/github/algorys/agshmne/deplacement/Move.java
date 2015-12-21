package io.github.algorys.agshmne.deplacement;

import io.github.algorys.agshmne.Personnage.Direction;
import io.github.algorys.agshmne.Position;

public class Move {
	
	public Move(Direction direction, Position position) {
		switch (direction) {
		case NORTH:
			if(position.getY() < Position.MAX_Y) {
				position = new Position(position.getX(), position.getY() + 1);
			} else {
				// changer de region (si possible?)
				// partir du bas de la region
				System.out.println("Vous êtes au bord du monde !");
			}
			break;
		case EAST:
			if(position.getX() < Position.MAX_X) {
				position = new Position(position.getX() + 1, position.getY());
			} else {
				// changer de region (si possible?)
				// partir de l'ouest de la region
				System.out.println("Vous êtes au bord du monde !");
			}
			break;
		case SOUTH:
			if(position.getY() > Position.MIN_Y) {
				position = new Position(position.getX(), position.getY() -1);
			} else {
				// changer de region (si possible?)
				// partir du haut de la region
				System.out.println("Vous êtes au bord du monde !");
			}
			break;
		case WEST:
			if(position.getX() > Position.MIN_X) {
				position = new Position(position.getX() -1, position.getY());
			} else {
				// changer de region (si possible?)
				// partir de l'est de la region
				System.out.println("Vous êtes au bord du monde !");
			}
			break;
		}
	}
}
