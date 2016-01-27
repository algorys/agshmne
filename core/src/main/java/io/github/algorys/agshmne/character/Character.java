package io.github.algorys.agshmne.character;

import java.util.Observable;

import io.github.algorys.agshmne.caracteristic.CharacterAttribute;
import io.github.algorys.agshmne.caracteristic.CharacterVital;
import io.github.algorys.agshmne.inventory.Inventory;
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
	private Inventory inv;
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
		inv = new Inventory();
		skills = new SkillFactory();
		
	}

	public Position getPosition() {
		return position;
	}

	public Region getRegion() {
		return this.region;
	}
	
	public void initVital() {
		vital = new CharacterVital(attributes, xp.getLvl());
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
	
	public Inventory getInventory() {
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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nom : " + this.social.getName());
		sb.append("\n");
		sb.append("Level : " + this.xp.getLvl());
		sb.append("\n");
		sb.append("Vie = " + this.getVital().getVie());
		sb.append("\n");
		sb.append("Mana = " + this.getVital().getMana());
		sb.append("\n");
		sb.append("For = " + this.getAttributes().getFOR());
		sb.append("\n");
		sb.append("Dex = " + this.getAttributes().getDEX());
		sb.append("\n");
		sb.append("Con = " + this.getAttributes().getCON());
		return sb.toString();
	}

	public CharacterXP getXp() {
		return xp;
	}
}

