package io.github.algorys.agshmne.events.quest;

import io.github.algorys.agshmne.character.player.Player;

public interface IQuest {
	public boolean isWin(Player pj);
	
	public boolean isFinish();
	
	public void reward(Player pj);
	
	public String getName();
}
