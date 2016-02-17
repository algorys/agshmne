package io.github.algorys.agshmne.map.city.shop;

import io.github.algorys.agshmne.items.Inventory;
import io.github.algorys.agshmne.items.Item;
import io.github.algorys.agshmne.items.stackable.IStackableItem;
import io.github.algorys.agshmne.items.stackable.StackableItem;

public class Shop {
	public final static Shop NONE = new Shop(0);
	static {
		NONE.inv = new Inventory();
	}
	private Inventory inv;
	private ShopStockFactory stockFact = new ShopStockFactory();

	public Shop(int level) {
		this.inv = stockFact.createStock(level);
	}

	public void sellItem(Inventory playerInventory, Item item) {
		inv.removeItem(item);
		playerInventory.addItem(item);
		playerInventory.setGold(playerInventory.getGold() - item.getPrice());
	}

	public void sellItem(Inventory playerInventory, IStackableItem item, int nb) {
		// TODO Stackable devrait être scindé au cas où il y aurait d'autre type de Stackable !
		playerInventory.addItem(new StackableItem(item.getName(), nb, item.getPrice()));
		inv.removeItem(new StackableItem(item.getName(), nb, item.getPrice()));
		int price = item.getPrice() * nb;
		playerInventory.setGold(playerInventory.getGold() - price);
	}

	public void buyItem(Inventory playerInventory, Item item) {
		playerInventory.removeItem(item);
		playerInventory.setGold(playerInventory.getGold() + item.getPrice());
		inv.addItem(item);
	}

	public void buyItem(Inventory playerInventory, IStackableItem item, int nb) {
		// TODO Stackable devrait être scindé au cas où il y aurait d'autre type de Stackable !
		playerInventory.removeItem(new StackableItem(item.getName(), nb, item.getPrice()));
		inv.addItem(new StackableItem(item.getName(), nb, item.getPrice()));
		int price = item.getPrice() * nb;
		playerInventory.setGold(playerInventory.getGold() + price);
	}

	public Inventory getInventory() {
		return inv;
	}
}
