package io.github.algorys.agshmne.inventory;

import java.util.ArrayList;
import java.util.List;

import io.github.algorys.agshmne.objets.Item;

public class Inventory {
	public static List<Item> backPack = new ArrayList<Item>();
	//List<Item> items = new ArrayList<Item>();
	
	/*
	 * TODO Faire max inventaire avec pj.FOR
	 */

	public Inventory() {
		Item orange = new Item("Orange", 2);
		Item pomme = new Item("Pomme", 3);
		Item plantes = new Item("Plantes", 5);
		
		backPack.add(orange);
		backPack.add(pomme);
		backPack.add(plantes);
		
		
		this.getInventaire(backPack);
	}

	public void addItems(Item item) {
		for(int i = 0; i < this.backPack.size(); i++){
			if(this.backPack.get(i).getName() == item.getName()) {
				int nb = item.getNb();
				this.backPack.get(i).setNb(nb);
			} else { 
				this.backPack.add(item);
			}
		}
		this.getInventaire(backPack);
	}
	
	private void getInventaire(List<Item> backPack) {
		for(int i = 0; i < backPack.size(); i++){
			System.out.println("Objets : " + backPack.get(i).getName() + " => " + backPack.get(i).getNb() );
		}
	}
}
