package io.github.algorys.agshmne.events;

import io.github.algorys.agshmne.character.player.Player;

public interface IAdventureFactory {
	public IAdventure createAdventure(Player pj);
}
