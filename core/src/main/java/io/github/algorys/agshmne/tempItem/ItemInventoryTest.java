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
		Item orange = stackFactory.createOrange();
		
		inventory.addItem(apple);
		inventory.addItem(apple);
		inventory.addItem(orange);

		System.out.println("---" + inventory.toString());
		
		inventory.removeItem(apple);
		System.out.println("---" + inventory.toString());
		inventory.removeItem(apple);
		inventory.removeItem(orange);
		
		System.out.println("---" + inventory.toString());
		
		if(inventory.contains(apple.getName())){
			System.out.println("Le sac à dos contient des pommes !");
		}
		inventory.addItem(apple);
		if(inventory.contains(apple.getName())){
			System.out.println("Le sac à dos contient des pommes !");
		}
		System.out.println(inventory.toString());
		
		
	}

}
