package io.github.algorys.agshmne.events.locality;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.character.player.skills.SkillType;
import io.github.algorys.agshmne.events.IAdventure;
import io.github.algorys.agshmne.tools.Tools;

public class Locality implements IAdventure{
	private String name;
	private String effect;
	private String desc;
	
	public Locality(String locality, Player pj) {
		String[] caracs = locality.split(":");
		this.name = caracs[0];
		this.effect = caracs[1];
		this.desc = caracs[2];
	}
	
	public void interact(Player pj){
		applyEffect(this.effect, pj);
	}

	private void applyEffect(String singleCaracInput, Player pj) {
		String carac = singleCaracInput.substring(0, 3);
		int modifier = Integer.parseInt(singleCaracInput.substring(3));
		if(Tools.dice(2) == 1){
			modifier = -modifier;
		}
		if ("PDV".equals(carac)) {
			pj.getVital().setVie(pj.getVital().getVie() + modifier);
		} else if ("MAN".equals(carac)) {
			pj.getVital().setMana(pj.getVital().getMana() + modifier);
		} else if ("COM".equals(carac)) {
			int level = pj.getSkills().getSkillLevel(SkillType.cuisine);
			pj.getSkills().setSkillLevel(SkillType.cuisine, level + modifier);
		} else {
			throw new IllegalArgumentException(
					String.format("Le paramètre input [%s] n'est pas reconnu", singleCaracInput));
		}
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}
}
