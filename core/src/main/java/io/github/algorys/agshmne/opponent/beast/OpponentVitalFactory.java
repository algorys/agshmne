package io.github.algorys.agshmne.opponent.beast;

import io.github.algorys.agshmne.caracteristic.CharacterAttribute;

public class OpponentVitalFactory {

	public OpponentVitalFactory() {
		
	}
	
	public OpponentVital createVital(CharacterAttribute attributes, int level) {
		OpponentVital vital = new OpponentVital(attributes, level);
		return vital;
	}
}
