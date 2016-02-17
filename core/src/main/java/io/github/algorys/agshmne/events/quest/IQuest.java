package io.github.algorys.agshmne.events.quest;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.events.IAdventure;
import io.github.algorys.agshmne.map.tile.Tile;

public interface IQuest extends IAdventure {
	public boolean isWin(Player pj);
	
	public void accept(Player pj);
	
	public boolean isFinish();
	
	public void reward(Player pj);
	
	public String getName();
	
	public String getGoal();
	
	public Tile getDestination();
}
