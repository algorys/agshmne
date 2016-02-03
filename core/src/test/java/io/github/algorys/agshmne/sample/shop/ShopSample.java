package io.github.algorys.agshmne.sample.shop;

import io.github.algorys.agshmne.items.Item;
import io.github.algorys.agshmne.map.city.shop.Shop;

public class ShopSample {

	public static void main(String[] args) {
		Shop shop = new Shop(10);
		for(Item item: shop.getInventory().getListBackpack()){
			System.out.println("Item : " + item.getName());
		}
		System.out.println("Argent : " + shop.getGold());
	}
}
