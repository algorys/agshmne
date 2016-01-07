package io.github.algorys.agshmne.inventory;

import io.github.algorys.agshmne.objets.factory.AppleFactory;
import io.github.algorys.agshmne.objets.factory.RandomFactory;
import io.github.algorys.agshmne.objets.factory.StrongAxeFactory;

public class InventoryFactorySample {
	public static void main(String[] args) {
		RandomFactory rf = new RandomFactory();
		rf.addFactory(new AppleFactory());
		rf.addFactory(new StrongAxeFactory());
		
		for(int i = 0; i < 10; i++) {
			InventoryItem r = rf.createRandom();
			System.out.println(r);
		}
	}
}
