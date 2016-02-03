package io.github.algorys.agshmne.map.city.shop;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.items.Inventory;
import io.github.algorys.agshmne.items.Item;

public class Shop {
	private Inventory inv;
	private ShopStockFactory stockFact = new ShopStockFactory();
	
	public Shop(int level) {
		this.inv = stockFact.createStock(level);
		inv.setGold(level * 20);
	}

	public void sellItem(Player pj, Item item) {
		inv.removeItem(item);
		pj.getInventory().addItem(item);
		// TODO item.getPrice();
	}
	public Inventory getInventory() {
		return inv;
	}
	
	public int getGold() {
		return inv.getGold();
	}
	
	public void setGold(int gold) {
		inv.setGold(gold);
	}
}
