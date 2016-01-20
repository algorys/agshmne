package io.github.algorys.agshmne.danger;

public class Danger {
	private int danger;
	
	public Danger(){
		danger = 0;
	}
	
	public boolean isDanger(Danger danger){
		if(this.danger >= 10){
			return true;
		}
		return false;
	}
}
