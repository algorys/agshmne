package io.github.algorys.agshmne.character.skills.factory;

import io.github.algorys.agshmne.character.skills.ISkillFactory;

public class Cuisiner implements ISkillFactory {
	private int level;
	
	public Cuisiner() {
		this.level = 0;
	}
	
	@Override
	public void setLevel(int lvl) {
		this.level = lvl;		
	}
	
	@Override
	public String toString() {
		return "Cuisiner";
	}

	@Override
	public int getLevel() {
		return level;
	}


}
