package io.github.algorys.agshmne.events;

import java.util.HashMap;
import java.util.Map;

import io.github.algorys.agshmne.character.opponent.beast.BeastFactory;
import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.events.fight.Fight;
import io.github.algorys.agshmne.events.quest.QuestFactory;

public class AdventureFactory {
	private Map<AdventureType, IAdventure> factories =  new HashMap<>();
	private Player pj;

	public AdventureFactory(Player pj) {
		this.pj = pj;
		IAdventure fight = new Fight(pj, new BeastFactory().createBeast());
		IAdventure quest = new QuestFactory(pj);
		
		factories.put(AdventureType.FIGHT, fight);
		factories.put(AdventureType.QUEST, quest);
	}
	
	public IAdventure createAdventure(AdventureType type) {
		return factories.get(type).createAdventure(pj);
	}

}
