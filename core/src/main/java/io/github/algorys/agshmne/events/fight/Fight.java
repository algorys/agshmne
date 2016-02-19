package io.github.algorys.agshmne.events.fight;

import io.github.algorys.agshmne.character.Attribute;
import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.character.Vital;
import io.github.algorys.agshmne.events.IAdventure;
import io.github.algorys.agshmne.message.IMessageReceiver;
import io.github.algorys.agshmne.message.IMessageSender;
import io.github.algorys.agshmne.message.Message;
import io.github.algorys.agshmne.message.MsgType;
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
		final int perteDeVie;
		if (pjAttack > 0) {
			perteDeVie = pjAttack;
			sendMessage(new Message(MsgType.CRITICAL, "Vous portez un coup, et vous lui faites " + perteDeVie + " de dégats."));
		} else if(pjAttack == 0) {
			perteDeVie = 1;
			sendMessage(new Message(MsgType.WARNING, "Votre pichenette lui fait perdre 1 pdv."));
		} else {
			perteDeVie = 0;
			sendMessage(new Message(MsgType.NORMAL, "Vous échouez lamentablement."));
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
		final int perteDeVie;
		if (mobAttack > 0) {
			perteDeVie = mobAttack;
			sendMessage(new Message(MsgType.CRITICAL, adv.getName() + " vous porte un coup, et vous fait " + perteDeVie + " de dégats."));
		} else if(mobAttack == 0) {
			perteDeVie = 1;
			sendMessage(new Message(MsgType.WARNING, adv.getName() + " vous fait une égratignure et vous fait perdre 1 pdv."));
		} else {
			perteDeVie = 0;
			sendMessage(new Message(MsgType.NORMAL, adv.getName() + " échoue lamentablement."));
		}
		Vital vital = pj.getVital();
		vital.setLife(vital.getLife() - perteDeVie);
		
		return mobAttack;
	}

	public boolean isFinish() {
		if(pj.getVital().getLife() <= 0) {
			sendMessage(new Message(MsgType.CRITICAL, "Vous êtes MORT !!!"));
		}
		if(adv.getVital().getLife() <= 0){
			sendMessage(new Message(MsgType.NORMAL, "Vous avez tué " + adv.getName()));
		}
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
