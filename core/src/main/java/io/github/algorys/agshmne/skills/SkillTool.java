package io.github.algorys.agshmne.skills;

import io.github.algorys.agshmne.tools.Tools;
import io.github.algorys.agshmne.character.Character;

public class SkillTool {
	
	public static boolean Dice(int skillLevel, int difficulty){
		int dice = Tools.dice(10) + 4;
		System.out.println("Vous avez fait " + dice + " sur votre dé !");
		int score = dice + skillLevel;
		System.out.println("Votre score est de " + score + " !");
		return score >= difficulty;
	}
}
