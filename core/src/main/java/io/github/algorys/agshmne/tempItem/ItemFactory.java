package io.github.algorys.agshmne.tempItem;

import java.util.ArrayList;
import java.util.List;

import io.github.algorys.agshmne.tools.Tools;

public class ItemFactory {
	private List<String> simpleItems = new ArrayList<>();
	private List<String> stackableItems = new ArrayList<>();
	
	public ItemFactory() {
		simpleItems.add("Box");
		simpleItems.add("Bottle");
		simpleItems.add("Book");
		
		stackableItems.add("Nail:1");
		stackableItems.add("Apple:1");
		stackableItems.add("Orange:1");
		stackableItems.add("Flowers:1");
		stackableItems.add("Wood:1");
	}
	
	
	public Item createItem() {
		
		return new GeneralItem(simpleItems.get(Tools.dice(simpleItems.size())));
	}
	
	public StackableItem createStackableItem() {
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
