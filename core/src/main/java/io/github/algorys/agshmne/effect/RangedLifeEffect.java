package io.github.algorys.agshmne.effect;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.tools.Tools;

public class RangedLifeEffect implements IEffect {
	private int min;
	private int max;

	public RangedLifeEffect(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}

	@Override
	public void apply(Player pj) {
		int current = Tools.dice(max - min + 1) + min;
		pj.getVital().setVie(pj.getVital().getVie() + current);
	}
}
