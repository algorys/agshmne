package io.github.algorys.agshmne.tile;

import io.github.algorys.agshmne.inventory.InventoryFactory;
import io.github.algorys.agshmne.tools.Outils;

public class TileRandomItem {
	private InventoryFactory invFact;
	private boolean something = false; 
	
	public TileRandomItem(){
		int dice = Outils.dice(20); 
		
		if(dice > 10){
			something = true;
			this.randomItem();
		} else {
			something = false;
		}
		
		
		
	}
	
	private void randomItem() {
		this.invFact = new InventoryFactory(); 
		
	}

	public InventoryFactory getInvFact() {
		return invFact;
	}

	public boolean isSomething() {
		return something;
	}
	
	

}
