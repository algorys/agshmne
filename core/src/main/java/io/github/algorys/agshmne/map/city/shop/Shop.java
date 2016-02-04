package io.github.algorys.agshmne.map.city.shop;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.items.Inventory;
import io.github.algorys.agshmne.items.Item;

public class Shop {
	private Inventory inv;
	private ShopStockFactory stockFact = new ShopStockFactory();
	
	public Shop(int level) {
		this.inv = stockFact.createStock(level);
		//inv.setGold(level * 20);
	}

	public void sellItem(Player pj, Item item) {
		inv.removeItem(item);
		pj.getInventory().addItem(item);
		pj.getInventory().setGold(pj.getInventory().getGold() - item.getPrice());
	}
	
	public void buyItem(Player pj, Item item) {
		pj.getInventory().removeItem(item);
		pj.getInventory().setGold(pj.getInventory().getGold() + item.getPrice());
		inv.addItem(item);
	}
	
	public Inventory getInventory() {
		return inv;
	}
}
