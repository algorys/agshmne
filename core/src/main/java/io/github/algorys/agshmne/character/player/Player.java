package io.github.algorys.agshmne.character.player;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import io.github.algorys.agshmne.character.Attribute;
import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.character.Vital;
import io.github.algorys.agshmne.character.player.skills.factory.SkillFactory;
import io.github.algorys.agshmne.items.IEquipableItem;
import io.github.algorys.agshmne.items.Inventory;
import io.github.algorys.agshmne.items.Item;
import io.github.algorys.agshmne.map.Position;
import io.github.algorys.agshmne.map.region.Region;
import io.github.algorys.agshmne.map.tile.Tile;

/*
 * Définit le Personnage
 */
public class Player implements Character {
	public final static String PROPERTY_POSITION = "position";
	public final static String PROPERTY_REGION = "position";
	public final static String PROPERTY_INVENTORY = "inventory";
	public final static String PROPERTY_SOCIAL = "social";
	public final static String PROPERTY_XP = "xp";
	public final static String PROPERTY_SKILLS = "skills";

	private Position position = new Position(0, 0);
	private Region region;
	private Inventory inv;
	private PlayerSocial social;
	private Attribute attributes;
	private Vital vital;
	private PlayerXP xp;
	private SkillFactory skills;
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

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
		Position old = this.position;
		this.position = position;
		pcs.firePropertyChange(PROPERTY_POSITION, old, this.position);
	}

	public void equip(IEquipableItem item) {
		if (this.getInventory().contains(item)) {
			for (Item currentItem : this.getInventory().getListBackpack()) {
				if (currentItem instanceof IEquipableItem) {
					IEquipableItem currentEquipableItem = (IEquipableItem) currentItem;
					if (currentEquipableItem.getPart() == item.getPart()) {
						currentEquipableItem.unequip();
					}
				}
			}
			item.equip();
		}
	}

	public void unequip(IEquipableItem item) {
		item.unequip();
	}

	/**
	 * Retourne les attributs de base (sans modificateurs).
	 * 
	 * @return les attributs de base (sans modificateurs)
	 */
	public Attribute getAttributes() {
		return this.attributes;
	}

	/**
	 * Retourne les attributs courants (avec modificateurs). TODO Gérer les
	 * objets équipés TODO Gérer les sorts actifs TODO Gérer les potions actives
	 * TODO Gérer les malédictions, les bénédictions TODO Gérer les
	 * modificateurs de quêtes
	 * 
	 * @return les attributs courants (avec modificateurs)
	 */
	@Override
	public Attribute getCurrentAttributes() {
		Attribute attributes = new Attribute();
		attributes.setINT(this.getAttributes().getINT());
		attributes.setCON(this.getAttributes().getCON());
		attributes.setFOR(this.getAttributes().getFOR());
		attributes.setDEX(this.getAttributes().getDEX());
		
		for (Item item : this.getInventory().getListBackpack()) {
			if (item instanceof IEquipableItem) {
				IEquipableItem equipItem = (IEquipableItem) item;
				if(equipItem.isEquipped()) {
					int modifier = equipItem.getModifier();
					switch (equipItem.getPart()) {
					case HEAD:
						attributes.setINT(attributes.getINT() + modifier);
						break;
					case CHEST:
						attributes.setCON(attributes.getCON() + modifier);
						break;
					case ARMS:
						attributes.setCON(attributes.getCON() + modifier);
						break;
					case LEGS:
						attributes.setCON(attributes.getCON() + modifier);
						break;
					case RIGHT_HAND:
						attributes.setFOR(attributes.getFOR() + modifier);
						break;
					case LEFT_HAND:
						attributes.setDEX(attributes.getDEX() + modifier);
						break;
					// TODO : voir pour peut-être géré les anneaux autrement.
					default:
						break;
					}
				}
			}
		}
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

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}

	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(propertyName, listener);
	}
}
