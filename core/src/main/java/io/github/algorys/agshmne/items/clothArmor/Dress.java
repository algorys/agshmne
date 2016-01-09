package io.github.algorys.agshmne.items.clothArmor;

public class Dress implements Cloth {
	private final int level;

	public Dress() {
		this.level = 1;
	}
	@Override
	public int getLevel() {
		return level;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Robe ("+this.getLevel()+")";
	}
	
	@Override
	public String toString() {
		return "Robe ("+level+")";
	}

}
