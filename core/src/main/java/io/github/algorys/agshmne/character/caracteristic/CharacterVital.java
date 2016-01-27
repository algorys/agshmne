package io.github.algorys.agshmne.character.caracteristic;

public class CharacterVital {
	private int vie;
	private int mana;
	private int fatigue;
	private int faim;

    public CharacterVital (CharacterAttribute attributes, int level) {
    	vie = attributes.getCON() + 10 + level;
    	mana = attributes.getINT() + level;
    	fatigue = ((attributes.getCON() + attributes.getFOR()) / 2) + 10;
    	faim = attributes.getCON() + 10;
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
