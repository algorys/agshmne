package io.github.algorys.agshmne.tempItem;

import io.github.algorys.agshmne.tempItem.InventoryT;;

public class ItemInventoryTest {

	public static void main(String[] args) {
		ItemDirectFactory itemFactory = new ItemDirectFactory();
		
		Item axe = itemFactory.createAxe();
		Item sword = itemFactory.createSword();
		
		InventoryT inventory = new InventoryT();
		
		inventory.addItem(axe);
		inventory.addItem(sword);
		
		System.out.println("---" + inventory.toString());
		
		StackableItemDirectFactory stackFactory = new StackableItemDirectFactory();
		
		Item apple = stackFactory.createApple();
		
		inventory.addItem(apple);
		inventory.addItem(apple);

		System.out.println("---" + inventory.toString());
	}

}
