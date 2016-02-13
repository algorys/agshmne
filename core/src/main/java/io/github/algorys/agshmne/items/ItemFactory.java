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
				"Tonneau:5","Bouteille:3","Verre:2",
				"Bougie:2", "assiette:4"
				};
		simpleItems.addAll(Arrays.asList(misc));
		String[] stackies = {
				"Bois:5",
				"Viande:5", "Poisson:5", "Cuir:10",
				"Minerai,pierre:5", "Minerai,cuivre:7","Minerai,fer:10", "Minerai,Argent:20", "Minerai,Or:50", "Minerai,mythril:100",
				"Pomme:5","Orange:5","Poire:5","Pêche:5", "Figue:5",
				"Clou:5", "Rivet:5", "Caillou:0", "Lettres:1", "Feraille:1"
				};
		stackableItems.addAll(Arrays.asList(stackies));
	}
	
	
	public Item createItem() {
		String line = stackableItems.get(Tools.dice(stackableItems.size()));
		String[] parts = line.split(":");
		return new GeneralItem(parts[0], Integer.parseInt(parts[1]));
	}
	
	public IStackableItem createStackableItem() {
		String line = stackableItems.get(Tools.dice(stackableItems.size()));
		String[] parts = line.split(":");
		return new StackableItem(parts[0], 1, Integer.parseInt(parts[1]));
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
