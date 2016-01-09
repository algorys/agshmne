package io.github.algorys.agshmne.inventory;

import io.github.algorys.agshmne.items.factory.AppleFactory;
import io.github.algorys.agshmne.items.factory.CloakFactory;
import io.github.algorys.agshmne.items.factory.NailFactory;
import io.github.algorys.agshmne.items.factory.OrangeFactory;
import io.github.algorys.agshmne.items.factory.PotionManaFactory;
import io.github.algorys.agshmne.items.factory.RandomFactory;
import io.github.algorys.agshmne.items.factory.StrongAxeFactory;

/*
 * TODO : faire une factory pour cette classe, pour avoir une Factory :
 *  * Low
 *  * Medium
 *  * High
 *  * Extra -> Objets Magique
 *  
 */
public class InventoryFactory {
	private InventoryItem inventItem;
	
	public InventoryFactory() {
		RandomFactory rf = new RandomFactory();
		rf.addFactory(new AppleFactory());
		rf.addFactory(new StrongAxeFactory());
		rf.addFactory(new NailFactory());
		rf.addFactory(new PotionManaFactory());
		rf.addFactory(new CloakFactory());
		rf.addFactory(new OrangeFactory());
		
		this.inventItem = rf.createRandom();
	}

	public InventoryItem getInventItem() {
		return inventItem;
	}
	
	public String toString(){
		return inventItem.getName();
	}
	
	
}
