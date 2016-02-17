package io.github.algorys.agshmne.sample.shop;

import io.github.algorys.agshmne.items.GeneralItem;
import io.github.algorys.agshmne.items.Inventory;
import io.github.algorys.agshmne.items.Item;
import io.github.algorys.agshmne.map.city.shop.Shop;

public class ShopSample {

	public static void main(String[] args) {
		Shop shop = new Shop(10);
		for (Item item : shop.getInventory().getListBackpack()) {
			System.out.println("Item : " + item.getName() + " Prix : " + item.getPrice());
		}
		Inventory playerInventory = new Inventory();
		playerInventory.setGold(10);
		Item apple = new GeneralItem("Pomme", 2);
		playerInventory.addItem(apple);
		System.out.println("Argent PJ : " + playerInventory.getGold());

		shop.sellItem(playerInventory, apple);
		System.out.println("Argent PJ : " + playerInventory.getGold());

		shop.buyItem(playerInventory, apple);
		System.out.println("Argent PJ : " + playerInventory.getGold());
	}
}
