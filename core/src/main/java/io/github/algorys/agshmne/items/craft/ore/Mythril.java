package io.github.algorys.agshmne.items.craft.ore;

import io.github.algorys.agshmne.inventory.CraftItem;
import io.github.algorys.agshmne.inventory.StackableItemAdapter;

public class Mythril extends StackableItemAdapter implements CraftItem, Ore {
	private OreType type;
	
	public Mythril() {
		type = OreType.Mythril;
	}
	
	@Override
	public String getName() {
		return "Minerai de Mythril";
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
