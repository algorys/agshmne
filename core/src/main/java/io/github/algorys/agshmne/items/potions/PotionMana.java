package io.github.algorys.agshmne.items.potions;

import io.github.algorys.agshmne.inventory.StackableItemAdapter;
import io.github.algorys.agshmne.items.fruits.Apple;

public class PotionMana extends StackableItemAdapter  implements Potion{
	private final int level;
	
	public PotionMana() {
		this.level = 1;
	}
	
	@Override
	public String getName() {
		return "Potion de Mana ("+this.getLevel()+")";
	}

	@Override
	public int getLevel() {
		return level;
	}
	
	@Override
	public String toString() {
		return "Potion de Mana ["+level+"] (" + PotionMana.this.getCount() + ")";
	}

	@Override
	public int getWeight() {
		return 0;
	}


}
