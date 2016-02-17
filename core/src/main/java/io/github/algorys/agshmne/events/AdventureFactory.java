package io.github.algorys.agshmne.events;

import java.util.HashMap;
import java.util.Map;

import io.github.algorys.agshmne.Game;
import io.github.algorys.agshmne.events.fight.FightFactory;
import io.github.algorys.agshmne.events.locality.LocalityFactory;
import io.github.algorys.agshmne.events.quest.QuestFactory;
import io.github.algorys.agshmne.tools.Tools;

public class AdventureFactory implements IAdventureFactory {
	private Map<AdventureType, IAdventureFactory> factories =  new HashMap<>();

	public AdventureFactory() {
		factories.put(AdventureType.QUEST, new QuestFactory());
		factories.put(AdventureType.FIGHT, new FightFactory());
		factories.put(AdventureType.LOCALITY, new LocalityFactory());
	}
	
	@Override
	public IAdventure createAdventure(Game game) {
		return factories.get(Tools.random(AdventureType.values())).createAdventure(game);
	}

}
