package io.github.algorys.agshmne.opponent.beast;

import io.github.algorys.agshmne.caracteristic.CharacterAttribute;
import io.github.algorys.agshmne.opponent.Opponent;

public class WeakWolf implements Opponent, Beast {
	private CharacterAttribute attributes;
	private int level;
	
	public WeakWolf(int level, CharacterAttribute attributes) {
		this.level = level;
		this.attributes = attributes;
	}
	
	@Override
	public String getName() {
		return "Loup";
	}

	@Override
	public int getLevel() {
		return level;
	}

	@Override
	public CharacterAttribute getAttributes() {
		return attributes;
	}

}
