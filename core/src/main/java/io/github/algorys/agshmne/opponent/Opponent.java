package io.github.algorys.agshmne.opponent;

import io.github.algorys.agshmne.caracteristic.CharacterAttribute;
import io.github.algorys.agshmne.opponent.beast.OpponentVital;

public interface Opponent {

	public String getName();
	
	public int getLevel();
	
	public CharacterAttribute getAttributes();
	
	public OpponentVital getVital();

}
