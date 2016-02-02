package io.github.algorys.agshmne.tools;

import java.util.Arrays;
import java.util.Collection;

import io.github.algorys.agshmne.items.IItemFactory;
import io.github.algorys.agshmne.items.ItemFactory;

public class Tools {
	public static int dice(int d) {
		int dice = (int) (Math.random() * d);
		return dice;
	}

	public static <T> T random(T... possibles) {
		return possibles[dice(possibles.length)];
	}

	@SuppressWarnings("unchecked")
	public static <T> T random(Collection<T> possibles) {
		return (T) random(possibles.toArray());
	}

	public IItemFactory getFruitFactory() {
		ItemFactory myFruitFactory = new ItemFactory();
		myFruitFactory.setSimpleItems(Arrays.asList("Ananas", "Rutabaga"));
		myFruitFactory.setStackableItems(Arrays.asList("Apple", "Orange", "Abricot"));
		return myFruitFactory;
	}
}
