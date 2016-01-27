package io.github.algorys.agshmne.character.skills;

import io.github.algorys.agshmne.tools.Tools;

public class SkillTool {
	
	public static boolean Dice(int skillLevel, int difficulty){
		int dice = Tools.dice(10) + 4;
		int score = dice + skillLevel;
		return score >= difficulty;
	}
}
