package io.github.algorys.agshmne.character.opponent;

import io.github.algorys.agshmne.character.Attribute;
import io.github.algorys.agshmne.character.opponent.beast.OpponentVital;

public interface Opponent {

	public String getName();
	
	public int getLevel();
	
	public Attribute getAttributes();
	
	public OpponentVital getVital();

}
