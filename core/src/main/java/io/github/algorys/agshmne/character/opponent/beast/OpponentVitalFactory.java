package io.github.algorys.agshmne.character.opponent.beast;

import io.github.algorys.agshmne.character.Attribute;
import io.github.algorys.agshmne.character.Vital;

public class OpponentVitalFactory {

	public OpponentVitalFactory() {
		
	}
	
	public Vital createVital(Attribute attributes, int level) {
		int vie = attributes.getCON() + 5 + level;
    	int mana = attributes.getINT() + level;
		Vital vital = new Vital(vie, mana, 0, 0);
		return vital;
	}
}
