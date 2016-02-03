package io.github.algorys.agshmne.map.city.shop;

import io.github.algorys.agshmne.items.Inventory;

public class Shop {
	private Inventory inv;
	private ShopStockFactory stockFact = new ShopStockFactory();
	
	public Shop(int level) {
		this.inv = stockFact.createStock(level);
		inv.setGold(level * 20);
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
