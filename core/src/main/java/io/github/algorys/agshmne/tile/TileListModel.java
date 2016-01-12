package io.github.algorys.agshmne.tile;

import javax.swing.AbstractListModel;

import io.github.algorys.agshmne.inventory.InventoryItem;

public class TileListModel extends AbstractListModel<InventoryItem> {
	final Tile t;
	public TileListModel(Tile t) {
		this.t= t;
	}
	@Override
	public int getSize() {
		return t.getItems().size();
	}
	@Override
	public InventoryItem getElementAt(int index) {
		return t.getItems().get(index);
	}
	public void removeElementAt(int index) {
		t.removeItem(t.getItems().get(index));
		this.fireIntervalRemoved(this, index, index );
	}
}
