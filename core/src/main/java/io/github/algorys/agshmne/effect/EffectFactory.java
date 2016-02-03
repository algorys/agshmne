package io.github.algorys.agshmne.effect;

import io.github.algorys.agshmne.character.player.skills.SkillType;
import io.github.algorys.agshmne.tools.Tools;

public class EffectFactory {
	public IEffect fromString(String singleCarac) {
		IEffect effectToApply;
		String carac = singleCarac.substring(0, 4);
		int modifier = Integer.parseInt(singleCarac.substring(4));
		if(Tools.dice(2) == 1){
			modifier = -modifier;
		}
		if ("LIFE".equals(carac)) {
			effectToApply = new LifeEffect(modifier);
		} else if ("MANA".equals(carac)) {
			effectToApply =  new ManaEffect(modifier);
		} else if (carac.startsWith("C")) {
			SkillType skillType = null;
			if("CBOU".equals(carac)) {
				skillType = SkillType.boucherie;
			} else if("CBUC".equals(carac)) {
				skillType = SkillType.bucheron;
			} else if("CCUI".equals(carac)){
				skillType = SkillType.cuisine;
			} else if("CCUL".equals(carac)) {
				skillType = SkillType.cultiver;
			} else if("CFOU".equals(carac)) {
				skillType = SkillType.fouiller;
			} else if("CMAG".equals(carac)) {
				skillType = SkillType.magie;
			} else if("CMIN".equals(carac)) {
				skillType = SkillType.miner;
			} else if("CPEC".equals(carac)) {
			}
			effectToApply = new SkillEffect(skillType, modifier);
		} else {
			throw new IllegalArgumentException(
					String.format("Le paramètre input [%s] n'est pas reconnu", singleCarac));
		}
		return effectToApply;
	}
}
