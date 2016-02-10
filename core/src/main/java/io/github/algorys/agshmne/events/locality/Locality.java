package io.github.algorys.agshmne.events.locality;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.effect.IEffect;
import io.github.algorys.agshmne.events.IAdventure;

public class Locality implements IAdventure {
	private String name;
	private IEffect effect;
	private String desc;
	private String descEffect;

	public Locality(String name, IEffect effect, String desc, String descEffect) {
		this.name = name;
		this.effect = effect;
		this.desc = desc;
		this.descEffect = descEffect;
	}

	public void interact(Player pj) {
		this.effect.apply(pj);
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	public String getDescEffect() {
		return descEffect;
	}
}
