package io.github.algorys.agshmne.character.opponent;

import io.github.algorys.agshmne.character.caracteristic.CharacterAttribute;
import io.github.algorys.agshmne.character.opponent.beast.OpponentVital;

public interface Opponent {

	public String getName();
	
	public int getLevel();
	
	public CharacterAttribute getAttributes();
	
	public OpponentVital getVital();

}
