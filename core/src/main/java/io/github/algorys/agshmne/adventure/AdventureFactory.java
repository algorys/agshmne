package io.github.algorys.agshmne.adventure;

import java.util.HashMap;
import java.util.Map;

import io.github.algorys.agshmne.Game;
import io.github.algorys.agshmne.adventure.fight.FightFactory;
import io.github.algorys.agshmne.adventure.locality.LocalityFactory;
import io.github.algorys.agshmne.adventure.quest.QuestFactory;
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
		IAdventure adventure = factories.get(Tools.random(AdventureType.values())).createAdventure(game);
		adventure.setMessageReceiver(game);
		return adventure;
	}

}
