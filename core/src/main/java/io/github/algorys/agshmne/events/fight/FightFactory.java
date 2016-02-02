package io.github.algorys.agshmne.events.fight;

import io.github.algorys.agshmne.character.opponent.beast.BeastFactory;
import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.events.IAdventureFactory;

public class FightFactory implements IAdventureFactory {

	private BeastFactory beastFactory = new BeastFactory();

	@Override
	public Fight createAdventure(Player pj) {
		return new Fight(pj, beastFactory.createBeast());
	}

}
