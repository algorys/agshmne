package io.github.algorys.agshmne.inventory;

import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractListModel;

public class InventoryListModel extends AbstractListModel<InventoryItem> implements Observer {
	final Inventory inv;
	
	public InventoryListModel(Inventory inv) {
		this.inv = inv;
		inv.addObserver(this);
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
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Inventory changed");
		this.fireContentsChanged(this, 0, this.getSize()-1);
	}
}
