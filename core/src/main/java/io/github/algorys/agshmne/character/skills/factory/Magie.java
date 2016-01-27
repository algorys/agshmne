package io.github.algorys.agshmne.character.skills.factory;

import io.github.algorys.agshmne.character.skills.ISkillFactory;

public class Magie implements ISkillFactory {
	private int level;
	
	public Magie(){
		this.level = 0;
	}
	
	@Override
	public void setLevel(int lvl) {
		this.level = lvl;		
	}
		
	@Override
	public int getLevel() {
		return level;
	}
	@Override
	public String toString(){
		return "Magie";
	}

}
