package io.github.algorys.agshmne.character.opponent;

import io.github.algorys.agshmne.character.Attribute;
import io.github.algorys.agshmne.character.Vital;

public interface Opponent {

	public String getName();
	
	public int getLevel();
	
	public Attribute getAttributes();
	
	public Vital getVital();

}
