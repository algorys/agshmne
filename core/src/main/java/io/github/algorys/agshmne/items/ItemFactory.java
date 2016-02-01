package io.github.algorys.agshmne.items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.github.algorys.agshmne.items.stackable.IStackableItem;
import io.github.algorys.agshmne.items.stackable.StackableItem;
import io.github.algorys.agshmne.tools.Tools;

public class ItemFactory {
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
				"Clou", "Rivet", "Caillou", "Lettres"
				};
		stackableItems.addAll(Arrays.asList(stackies));
	}
	
	
	public Item createItem() {		
		return new GeneralItem(simpleItems.get(Tools.dice(simpleItems.size())));
	}
	
	public IStackableItem createStackableItem() {
		/*String line = stackableItems.get(Tools.dice(stackableItems.size()));
		String[] parts = line.split(":");
		return new StackableItem(parts[0], Integer.parseInt(parts[1]));*/
		return new StackableItem(stackableItems.get(Tools.dice(stackableItems.size())), 1);
	}


	public void setSimpleItems(List<String> simpleItems) {
		this.simpleItems = simpleItems;
	}


	public void setStackableItems(List<String> stackableItems) {
		this.stackableItems = stackableItems;
	}
}
