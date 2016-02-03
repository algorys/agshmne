package io.github.algorys.agshmne.effect;

import io.github.algorys.agshmne.character.player.Player;

public class ComposedEffect implements IEffect {
	private IEffect first;
	private IEffect second;
	
	public ComposedEffect(IEffect first, IEffect second) {
		super();
		this.first = first;
		this.second = second;
	}

	@Override
	public void apply(Player pj) {
		first.apply(pj);
		second.apply(pj);
	}

}
