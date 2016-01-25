package io.github.algorys.agshmne.items.craft.ore;

import io.github.algorys.agshmne.inventory.CraftItem;
import io.github.algorys.agshmne.inventory.StackableItemAdapter;

public class Silver extends StackableItemAdapter implements Ore, CraftItem {
	
	@Override
	public int getWeight() {
		return 1;
	}

	@Override
	public OreType getOreType() {
		return OreType.Silver;
	}

	@Override
	public String getName() {
		return "Minerai d'argent";
	}

}
