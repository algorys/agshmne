package io.github.algorys.agshmne.tile;

import java.util.List;
import java.util.Observable;

import io.github.algorys.agshmne.city.City;
import io.github.algorys.agshmne.history.HistoryTile;
import io.github.algorys.agshmne.inventory.Inventory;
import io.github.algorys.agshmne.items.Item;

public class Tile extends Observable {
	private TileType type;
	private Inventory inv = new Inventory();
	private City city;
	private String desc;

	public Tile(TileType type, City city) {
		this(type);
		this.city = city;
	}

	public Tile(TileType type) {
		this.type = type;
		desc = new HistoryTile(this).getDesc();
	}

	public TileType getType() {
		return type;
	}

	public boolean addItem(Item e) {
		inv.addItem(e);
		boolean added = true;
		this.setChanged();
		this.notifyObservers();
		return added;
	}

	public List<Item> getItems() {
		return inv.getListBackpack();
	}

	public void removeItem(Item e) {
		this.inv.removeItem(e);
		this.setChanged();
		this.notifyObservers();
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
}
