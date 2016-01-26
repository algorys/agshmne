package io.github.algorys.agshmne.character;

import java.util.Observable;

import io.github.algorys.agshmne.caracteristic.CharacterAttribute;
import io.github.algorys.agshmne.caracteristic.CharacterVital;
import io.github.algorys.agshmne.inventory.InventoryT;
import io.github.algorys.agshmne.movement.Position;
import io.github.algorys.agshmne.region.Region;
import io.github.algorys.agshmne.skills.factory.SkillFactory;
import io.github.algorys.agshmne.tile.Tile;

/*
 * Définit le Personnage
 */
public class Character extends Observable {
	private Position position = new Position(0, 0);
	private Region region;
	private InventoryT inv;
	private CharacterSocial social;
	private CharacterAttribute attributes;
	private CharacterVital vital;
	private CharacterXP xp;
	private SkillFactory skills;

	public Character(Region region) {
		this.region = region;
		social = new CharacterSocial();
		attributes = new CharacterAttribute();
		xp = new CharacterXP();
		inv = new InventoryT();
		skills = new SkillFactory();
		
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
		if(!this.position.equals(position)) {
			this.position = position;
			this.setChanged();
			this.notifyObservers();
		}
	}
	
	public CharacterAttribute getAttributes() {
		return attributes;
	}
	
	public CharacterVital getVital() {
		return vital;
	}
	
	public InventoryT getInventory() {
		return inv;
	}

	public CharacterSocial getSocial() {
		return social;
	}

	public SkillFactory getSkills() {
		return skills;
	}
	
	public Tile getTile() {
		return getRegion().getTileFromPosition(getPosition());
	}
}

