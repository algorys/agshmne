package io.github.algorys.agshmne.map.city.shop;

import io.github.algorys.agshmne.character.player.Player;
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

	public void sellItem(Player pj, Item item) {
		inv.removeItem(item);
		pj.getInventory().addItem(item);
		pj.getInventory().setGold(pj.getInventory().getGold() - item.getPrice());
	}

	public void sellItem(Player pj, IStackableItem item, int nb) {
		// TODO Stackable devrait être scindé au cas où il y aurait d'autre type de Stackable !
		pj.getInventory().addItem(new StackableItem(item.getName(), nb, item.getPrice()));
		inv.removeItem(new StackableItem(item.getName(), nb, item.getPrice()));
		int price = item.getPrice() * nb;
		pj.getInventory().setGold(pj.getInventory().getGold() - price);
	}

	public void buyItem(Player pj, Item item) {
		System.out.println(inv);
		pj.getInventory().removeItem(item);
		pj.getInventory().setGold(pj.getInventory().getGold() + item.getPrice());
		inv.addItem(item);
		System.out.println(inv);
	}

	public void buyItem(Player pj, IStackableItem item, int nb) {
		// TODO Stackable devrait être scindé au cas où il y aurait d'autre type de Stackable !
		pj.getInventory().removeItem(new StackableItem(item.getName(), nb, item.getPrice()));
		inv.addItem(new StackableItem(item.getName(), nb, item.getPrice()));
		int price = item.getPrice() * nb;
		pj.getInventory().setGold(pj.getInventory().getGold() + price);
	}

	public Inventory getInventory() {
		return inv;
	}
}
