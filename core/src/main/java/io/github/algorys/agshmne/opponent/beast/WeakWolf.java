package io.github.algorys.agshmne.opponent.beast;

import io.github.algorys.agshmne.opponent.Opponent;

public class WeakWolf implements Opponent, Beast {
	private BeastAttributeFactory attributeFactory;
	private int level;
	
	public WeakWolf() {
		attributeFactory = new BeastAttributeFactory(this.getLevel());
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
	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public BeastAttributeFactory getAttributes() {
		return attributeFactory;
	}

}
