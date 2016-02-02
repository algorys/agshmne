package io.github.algorys.agshmne.events;

import java.util.HashMap;
import java.util.Map;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.events.quest.QuestFactory;
import io.github.algorys.agshmne.tools.Tools;

public class AdventureFactory implements IAdventureFactory {
	private Map<AdventureType, IAdventureFactory> factories =  new HashMap<>();

	public AdventureFactory(Player pj) {
		IAdventureFactory quest = new QuestFactory(pj);
		
		factories.put(AdventureType.QUEST, quest);
	}
	
	public IAdventure createAdventure(Player pj) {
		return factories.get(AdventureType.values()[Tools.dice(AdventureType.values().length)]).createAdventure(pj);
	}

}
