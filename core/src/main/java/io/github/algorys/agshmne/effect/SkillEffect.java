package io.github.algorys.agshmne.effect;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.character.player.skills.SkillType;

public class SkillEffect implements IEffect {
	private SkillType skillType;
	private int modifier;

	public SkillEffect(SkillType skillType, int modifier) {
		super();
		this.skillType = skillType;
		this.modifier = modifier;
	}

	@Override
	public void apply(Player pj) {
		int level = pj.getSkills().getSkillLevel(skillType);
		pj.getSkills().setSkillLevel(skillType, level + modifier);
	}

}
