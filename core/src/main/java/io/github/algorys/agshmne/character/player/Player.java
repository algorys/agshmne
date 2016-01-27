package io.github.algorys.agshmne.character.player;

import java.util.Observable;

import io.github.algorys.agshmne.character.Attribute;
import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.character.Vital;
import io.github.algorys.agshmne.character.player.skills.factory.SkillFactory;
import io.github.algorys.agshmne.items.Inventory;
import io.github.algorys.agshmne.map.Position;
import io.github.algorys.agshmne.map.region.Region;
import io.github.algorys.agshmne.map.tile.Tile;

/*
 * Définit le Personnage
 */
public class Player extends Observable implements Character {
	private Position position = new Position(0, 0);
	private Region region;
	private Inventory inv;
	private PlayerSocial social;
	private Attribute attributes;
	private Vital vital;
	private PlayerXP xp;
	private SkillFactory skills;

	public Player(Region region) {
		this.region = region;
		social = new PlayerSocial();
		attributes = new Attribute();
		xp = new PlayerXP();
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

	public PlayerSocial getSocial() {
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

	public PlayerXP getXp() {
		return xp;
	}
	
	@Override
	public int getLevel() {
		return this.xp.getLvl();
	}
	
	@Override
	public String getName() {
		return this.social.getName();
	}
}
