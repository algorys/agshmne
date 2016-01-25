package io.github.algorys.agshmne;

import java.io.File;

import io.github.algorys.agshmne.tempItem.ItemFactory;
import io.github.algorys.agshmne.tempItem.IStackableItem;
import io.github.algorys.agshmne.tools.FromFileFactory;

public class SampleItemFactoryFromFile {
	public static void main(String[] args) throws Exception {
		FromFileFactory fff = new FromFileFactory();
		ItemFactory itemFactory = fff.createFactory(new File(SampleItemFactoryFromFile.class.getClassLoader().getResource("items.txt").toURI()));
		for (int i = 0; i < 10; i++) {
			System.out.println("Simple : " + itemFactory.createItem().getName());
			IStackableItem stackable = itemFactory.createStackableItem();
			System.out.println("Stackable : " + stackable.getName() + " (" + stackable.getCount() + ")");
		}
	}
}
