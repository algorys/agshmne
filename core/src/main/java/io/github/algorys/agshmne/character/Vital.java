package io.github.algorys.agshmne.character;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Vital {
	public final static String PROPERTY_VIE = "vie";
	public final static String PROPERTY_MANA = "mana";
	public final static String PROPERTY_FAIM = "faim";
	public final static String PROPERTY_FATIGUE = "fatigue";
	public static int MAX_LIFE;
	public static int MAX_MANA;
	private int life;
	private int mana;
	private int fatigue;
	private int hunger;
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	public Vital(int life, int mana, int fatigue, int hunger) {
		super();
		this.life = life;
		Vital.MAX_LIFE = life;
		Vital.MAX_MANA = mana;
		this.mana = mana;
		this.fatigue = fatigue;
		this.hunger = hunger;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		int old = this.life;
		this.life = life;
		if(this.life < 1) {
			this.life = 0;
		}
		pcs.firePropertyChange(PROPERTY_VIE, old, this.life);
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		int old = this.mana;
		this.mana = mana;
		if(this.mana < 1) {
			this.mana = 0;
		}
		pcs.firePropertyChange(PROPERTY_MANA, old, mana);
	}

	public int getFatigue() {
		return fatigue;
	}

	public void setFatigue(int fatigue) {
		int old = this.fatigue;
		this.fatigue = fatigue;
		pcs.firePropertyChange(PROPERTY_FATIGUE, old, fatigue);
	}

	public int getHunger() {
		return hunger;
	}

	public void setHunger(int hunger) {
		int old = this.hunger;
		this.hunger = hunger;
		pcs.firePropertyChange(PROPERTY_FAIM, old, PROPERTY_FAIM);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}

	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(propertyName, listener);
	}

}
