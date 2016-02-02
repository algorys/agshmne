package io.github.algorys.agshmne.events.quest;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.events.IAdventure;

public interface IQuest extends IAdventure {
	public boolean isWin(Player pj);
	
	public boolean isFinish();
	
	public void reward(Player pj);
	
	public String getName();
	
	public String getGoal();
}
