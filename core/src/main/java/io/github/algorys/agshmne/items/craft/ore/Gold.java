package io.github.algorys.agshmne.items.craft.ore;

import io.github.algorys.agshmne.inventory.CraftItem;
import io.github.algorys.agshmne.inventory.StackableItemAdapter;

public class Gold extends StackableItemAdapter implements CraftItem, Ore {
	private OreType type;
	
	public Gold() {
		type = OreType.Gold;
	}
	
	@Override
	public String getName() {
		return "Minerai d'or";
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
