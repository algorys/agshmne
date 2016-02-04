package io.github.algorys.agshmne.sample.shop;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.items.GeneralItem;
import io.github.algorys.agshmne.items.Item;
import io.github.algorys.agshmne.map.city.shop.Shop;

public class ShopSample {

	public static void main(String[] args) {
		Shop shop = new Shop(10);
		for(Item item: shop.getInventory().getListBackpack()){
			System.out.println("Item : " + item.getName() + " Prix : " + item.getPrice());
		}
		Player pj = new Player(null);
		pj.getInventory().setGold(10);
		Item apple = new GeneralItem("Pomme", 2);
		pj.getInventory().addItem(apple);
		System.out.println("Argent PJ : " + pj.getInventory().getGold());
		
		shop.sellItem(pj, apple);
		System.out.println("Argent PJ : " + pj.getInventory().getGold());
		
		shop.buyItem(pj, apple);
		System.out.println("Argent PJ : " + pj.getInventory().getGold());
	}
}
