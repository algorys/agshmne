package io.github.algorys.agshmne.character.opponent.beast;

import io.github.algorys.agshmne.character.Attribute;

public class OpponentVital {
	private int vie;
	private int mana;
	
	public OpponentVital(Attribute attributes, int level) {
		vie = (attributes.getCON() / 2) + 5 + level;
    	mana = attributes.getINT() + level;
	}

	public int getVie() {
		return vie;
	}

	public int getMana() {
		return mana;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}
}
