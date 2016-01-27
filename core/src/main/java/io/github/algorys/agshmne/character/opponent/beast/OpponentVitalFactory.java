package io.github.algorys.agshmne.character.opponent.beast;

import io.github.algorys.agshmne.character.Attribute;

public class OpponentVitalFactory {

	public OpponentVitalFactory() {
		
	}
	
	public OpponentVital createVital(Attribute attributes, int level) {
		OpponentVital vital = new OpponentVital(attributes, level);
		return vital;
	}
}
