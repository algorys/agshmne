package io.github.algorys.agshmne.inventory;

import javax.swing.AbstractListModel;

import io.github.algorys.agshmne.tile.Tile;

public class InventoryListModel extends AbstractListModel<InventoryItem>{
	final Inventory inv;
	
	public InventoryListModel(Inventory inv) {
		this.inv = inv;
	}
	@Override
	public int getSize() {
		return inv.getListBackpack().size();
	}
	@Override
	public InventoryItem getElementAt(int index) {
		return inv.getListBackpack().get(index);
	}
	public void removeElementAt(int index) {
		inv.removeItem(inv.getListBackpack().get(index));
		this.fireIntervalRemoved(this, index, index );
	}
}
