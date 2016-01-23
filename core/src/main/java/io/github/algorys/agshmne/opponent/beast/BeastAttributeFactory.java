package io.github.algorys.agshmne.opponent.beast;

import io.github.algorys.agshmne.caracteristic.CharacterAttribute;
import io.github.algorys.agshmne.tools.Tools;

public class BeastAttributeFactory {
	private CharacterAttribute attributes;
	
	public BeastAttributeFactory(int level) {
		attributes.setFOR(Tools.dice(10) + level);
		attributes.setDEX(Tools.dice(10) + level);
		attributes.setCON(Tools.dice(10) + level);
		attributes.setINT(Tools.dice(2) + level);
		attributes.setCHA(Tools.dice(5) + level);
	}
	
	public int getFor() {
		return attributes.getFOR();
	}
	
	public int getDex() {
		return attributes.getDEX();
	}
	
	public int getCon() {
		return attributes.getCON();
	}
	
	public int getInt() {
		return attributes.getINT();
	}
	
	public int getCha() {
		return attributes.getCHA();
	}
}
