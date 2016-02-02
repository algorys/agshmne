package io.github.algorys.agshmne.events.fight;

import io.github.algorys.agshmne.character.opponent.beast.BeastFactory;
import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.events.IAdventure;
import io.github.algorys.agshmne.events.IAdventureFactory;

public class FightFactory implements IAdventureFactory {

	@Override
	public IAdventure createAdventure(Player pj) {
		return new Fight(pj, new BeastFactory().createBeast());
	}

}
