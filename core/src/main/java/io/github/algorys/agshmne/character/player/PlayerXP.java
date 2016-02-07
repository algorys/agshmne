package io.github.algorys.agshmne.character.player;

public class PlayerXP {
	private int xp;
	private int level;
	private Integer[] stepLevel = {
			1000,
			2000,
			3000,
			4000,
			5000
			
	};
	
	public PlayerXP() {
		xp = 0;
		level = 1;
	}

	public int getXp() {
		return xp;
	}

	public int getLevel() {
		return level;
	}
	
	public float getProgress() {
		float progress = (xp * 100.0f) / stepLevel[0];
		return progress;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public int getCurrentStepLevel() {
		return stepLevel[level - 1];
	}
	
	
}
