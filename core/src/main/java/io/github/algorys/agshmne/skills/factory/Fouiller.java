package io.github.algorys.agshmne.skills.factory;

import io.github.algorys.agshmne.skills.ISkillFactory;

public class Fouiller implements ISkillFactory {
	private int level;
	
	public Fouiller(){
		this.level = 0;
	}
	
	@Override
	public void setLevel(int lvl) {
		this.level = lvl;		
	}
	
	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return level;
	}
	@Override
	public String toString(){
		return "Fouiller";
	}

}
