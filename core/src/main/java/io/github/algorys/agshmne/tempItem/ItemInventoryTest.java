package io.github.algorys.agshmne.tempItem;

import io.github.algorys.agshmne.tempItem.InventoryT;;

public class ItemInventoryTest {

	public static void main(String[] args) {
		ItemDirectFactory itemFactory = new ItemDirectFactory();
		Item axe = itemFactory.createAxe();
		
		InventoryT inventory = new InventoryT();
		
		inventory.addItem(axe);
		System.out.println("---" + inventory.toString());
	}

}
