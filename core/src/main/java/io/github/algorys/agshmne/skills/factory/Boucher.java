package io.github.algorys.agshmne.skills.factory;

import io.github.algorys.agshmne.skills.ISkillFactory;

public class Boucher implements ISkillFactory {
	private int level;
	
	public Boucher(){
		this.level = 0;
	}
	
	public void setLevel(int lvl) {
		this.level = lvl;
	}
	
	@Override
	public int getLevel() {
		return level;
	}
	@Override
	public String toString(){
		return "Boucherie";
	}

}
