package io.github.algorys.agshmne.danger;

public class Danger {
	private int lvl;
	
	public Danger(){
		lvl = 0;
	}
	
	public boolean isDanger(){
		if(this.lvl >= 10){
			return true;
		}
		return false;
	}
}
