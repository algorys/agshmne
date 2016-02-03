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
		} else if (carac.startsWith("C")) {
			SkillType skillType = null;
			if ("CBOU".equals(carac)) {
				skillType = SkillType.boucherie;
			} else if ("CBUC".equals(carac)) {
				skillType = SkillType.bucheron;
			} else if ("CCUI".equals(carac)) {
				skillType = SkillType.cuisine;
			} else if ("CCUL".equals(carac)) {
				skillType = SkillType.cultiver;
			} else if ("CFOU".equals(carac)) {
				skillType = SkillType.fouiller;
			} else if ("CMAG".equals(carac)) {
				skillType = SkillType.magie;
			} else if ("CMIN".equals(carac)) {
				skillType = SkillType.miner;
			} else if ("CPEC".equals(carac)) {
				skillType = SkillType.pecher;
			}
			effectToApply = new SkillEffect(skillType, modifier);
		} else {
			throw new IllegalArgumentException(String.format("Le paramètre input [%s] n'est pas reconnu", singleCarac));
		}
		return effectToApply;
	}
}
