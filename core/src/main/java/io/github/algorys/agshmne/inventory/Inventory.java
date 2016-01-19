package io.github.algorys.agshmne.inventory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

public class Inventory extends Observable {
	public final static int MAX_INVENTORY = 10;

	private InventoryItem[] backpack = new InventoryItem[MAX_INVENTORY];
	
	public Inventory() {
	}

	public void addItem(InventoryItem item) {
		boolean added = false;
		if (item instanceof StackableItem) {
			StackableItem stackItem = (StackableItem) item;
			for (int i = 0; i < MAX_INVENTORY; i++) {
				if (backpack[i] != null && item.getClass() == backpack[i].getClass()) {
					StackableItem stack = (StackableItem) backpack[i];
					stack.addCount(stackItem.getCount());
					added = true;
					this.setChanged();
					break;
				}
			}
		}
		if (!added) {
			for (int i = 0; i < MAX_INVENTORY; i++) {
				if (backpack[i] == null) {
					this.setChanged();
					backpack[i] = item;
					break;
				}
			}
		}
		this.notifyObservers();
	}

	public void addItem(InventoryItem item, int index) {
		if (backpack[index] != null) {
			throw new IllegalArgumentException("Already an item at this index");
		}
		backpack[index] = item;
		this.setChanged();
		this.notifyObservers();
	}

	public void removeItem(InventoryItem item) {
		boolean removed = false;
		if (item instanceof StackableItem) {
			StackableItem stackItem = (StackableItem) item;
			for (int i = 0; i < MAX_INVENTORY; i++) {
				if (backpack[i] != null && item.getClass() == backpack[i].getClass()) {
					StackableItem stack = (StackableItem) backpack[i];
					System.out.println(".getCount vaut : " + stackItem.getCount());
					stack.removeCount(stackItem.getCount());
					System.out.println(".getCount vaut : " + stackItem.getCount());
					if(stack.getCount() == 0){
						backpack[i] = null; // TODO Si non gestion des emplacements (mais du coup, pas forcément un tableau)
					}
					removed = true;
					this.setChanged();
					break;
				}
			}
		}
		if (!removed) {
			for (int i = 0; i < MAX_INVENTORY; i++) {
				if (backpack[i] == item) {
					backpack[i] = null;
					this.setChanged();
					break;
				}
			}
		}
		this.notifyObservers();
	}

	public boolean contains(Class<?> type) {
		for (int i = 0; i < MAX_INVENTORY; i++) {
			if (type.isInstance(backpack[i])) {
				return true;
				/*
				 * TODO Si gestion des emplacements 
				if(!StackableItem.class.isInstance(backpack[i]) || ((StackableItem)backpack[i]).getCount() > 0) { 
					return true;
				}
				*/
			}
		}
		return false;
	}

	public int count(Class<?> type) {
		int res = 0;
		for (int i = 0; i < MAX_INVENTORY; i++) {
			if (type.isInstance(backpack[i])) {
				if(backpack[i] instanceof StackableItem) {
					StackableItem stackableItem = (StackableItem)backpack[i];
					res += stackableItem.getCount();
				} else {
					res++;
				}
			}
		}
		return res;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("--- Sac-à-dos ---");
		sb.append("\n");
		for (int i = 0; i < MAX_INVENTORY; i++) {
			sb.append(""+ backpack[i]);
			sb.append("\n");
		}
		sb.append("------------\n");
		return sb.toString();
	}

	public List<InventoryItem> getListBackpack() {
		List<InventoryItem> list = Arrays.asList(this.backpack);
		return Collections.unmodifiableList(list);
	}

}
