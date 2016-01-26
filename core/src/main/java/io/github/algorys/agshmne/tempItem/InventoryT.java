package io.github.algorys.agshmne.tempItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class InventoryT extends Observable {
	// TODO gérer les objets de quêtes différement des objets normaux.
	private List<Item> backpack = new ArrayList<>();
	
	public InventoryT() {
	}

	public void addItem(Item item) {
		boolean added = false;
		if (item instanceof GeneralStackableItem) {
			for (int i = 0; i < backpack.size(); i++) {
				if (backpack.get(i).getName() == item.getName()) {
					IStackableItem stack = (IStackableItem) item;
					stack.addCount(stack.getCount());
					added = true;
					this.setChanged();
					break;
				}
			}
		}
		if (!added) {
			backpack.add(item);
		}
		this.notifyObservers();
	}

	public void removeItem(Item item) {
		boolean removed = false;
		if (item instanceof GeneralStackableItem) {
			for (int i = 0; i < backpack.size(); i++) {
				IStackableItem stackItem = (IStackableItem) item;
				if (backpack.get(i).getName() == item.getName()) {
					IStackableItem stack = ((IStackableItem) backpack.get(i));
					stack.removeCount(stackItem.getCount());
					if(stack.getCount() == 0){
						backpack.remove(i); // TODO Si non gestion des emplacements (mais du coup, pas forcément un tableau)
					}
					removed = true;
					this.setChanged();
					break;
				}
			}
		}
		if (!removed) {
			for (int i = 0; i < backpack.size(); i++) {
				if (backpack.get(i) == item) {
					backpack.remove(i);
					this.setChanged();
					break;
				}
			}
		}
		this.notifyObservers();
	}

	public boolean contains(String item) {
		for (int i = 0; i < backpack.size(); i++) {
			if (item == backpack.get(i).getName()) {
				return true;
			}
		}
		return false;
	}

	public int count(Class<?> type) {
		int res = 0;
		for (int i = 0; i < backpack.size(); i++) {
			if (type.isInstance(backpack.get(i))) {
				if(backpack.get(i) instanceof GeneralStackableItem) {
					IStackableItem stackableItem = (IStackableItem)backpack.get(i);
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
		for (int i = 0; i < backpack.size(); i++) {
			if(backpack.get(i) instanceof GeneralStackableItem) {
				IStackableItem stackableItem = (IStackableItem)backpack.get(i);
				sb.append(""+ stackableItem.getName() + ", " + stackableItem.getCount());
			} else {
				sb.append(""+ backpack.get(i).getName());
			}
			sb.append("\n");
		}
		sb.append("------------\n");
		return sb.toString();
	}

	public List<Item> getListBackpack() {
		return backpack;
	}

}