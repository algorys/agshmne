package io.github.algorys.agshmne.character.player.skills;

public class Skill {
	private SkillType skillType;
	private int level;

	public Skill(SkillType type, int level) {
		this.skillType = type;
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public SkillType getType() {
		return skillType;
	}

}
