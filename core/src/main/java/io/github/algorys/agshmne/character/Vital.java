package io.github.algorys.agshmne.character;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Vital {
	public final static String PROPERTY_VIE = "vie";
	public final static String PROPERTY_MANA = "mana";
	private int vie;
	private int mana;
	private int fatigue;
	private int faim;
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	public Vital(int vie, int mana, int fatigue, int faim) {
		super();
		this.vie = vie;
		this.mana = mana;
		this.fatigue = fatigue;
		this.faim = faim;
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		int old = this.vie;
		this.vie = vie;
		pcs.firePropertyChange(PROPERTY_VIE, old, this.vie);
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		int old = this.mana;
		this.mana = mana;
		pcs.firePropertyChange(PROPERTY_MANA, old, mana);
	}

	public int getFatigue() {
		return fatigue;
	}

	public void setFatigue(int fatigue) {
		this.fatigue = fatigue;
	}

	public int getFaim() {
		return faim;
	}

	public void setFaim(int faim) {
		this.faim = faim;
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
