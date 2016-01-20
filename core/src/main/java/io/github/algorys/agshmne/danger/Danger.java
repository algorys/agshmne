package io.github.algorys.agshmne.danger;

public class Danger {
	private int lvl;
	
	public Danger(){
		lvl = 0;
	}
	
	public void moreDanger(){
		if(this.lvl >= 30){
			// TODO : Voir si on entame pas un nouveau Combat ? ou si on attribue de l'XP;
			this.lvl = 0;
		}
	}

	public int getLvl() {
		return lvl;
	}
}
