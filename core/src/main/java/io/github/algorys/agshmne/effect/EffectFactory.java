package io.github.algorys.agshmne.effect;

import java.util.ArrayList;
import java.util.List;

import io.github.algorys.agshmne.character.player.skills.SkillType;
import io.github.algorys.agshmne.tools.Tools;

public class EffectFactory {
	public IEffect createRandomSkillEffect(int modifier) {
		List<IEffect> effects = new ArrayList<>();
		for (SkillType type : SkillType.values()) {
			effects.add(new SkillEffect(type, modifier));
		}
		return new RandomEffect(effects);
	}
	
	public IEffect createRandomLifeEffect() {
		return new RangedLifeEffect(-10, +10);
	}
	
	public IEffect createRandomManaEffect() {
		return new RangedManaEffect(-10, +10);
	}

	public IEffect fromString(String singleCarac) {
		IEffect effectToApply;
		String carac = singleCarac.substring(0, 4);
		int modifier = Integer.parseInt(singleCarac.substring(4));
		if (Tools.dice(2) == 1) {
			modifier = -modifier;
		}
		if ("LIFE".equals(carac)) {
			effectToApply = new LifeEffect(modifier);
		} else if ("MANA".equals(carac)) {
			effectToApply = new ManaEffect(modifier);
		} else {
			throw new IllegalArgumentException(String.format("Le paramètre input [%s] n'est pas reconnu", singleCarac));
		}
		return effectToApply;
	}
}
