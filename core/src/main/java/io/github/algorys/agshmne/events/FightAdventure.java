package io.github.algorys.agshmne.events;

import io.github.algorys.agshmne.character.opponent.beast.Beast;
import io.github.algorys.agshmne.character.opponent.beast.BeastFactory;
import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.fight.Fight;

public class FightAdventure {
	private Fight fight;

	public FightAdventure(Player pj) {
		Beast beast = new BeastFactory().createBeast();
		fight = new Fight(pj, beast);
	}

	public Fight getFight() {
		return fight;
	}

}
