package io.github.algorys.agshmne.tempItem;

import java.util.ArrayList;
import java.util.List;

import io.github.algorys.agshmne.tools.Tools;

public class ItemFactory {
	private List<String> simpleItems = new ArrayList<>();
	private List<String> stackableItems = new ArrayList<>();
	
	public ItemFactory() {
		simpleItems.add("Sword");
		simpleItems.add("Knife");
		simpleItems.add("Barrel");
		
		stackableItems.add("Apple");
		stackableItems.add("Orange");
		stackableItems.add("Nail");
		stackableItems.add("Wood");
		stackableItems.add("Copper");
	}
	
	
	public Item createItem() {		
		return new GeneralItem(simpleItems.get(Tools.dice(simpleItems.size())));
	}
	
	public IStackableItem createStackableItem() {
		String line = stackableItems.get(Tools.dice(stackableItems.size()));
		String[] parts = line.split(":");
		return new GeneralStackableItem(parts[0], Integer.parseInt(parts[1]));
	}


	public void setSimpleItems(List<String> simpleItems) {
		this.simpleItems = simpleItems;
	}


	public void setStackableItems(List<String> stackableItems) {
		this.stackableItems = stackableItems;
	}
}
