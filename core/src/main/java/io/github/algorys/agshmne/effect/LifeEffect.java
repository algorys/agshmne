package io.github.algorys.agshmne.effect;

import io.github.algorys.agshmne.character.player.Player;

public class LifeEffect implements IEffect {
	private int modifier;
	
	public LifeEffect(int modifier) {
		super();
		this.modifier = modifier;
	}

	@Override
	public void apply(Player pj) {
		pj.getVital().setLife(pj.getVital().getLife() + modifier);
	}

}
