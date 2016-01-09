package io.github.algorys.agshmne.inventory;

import io.github.algorys.agshmne.items.factory.AppleFactory;
import io.github.algorys.agshmne.items.factory.CloakFactory;
import io.github.algorys.agshmne.items.factory.NailFactory;
import io.github.algorys.agshmne.items.factory.OrangeFactory;
import io.github.algorys.agshmne.items.factory.PotionManaFactory;
import io.github.algorys.agshmne.items.factory.RandomFactory;
import io.github.algorys.agshmne.items.factory.StrongAxeFactory;

public class InventoryFactorySample {
	public static void main(String[] args) {
		RandomFactory rf = new RandomFactory();
		rf.addFactory(new AppleFactory());
		rf.addFactory(new StrongAxeFactory());
		rf.addFactory(new NailFactory());
		rf.addFactory(new PotionManaFactory());
		rf.addFactory(new CloakFactory());
		rf.addFactory(new OrangeFactory());
		
		for(int i = 0; i < 20; i++) {
			InventoryItem r = rf.createRandom();
			System.out.println(r);
		}
	}
}
