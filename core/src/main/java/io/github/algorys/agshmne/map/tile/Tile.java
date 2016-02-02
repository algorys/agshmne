package io.github.algorys.agshmne.map.tile;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

import io.github.algorys.agshmne.items.Inventory;
import io.github.algorys.agshmne.items.Item;
import io.github.algorys.agshmne.map.city.City;

public class Tile {
	public static final String PROPERTY_ITEMS = "items";

	private TileType type;
	private Inventory inv = new Inventory();
	private City city;
	private String desc;
	private boolean danger = false;
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	public Tile(TileType type, String desc, City city) {
		this(type, desc);
		this.city = city;
	}

	public Tile(TileType type, String desc) {
		this.type = type;
		this.desc = desc;
	}

	public TileType getType() {
		return type;
	}

	public void addItem(Item e) {
		inv.addItem(e);
		this.pcs.firePropertyChange(PROPERTY_ITEMS, null, inv);
	}

	public List<Item> getItems() {
		return inv.getListBackpack();
	}

	public void removeItem(Item e) {
		this.inv.removeItem(e);
		this.pcs.firePropertyChange(PROPERTY_ITEMS, null, inv);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(type);
		sb.append(" (Objets : ");
		for (Item item : inv.getListBackpack()) {
			sb.append(item.getName());
			sb.append(" ");
		}
		sb.append(")");
		return sb.toString();
	}

	public City getCity() {
		return city;
	}
	
	public boolean isCivilized() {
		return this.city != null;
	}

	public String getDesc() {
		return this.desc;
	}

	public boolean isDanger() {
		return danger;
	}

	public void setDanger(boolean danger) {
		this.danger = danger;
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
