package io.github.algorys.agshmne.items.craft;

import io.github.algorys.agshmne.inventory.CraftItem;
import io.github.algorys.agshmne.inventory.StackableItemAdapter;

public class Copper extends StackableItemAdapter implements CraftItem, Ore {
	private OreType type;
	
	public Copper() {
		type = OreType.Copper;
	}
	
	@Override
	public String getName() {
		return "Minerai de Cuivre";
	}

	@Override
	public int getWeight() {
		return 1;
	}
	
	@Override
	public String toString() {
		return "Minerai de Cuivre (" + Copper.this.getCount() + ")";
	}

	@Override
	public OreType getOreType() {
		return type;
	}

}
