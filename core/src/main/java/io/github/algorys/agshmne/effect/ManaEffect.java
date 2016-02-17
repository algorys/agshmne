package io.github.algorys.agshmne.effect;

import io.github.algorys.agshmne.character.Vital;
import io.github.algorys.agshmne.character.player.Player;

public class ManaEffect implements IEffect {
	private int modifier;

	public ManaEffect(int modifier) {
		super();
		this.modifier = modifier;
	}

	@Override
	public void apply(Player pj) {
		Vital vital = pj.getVital();
		vital.setMana(vital.getMana() + modifier);
	}

}
