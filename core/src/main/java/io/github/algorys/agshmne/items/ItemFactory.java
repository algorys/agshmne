package io.github.algorys.agshmne.items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.github.algorys.agshmne.items.stackable.IStackableItem;
import io.github.algorys.agshmne.items.stackable.StackableItem;
import io.github.algorys.agshmne.tools.Tools;

public class ItemFactory implements IItemFactory {
	private List<String> simpleItems = new ArrayList<>();
	private List<String> stackableItems = new ArrayList<>();
	
	public ItemFactory() {
		String[] misc = {
				"Tonneau","Bouteille","Verre",
				"Pierre", "gravier"
				};
		simpleItems.addAll(Arrays.asList(misc));
		String[] stackies = {
				"Bois",
				"Viande", "Poisson", "Cuir",
				"Minerai:pierre", "Minerai:cuivre","Minerai:fer", "Minerai:Argent", "Minerai:Or", "Minerai:mythril",
				"Pomme","Orange","Poire","Pêche", "Figue",
				"Clou", "Rivet", "Caillou", "Lettres", "Feraille"
				};
		stackableItems.addAll(Arrays.asList(stackies));
	}
	
	
	public Item createItem() {		
		return new GeneralItem(Tools.random(simpleItems), Tools.dice(10) +1);
	}
	
	public IStackableItem createStackableItem() {
		/*String line = stackableItems.get(Tools.dice(stackableItems.size()));
		String[] parts = line.split(":");
		return new StackableItem(parts[0], Integer.parseInt(parts[1]));*/
		return new StackableItem(Tools.random(stackableItems), 1,  Tools.dice(5) +1);
	}


	public void setSimpleItems(List<String> simpleItems) {
		this.simpleItems = simpleItems;
	}


	public void setStackableItems(List<String> stackableItems) {
		this.stackableItems = stackableItems;
	}
	
	public Item createRandom() {
		if (Tools.dice(2) == 1) {
			return createItem();
		} else {
			return createStackableItem();
		}
	}
}
