package io.github.algorys.agshmne.items.rangeWeapon;

public class WeakBow implements Bow {
	private final int level;
	
	public WeakBow(){
		this.level = 1;
	}
	
	@Override
	public int getLevel() {
		return level;
	}

	@Override
	public String getName() {
		return "Arc ["+this.getLevel()+"]";
	}

	@Override
	public String toString() {
		return "Arc ["+level+"]";
	}
}
