package io.github.algorys.agshmne.items.closeWeapon;

public class WeakWand implements Wand {
	private final int level;
	
	public WeakWand() {
		this.level = 1;
	}
	
	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return level;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Bâton ["+this.getLevel()+"]";
	}
	
	@Override
	public String toString() {
		return "Hache renforcée ["+level+"]";
	}

}
