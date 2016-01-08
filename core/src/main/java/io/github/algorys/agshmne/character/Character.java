package io.github.algorys.agshmne.character;

import java.util.Observable;

import io.github.algorys.agshmne.caracteristic.CharacterAttribute;
import io.github.algorys.agshmne.inventory.Inventory;
import io.github.algorys.agshmne.movement.Position;
import io.github.algorys.agshmne.region.Region;

/*
 * Définit le Personnage
 */
public class Character extends Observable {
	private Position position = new Position(0, 0);
	private Region region;
	private Inventory inv;
	private CharacterAttribute attributes;
	

	public Character(Region region) {
		this.region = region;
		attributes = new CharacterAttribute();
		//System.out.println("------- Création Personnage --------");
		
	}

	public Position getPosition() {
		return position;
	}

	public Region getRegion() {
		return this.region;
	}
	
	public void setPosition(Position position) {
		//System.out.println("Nouvelle position => " + position.getX() + ", " + position.getY());
		//System.out.println("Sur case : " + region.getTileFromPosition(position));
		this.position = position;
		this.setChanged();
		this.notifyObservers();
	}
	
	public CharacterAttribute getAttributes() {
		return attributes;
	}
}

