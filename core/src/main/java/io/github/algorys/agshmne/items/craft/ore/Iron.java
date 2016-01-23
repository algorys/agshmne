package io.github.algorys.agshmne.items.craft.ore;

import io.github.algorys.agshmne.inventory.CraftItem;
import io.github.algorys.agshmne.inventory.StackableItemAdapter;

public class Iron extends StackableItemAdapter implements CraftItem, Ore {
	private OreType type;
	
	public Iron() {
		type = OreType.Iron;
	}
	
	@Override
	public String getName() {
		return "Minerai de fer";
	}

	@Override
	public int getWeight() {
		return 1;
	}

	@Override
	public OreType getOreType() {
		return type;
	}

}
