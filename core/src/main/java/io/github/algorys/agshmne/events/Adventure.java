package io.github.algorys.agshmne.events;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.map.tile.Tile;

public class Adventure {

	public Adventure(Tile tile, Player pj) {
		if (tile.isDanger()) {
			FightAdventure fight = new FightAdventure(pj);
		}
		QuestAdventure quest = new QuestAdventure(pj);

	}

}
