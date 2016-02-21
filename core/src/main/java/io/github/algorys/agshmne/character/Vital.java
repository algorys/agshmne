package io.github.algorys.agshmne.character;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import io.github.algorys.agshmne.message.IMessageReceiver;
import io.github.algorys.agshmne.message.IMessageSender;
import io.github.algorys.agshmne.message.Message;
import io.github.algorys.agshmne.message.MsgType;

public class Vital implements IMessageSender {
	public final static String PROPERTY_LIFE = "vie";
	public final static String PROPERTY_MANA = "mana";
	public final static String PROPERTY_HUNGER = "faim";
	public final static String PROPERTY_FATIGUE = "fatigue";
	private final int maxLife;
	private final int maxMana;
	private final int maxFatigue;
	private final int maxHunger;
	private int life;
	private int mana;
	private int fatigue;
	private int hunger;
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	private IMessageReceiver messageReceiver;

	public Vital(int life, int mana, int fatigue, int hunger) {
		super();
		this.maxLife = life;
		this.maxMana = mana;
		this.maxFatigue = fatigue;
		this.maxHunger = hunger;
		this.life = life;
		this.mana = mana;
		this.fatigue = 0;
		this.hunger = 0;
	}

	private int checkVitalLimit(int carac, int max) {
		if (carac < 1) {
			carac = 0;
		}
		if (carac > max) {
			carac = max;
		}
		return carac;
	}
	
	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		int old = this.life;
		this.life = life;
		this.life = checkVitalLimit(this.life, this.maxLife);
		pcs.firePropertyChange(PROPERTY_LIFE, old, this.life);
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		int old = this.mana;
		this.mana = mana;
		this.mana = checkVitalLimit(this.mana, this.maxMana);
		pcs.firePropertyChange(PROPERTY_MANA, old, this.mana);
	}

	public int getFatigue() {
		return fatigue;
	}

	public void increaseFatigue() {
		int old = fatigue;
		fatigue += 1;
		pcs.firePropertyChange(PROPERTY_FATIGUE, old, this.fatigue);
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
		pcs.firePropertyChange(PROPERTY_HUNGER, old, this.hunger);
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
		int old = life;
		if (this.fatigue > maxFatigue) {
			life -= 1;
			sendMessage(new Message(MsgType.CRITICAL, "Vous perdez un PDV car vous êtes trop fatigué."));
		}
		if (this.hunger > maxHunger) {
			life -= 1;
			sendMessage(new Message(MsgType.CRITICAL, "Vous perdez un PDV car vous crevez la dalle."));
		}
		pcs.firePropertyChange(PROPERTY_LIFE, old, life);
	}

	private void sendMessage(Message msg) {
		if(messageReceiver != null) {
			messageReceiver.sendMessage(msg);
		}
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

	@Override
	public void setMessageReceiver(IMessageReceiver msgRcvr) {
		this.messageReceiver = msgRcvr;
	}

	public int getMaxLife() {
		return maxLife;
	}

	public int getMaxMana() {
		return maxMana;
	}

	public int getMaxFatigue() {
		return maxFatigue;
	}

	public int getMaxHunger() {
		return maxHunger;
	}
}
