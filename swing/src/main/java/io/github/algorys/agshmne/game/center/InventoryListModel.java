package io.github.algorys.agshmne.game.center;

import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractListModel;

import io.github.algorys.agshmne.items.Inventory;
import io.github.algorys.agshmne.items.Item;

@SuppressWarnings("serial")
public class InventoryListModel extends AbstractListModel<Item> implements Observer {
	final Inventory inv;
	
	public InventoryListModel(Inventory inventory) {
		this.inv = inventory;
		inventory.addObserver(this);
	}
	@Override
	public int getSize() {
		return inv.getListBackpack().size();
	}
	@Override
	public Item getElementAt(int index) {
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
