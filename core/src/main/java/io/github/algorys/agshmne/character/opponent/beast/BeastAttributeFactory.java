package io.github.algorys.agshmne.character.opponent.beast;

import io.github.algorys.agshmne.character.Attribute;
import io.github.algorys.agshmne.tools.Tools;

public class BeastAttributeFactory {

	public BeastAttributeFactory() {
	}
	
	public Attribute createAttributes(int level) {
		Attribute attributes = new Attribute();
		attributes.setFOR(Tools.dice(10) + level);
		attributes.setDEX(Tools.dice(10) + level);
		attributes.setCON(Tools.dice(10) + level);
		attributes.setINT(Tools.dice(2) + level);
		attributes.setCHA(Tools.dice(5) + level);
		return attributes;
	}
}
