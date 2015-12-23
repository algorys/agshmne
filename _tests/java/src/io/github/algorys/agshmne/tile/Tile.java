package io.github.algorys.agshmne.tile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.github.algorys.agshmne.inventory.InventoryItem;

public class Tile {
	private TileType type;
	private List<InventoryItem> items = new ArrayList<>();


	public Tile(TileType type) {
		this.type = type;
	}

	public TileType getType() {
		return type;
	}

	public void setType(TileType type) {
		this.type = type;
	}
	
	public boolean addItem(InventoryItem e) {
		return items.add(e);
	}
	
	public List<InventoryItem> getItems() {
		return Collections.unmodifiableList(items);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(type);
		if(!items.isEmpty()) {
			sb.append("(");
			for(InventoryItem item: items) {
				sb.append(item.getName());
				sb.append(" ");
			}
			sb.append(")");
		}
		return sb.toString();
	}
}
