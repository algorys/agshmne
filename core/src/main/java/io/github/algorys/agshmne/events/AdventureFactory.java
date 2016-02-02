package io.github.algorys.agshmne.events;

import java.util.HashMap;
import java.util.Map;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.events.quest.QuestFactory;
import io.github.algorys.agshmne.tools.Tools;

public class AdventureFactory implements IAdventureFactory {
	private Map<AdventureType, IAdventureFactory> factories =  new HashMap<>();

	public AdventureFactory() {
		IAdventureFactory quest = new QuestFactory();
		
		factories.put(AdventureType.QUEST, quest);
	}
	
	public IAdventure createAdventure(Player pj) {
		return factories.get(Tools.random(AdventureType.values())).createAdventure(pj);
	}

}
