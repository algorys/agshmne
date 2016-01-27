package io.github.algorys.agshmne.character.player.skills.factory;

import java.util.HashMap;
import java.util.Map;

import io.github.algorys.agshmne.character.player.skills.ISkillFactory;
import io.github.algorys.agshmne.character.player.skills.SkillType;

public class SkillFactory {
	private Map<SkillType, ISkillFactory> skillFactories = new HashMap<>();
	
	public SkillFactory() {
		ISkillFactory Boucher = new Boucher();
		ISkillFactory Bucheron = new Bucheron();
		ISkillFactory Cuisiner = new Cuisiner();
		ISkillFactory Cultiver = new Cultiver();
		ISkillFactory Fouiller = new Fouiller();
		ISkillFactory Magie = new Magie();
		ISkillFactory Miner = new Miner();
		ISkillFactory Pecher = new Pecher();
		
		skillFactories.put(SkillType.boucherie, Boucher);
		skillFactories.put(SkillType.bucheron, Bucheron);
		skillFactories.put(SkillType.cuisine, Cuisiner);
		skillFactories.put(SkillType.cultiver, Cultiver);
		skillFactories.put(SkillType.fouiller, Fouiller);
		skillFactories.put(SkillType.magie, Magie);
		skillFactories.put(SkillType.miner, Miner);
		skillFactories.put(SkillType.pecher, Pecher);
		
	}
	
	public String getSkillName(SkillType type) {
		return skillFactories.get(type).toString();
	}
	
	public int getSkillLevel(SkillType type) {
		return skillFactories.get(type).getLevel();
	}
	
	public void setSkillLevel(SkillType type, int lvl) {
		this.skillFactories.get(type).setLevel(lvl);
	}

	public Map<SkillType, ISkillFactory> getSkillFactories() {
		return skillFactories;
	}
}
