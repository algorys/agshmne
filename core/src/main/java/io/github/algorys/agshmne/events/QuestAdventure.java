package io.github.algorys.agshmne.events;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.events.quest.FetchQuest;
import io.github.algorys.agshmne.items.ItemFactory;
import io.github.algorys.agshmne.tools.Tools;

public class QuestAdventure {
	private FetchQuest fetch;

	public QuestAdventure(Player pj) {
		fetch = new FetchQuest(pj, new ItemFactory().createStackableItem(), Tools.dice(4));
	}
	
	public FetchQuest getQuest() {
		return fetch;
	}
}
