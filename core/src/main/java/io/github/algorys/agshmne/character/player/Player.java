package io.github.algorys.agshmne.character.player;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import io.github.algorys.agshmne.adventure.quest.IQuest;
import io.github.algorys.agshmne.character.Attribute;
import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.character.Vital;
import io.github.algorys.agshmne.character.player.skills.factory.SkillFactory;
import io.github.algorys.agshmne.items.Inventory;
import io.github.algorys.agshmne.items.Item;
import io.github.algorys.agshmne.items.equipable.IEquipableItem;
import io.github.algorys.agshmne.map.tile.Tile;

/*
 * Définit le Personnage
 */
public class Player implements Character {
	public final static String PROPERTY_TILE = "tile";

	private Tile tile;
	private Inventory inv;
	private PlayerSocial social;
	private Attribute attributes;
	private Vital vital;
	private PlayerXP xp;
	private SkillFactory skills;
	private List<IQuest> quests = new ArrayList<>();
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	public Player(Tile initialTile, SkillFactory skills) {
		social = new PlayerSocial();
		attributes = new Attribute();
		xp = new PlayerXP();
		inv = new Inventory();
		this.skills = skills;
		this.tile = initialTile;
	}

	public void initVital() {
		vital = new Vital(attributes.getCON() + 10 + this.getXp().getLevel(),
				attributes.getINT() + this.getXp().getLevel(), ((attributes.getCON() + attributes.getFOR()) / 2) + 10,
				attributes.getCON() + 10);
	}

	public void equip(IEquipableItem item) {
		Attribute old = this.getCurrentAttributes();
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
			pcs.firePropertyChange(PROPERTY_CURRENT_ATTRIBUTES, old, this.getCurrentAttributes());
		}
	}

	public void unequip(IEquipableItem item) {
		Attribute old = this.getCurrentAttributes();
		item.unequip();
		pcs.firePropertyChange(PROPERTY_CURRENT_ATTRIBUTES, old, this.getCurrentAttributes());
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
		Attribute attributes = new Attribute(this.getAttributes());

		for (Item item : this.getInventory().getListBackpack()) {
			if (item instanceof IEquipableItem) {
				IEquipableItem equipItem = (IEquipableItem) item;
				if (equipItem.isEquipped()) {
					attributes.add(equipItem.getAttribute());
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
		return this.tile;
	}

	public void setTile(Tile newTile) {
		Tile old = this.tile;
		this.tile = newTile;
		pcs.firePropertyChange(PROPERTY_TILE, old, newTile);
	}

	public void addQuest(IQuest questAdded) {
		quests.add(questAdded);
	}

	public List<IQuest> getQuest() {
		return quests;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nom : " + this.social.getName());
		sb.append("\n");
		sb.append("Level : " + this.xp.getLevel());
		sb.append("\n");
		sb.append("Vie = " + this.getVital().getLife());
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
		return this.xp.getLevel();
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
