package io.github.algorys.agshmne.events.fight;

import io.github.algorys.agshmne.character.Attribute;
import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.character.Vital;
import io.github.algorys.agshmne.events.IAdventure;
import io.github.algorys.agshmne.message.IMessageReceiver;
import io.github.algorys.agshmne.message.IMessageSender;
import io.github.algorys.agshmne.message.Message;
import io.github.algorys.agshmne.tools.Tools;

public class Fight implements IAdventure, IMessageSender {
	private int round = 1;
	private Character pj;
	private Character adv;
	private IMessageReceiver messageReceiver;

	public Fight(Character pj, Character adv) {
		this.pj = pj;
		this.adv = adv;
	}

	public void newRound() {
		round += 1;
	}

	public int pjAttack() {
		int pjAttack = 0;
		Attribute currentAttributes = pj.getCurrentAttributes();
		if(currentAttributes.getDEX() > currentAttributes.getFOR()) {
			pjAttack = this.attack(currentAttributes.getDEX(), adv.getLevel());
		}else{
			pjAttack = this.attack(currentAttributes.getFOR(), adv.getLevel());
		}
		if (pjAttack < -5) {
			pjAttack = -5;
		}
		final int perteDeVie;
		if (pjAttack > 0) {
			perteDeVie = pjAttack;
			sendMessage(new Message("Vous portez votre coup, et vous lui faites " + perteDeVie + " dégats."));
		} else if(pjAttack == 0) {
			perteDeVie = 1;
			sendMessage(new Message("Vous pichenette lui fait perdre 1 pdv."));
		} else {
			perteDeVie = 0;
			sendMessage(new Message("Vous échouez lamentablement."));
		}
		Vital vital = adv.getVital();
		vital.setLife(vital.getLife() - perteDeVie);
		return pjAttack;
	}

	private void sendMessage(Message message) {
		if(messageReceiver != null) {
			messageReceiver.sendMessage(message);
		}
	}

	public int mobAttack() {
		int mobAttack = this.attack(adv.getCurrentAttributes().getDEX(), 10 + pj.getLevel());
		if (mobAttack < -5) {
			mobAttack = -5;
		}
		if (mobAttack > 0) {
			pj.getVital().setLife(pj.getVital().getLife() - mobAttack);
		} else if(mobAttack == 0) {
			pj.getVital().setLife(pj.getVital().getLife() - 1);
		}
		return mobAttack;
	}

	public boolean isFinish() {
		return this.pj.getVital().getLife() <= 0 || this.adv.getVital().getLife() <= 0;
	}

	private int attack(int carac, int level) {
		int dice = Tools.dice(20);
		int difficulty = 10 + (level*2);
		int attack = dice + (carac / 2) - difficulty;
		return attack;
	}

	public Character getLeftOpponent() {
		return pj;
	}

	public Character getRightOpponent() {
		return adv;
	}

	public int getRound() {
		return round;
	}
	
	@Override
	public void setMessageReceiver(IMessageReceiver msgRcvr) {
		this.messageReceiver = msgRcvr;
	}
}
