package io.github.algorys.agshmne.personnage;

import java.util.Observable;

import io.github.algorys.agshmne.deplacement.Position;
import io.github.algorys.agshmne.inventory.Inventory;
import io.github.algorys.agshmne.objets.Item;
import io.github.algorys.agshmne.region.Region;

/*
 * Définit le Personnage
 */
public class Personnage extends Observable {
	private Position position = new Position(0, 0);
	private Region region;
	private Inventory inv = new Inventory();
	

	public Personnage(Region region) {
		this.region = region;
		System.out.println("------- Création Personnage --------");
		Item clou = new Item("Clou", 1);
		Item pomme = new Item("Pomme", 2);
		//inv.addItems(clou);
		//inv.addItems(clou);
		
	}

	public Position getPosition() {
		return position;
	}

	public Region getRegion() {
		return this.region;
	}
	
	public void setPosition(Position position) {
		//System.out.println("Nouvelle position => " + position.getX() + ", " + position.getY());
		//System.out.println("Sur case : " + region.getTileFromPosition(position));
		this.position = position;
		this.setChanged();
		this.notifyObservers();
	}
}

