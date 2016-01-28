package io.github.algorys.agshmne.character;

import java.beans.PropertyChangeSupport;

public class Vital {
	public final static String PROPERTY_VIE = "vie";
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
		this.mana = mana;
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
    
 
}
