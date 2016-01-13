package io.github.algorys.agshmne.character;

import java.util.Observable;

import io.github.algorys.agshmne.caracteristic.CharacterAttribute;
import io.github.algorys.agshmne.caracteristic.CharacterVital;
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
	private CharacterSocial social;
	private CharacterAttribute attributes;
	private CharacterVital vital;
	private CharacterXP xp;
	

	public Character(Region region) {
		this.region = region;
		social = new CharacterSocial();
		attributes = new CharacterAttribute();
		xp = new CharacterXP();
		inv = new Inventory();
		
	}

	public Position getPosition() {
		return position;
	}

	public Region getRegion() {
		return this.region;
	}
	
	public void initVital() {
		vital = new CharacterVital(attributes, xp);
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
	
	public CharacterVital getVital() {
		return vital;
	}
	
	public Inventory getInventory() {
		return inv;
	}

	public CharacterSocial getSocial() {
		return social;
	}
}

