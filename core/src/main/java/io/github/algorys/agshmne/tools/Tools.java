package io.github.algorys.agshmne.tools;

import java.util.Arrays;

import io.github.algorys.agshmne.items.ItemFactory;

public class Tools {
	public static int dice(int d){
		int dice = (int)(Math.random()*d);
		return dice;
	}
	
	public ItemFactory getFruitFactory() {
		ItemFactory myFruitFactory = new ItemFactory();
		myFruitFactory.setSimpleItems(Arrays.asList("Ananas", "Rutabaga"));
		myFruitFactory.setStackableItems(Arrays.asList("Apple", "Orange", "Abricot"));
		return myFruitFactory;
	}
}
