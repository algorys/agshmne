package io.github.algorys.agshmne.skills.factory;

import java.util.HashMap;
import java.util.Map;

import io.github.algorys.agshmne.skills.ISkillFactory;
import io.github.algorys.agshmne.skills.SkillType;

public class SkillFactory {
	private Map<SkillType, ISkillFactory> factories = new HashMap<>();
	
	public SkillFactory() {
		ISkillFactory Boucher = new Boucher();
		ISkillFactory Bucheron = new Bucheron();
		ISkillFactory Cuisiner = new Cuisiner();
		ISkillFactory Cultiver = new Cultiver();
		ISkillFactory Fouiller = new Fouiller();
		ISkillFactory Magie = new Magie();
		ISkillFactory Miner = new Miner();
		ISkillFactory Pecher = new Pecher();
		
		factories.put(SkillType.boucherie, Boucher);
		factories.put(SkillType.bucheron, Bucheron);
		factories.put(SkillType.cuisine, Cuisiner);
		factories.put(SkillType.cultiver, Cultiver);
		factories.put(SkillType.fouiller, Fouiller);
		factories.put(SkillType.magie, Magie);
		factories.put(SkillType.miner, Miner);
		factories.put(SkillType.pecher, Pecher);
		
	}
}
