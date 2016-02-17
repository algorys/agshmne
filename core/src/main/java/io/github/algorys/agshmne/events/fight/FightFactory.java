package io.github.algorys.agshmne.events.fight;

import io.github.algorys.agshmne.Game;
import io.github.algorys.agshmne.character.opponent.beast.BeastFactory;
import io.github.algorys.agshmne.events.IAdventureFactory;

public class FightFactory implements IAdventureFactory {

	private BeastFactory beastFactory = new BeastFactory();

	@Override
	public Fight createAdventure(Game game) {
		return new Fight(game.getPlayer(), beastFactory.createBeast());
	}

}
