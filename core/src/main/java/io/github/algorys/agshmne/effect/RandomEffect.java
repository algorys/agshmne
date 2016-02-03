package io.github.algorys.agshmne.effect;

import java.util.List;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.tools.Tools;

public class RandomEffect implements IEffect {
	private List<IEffect> possibles;

	public RandomEffect(List<IEffect> possibles) {
		super();
		this.possibles = possibles;
	}

	@Override
	public void apply(Player pj) {
		IEffect effect = Tools.random(possibles);
		effect.apply(pj);
	}

}
