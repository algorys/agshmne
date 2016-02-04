package io.github.algorys.agshmne.sample.Items;

import io.github.algorys.agshmne.items.GeneralItem;
import io.github.algorys.agshmne.items.Inventory;
import io.github.algorys.agshmne.items.Item;
import io.github.algorys.agshmne.items.equipable.BodyPart;
import io.github.algorys.agshmne.items.equipable.EquipableItem;
import io.github.algorys.agshmne.items.stackable.StackableItem;;

public class ItemInventorySample {

	public static void main(String[] args) {
		Inventory inventory = new Inventory();

		// Ajout une première Pomme
		Item apple = new StackableItem("Pomme", 1, 5);
		inventory.addItem(apple);
		System.out.println(inventory.toString());
		// Ajout une deuxième Pomme
		apple = new StackableItem("Pomme", 1, 5);
		inventory.addItem(apple);
		System.out.println(inventory.toString());
		System.out.println("Inventaire contient " + inventory.count(apple) + " Pommes !");

		// Ajout d'un objet simple
		Item axe = new EquipableItem("Hache", BodyPart.RIGHT_HAND, 10);
		inventory.addItem(axe);
		System.out.println(inventory.toString());

		// Vérification si l'objet existe
		Item orange = new StackableItem("Orange", 1, 5);
		Item sword = new EquipableItem("Épée", BodyPart.RIGHT_HAND, 10);
		System.out.println(inventory.contains(axe));
		System.out.println(inventory.contains(apple));
		System.out.println(inventory.contains(orange));
		System.out.println(inventory.contains(sword));
		System.out.println("Inventaire contient " + inventory.count(orange) + " Oranges !");

		// Test pour Ajout GeneralStackable (sans Direct)
		Item pear = new StackableItem("Pear", 1, 5);
		inventory.addItem(pear);
		pear = new StackableItem("Pear", 1, 5);
		inventory.addItem(pear);
		Item armor = new GeneralItem("Armure matelassée", 10);
		inventory.addItem(armor);
		System.out.println(inventory.toString());

		// Suppression d'un Stackable
		inventory.removeItem(apple);
		System.out.println(inventory.toString());
		inventory.removeItem(apple);
		System.out.println(inventory.toString());
		inventory.removeItem(pear);
		System.out.println(inventory.toString());
		inventory.removeItem(armor);
		inventory.removeItem(axe);
		System.out.println(inventory.toString());

	}

}
