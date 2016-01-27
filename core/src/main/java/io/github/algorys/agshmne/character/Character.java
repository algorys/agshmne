package io.github.algorys.agshmne.character;

import java.util.Observable;

import io.github.algorys.agshmne.character.skills.factory.SkillFactory;
import io.github.algorys.agshmne.items.Inventory;
import io.github.algorys.agshmne.map.Position;
import io.github.algorys.agshmne.map.region.Region;
import io.github.algorys.agshmne.map.tile.Tile;

/*
 * Définit le Personnage
 */
public class Character extends Observable {
	private Position position = new Position(0, 0);
	private Region region;
	private Inventory inv;
	private CharacterSocial social;
	private Attribute attributes;
	private Vital vital;
	private CharacterXP xp;
	private SkillFactory skills;

	public Character(Region region) {
		this.region = region;
		social = new CharacterSocial();
		attributes = new Attribute();
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
		vital = new Vital(attributes.getCON() + 10 + this.getXp().getLvl(), attributes.getINT() + this.getXp().getLvl(),
				((attributes.getCON() + attributes.getFOR()) / 2) + 10, attributes.getCON() + 10);
	}

	public void setPosition(Position position) {
		if (!this.position.equals(position)) {
			this.position = position;
			this.setChanged();
			this.notifyObservers();
		}
	}

	public Attribute getAttributes() {
		return attributes;
	}

	public Vital getVital() {
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
