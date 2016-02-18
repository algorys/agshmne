package io.github.algorys.agshmne.character;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Vital {
	public final static String PROPERTY_LIFE = "vie";
	public final static String PROPERTY_MANA = "mana";
	public final static String PROPERTY_HUNGER = "faim";
	public final static String PROPERTY_FATIGUE = "fatigue";
	public static int MAX_LIFE;
	public static int MAX_MANA;
	public static int MAX_FATIGUE;
	public static int MAX_HUNGER;
	private int life;
	private int mana;
	private int fatigue;
	private int hunger;
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	public Vital(int life, int mana, int fatigue, int hunger) {
		super();
		Vital.MAX_LIFE = life;
		Vital.MAX_MANA = mana;
		Vital.MAX_FATIGUE = fatigue;
		Vital.MAX_HUNGER = hunger;
		this.life = life;
		this.mana = mana;
		this.fatigue = 0;
		this.hunger = 0;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		int old = this.life;
		this.life = life;
		if (this.life < 1) {
			this.life = 0;
		}
		pcs.firePropertyChange(PROPERTY_LIFE, old, this.life);
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		int old = this.mana;
		this.mana = mana;
		if (this.mana < 1) {
			this.mana = 0;
		}
		pcs.firePropertyChange(PROPERTY_MANA, old, mana);
	}

	public int getFatigue() {
		return fatigue;
	}

	public void increaseFatigue() {
		int old = fatigue;
		fatigue += 1;
		pcs.firePropertyChange(PROPERTY_FATIGUE, old, fatigue);
	}

	public void setFatigue(int fatigue) {
		int old = this.fatigue;
		this.fatigue = fatigue;
		if (this.fatigue < 1) {
			this.fatigue = 0;
		}
		pcs.firePropertyChange(PROPERTY_FATIGUE, old, this.fatigue);
	}

	public int getHunger() {
		return hunger;
	}

	public void increaseHunger() {
		int old = hunger;
		hunger += 1;
		pcs.firePropertyChange(PROPERTY_HUNGER, old, hunger);
	}

	public void setHunger(int hunger) {
		int old = this.hunger;
		this.hunger = hunger;
		if (this.hunger < 1) {
			this.hunger = 0;
		}
		pcs.firePropertyChange(PROPERTY_HUNGER, old, this.hunger);
	}

	public void checkVital() {
		int old = this.life;
		if (this.fatigue > MAX_FATIGUE) {
			this.life -= 1;
		}
		if (this.hunger > MAX_HUNGER) {
			this.life -= 1;
		}
		pcs.firePropertyChange(PROPERTY_LIFE, old, this.life);
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
