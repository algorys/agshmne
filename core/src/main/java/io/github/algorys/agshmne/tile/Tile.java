package io.github.algorys.agshmne.tile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

import io.github.algorys.agshmne.city.City;
import io.github.algorys.agshmne.history.HistoryTile;
import io.github.algorys.agshmne.inventory.InventoryItem;
import io.github.algorys.agshmne.tempItem.Item;

public class Tile extends Observable {
	private TileType type;
	private List<Item> items = new ArrayList<>();
	private City city; 
	private HistoryTile histTile;
	
	public Tile(TileType type, City city) {
		this.type = type;
		this.city = city;
		histTile = new HistoryTile(this);
	}

	public Tile(TileType type) {
		this.type = type;
		histTile = new HistoryTile(this);
	}

	public TileType getType() {
		return type;
	}
	
	public boolean addItem(Item e) {
		boolean added = items.add(e);
		this.setChanged();
		this.notifyObservers();
		return added;
	}

	public List<Item> getItems() {
		return Collections.unmodifiableList(items);
	}

	public void removeItem(Item e) {
		this.items.remove(e);
		this.setChanged();
		this.notifyObservers();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(type);
		if (!items.isEmpty()) {
			sb.append(" (Objets : ");
			for (Item item : items) {
				sb.append(item.getName());
				sb.append(" ");
			}
			sb.append(")");
		}
		return sb.toString();
	}
	public City getCity() {
		return city;
	}
	
	public boolean isCivilized() {
		return this.city != null;
	}

	public HistoryTile getHistTile() {
		return histTile;
	}

}
