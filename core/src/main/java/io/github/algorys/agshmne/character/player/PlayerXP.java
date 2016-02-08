package io.github.algorys.agshmne.character.player;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PlayerXP {
	public static final String PROPERTY_XP = "XP";
	private static Integer[] stepLevel = {
			1000,
			2000,
			3000,
			4000,
			5000
	};
	
	private int xp;
	private int level;
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

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
		int old = this.xp;
		this.xp = xp;
		pcs.firePropertyChange(PROPERTY_XP, old, xp);
	}

	public int getCurrentStepLevel() {
		return stepLevel[level - 1];
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}

	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(propertyName, listener);
	}
	
	
}
