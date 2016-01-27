package io.github.algorys.agshmne.character;

public class Vital {

	private int vie;
	private int mana;
	private int fatigue;
	private int faim;

	public Vital(int vie, int mana, int fatigue, int faim) {
		super();
		this.vie = vie;
		this.mana = mana;
		this.fatigue = fatigue;
		this.faim = faim;
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getFatigue() {
		return fatigue;
	}

	public void setFatigue(int fatigue) {
		this.fatigue = fatigue;
	}

	public int getFaim() {
		return faim;
	}

	public void setFaim(int faim) {
		this.faim = faim;
	}
    
 
}
