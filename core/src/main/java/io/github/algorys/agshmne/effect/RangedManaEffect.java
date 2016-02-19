package io.github.algorys.agshmne.effect;

import io.github.algorys.agshmne.character.Vital;
import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.message.IMessageReceiver;
import io.github.algorys.agshmne.message.Message;
import io.github.algorys.agshmne.message.MsgType;
import io.github.algorys.agshmne.tools.Tools;

public class RangedManaEffect implements IEffect {
	private int min;
	private int max;
	private IMessageReceiver messageReceiver;

	public RangedManaEffect(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}

	@Override
	public void apply(Player pj) {
		int modifier = Tools.dice(max - min + 1) + min;
		if (modifier == 0) {
			modifier = Tools.dice(max - min + 1) + min;
		}
		Vital vital = pj.getVital();
		vital.setMana(vital.getMana() + modifier);
		if (modifier > 0) {
			this.sendMessage(new Message(MsgType.SUCCESS, "Vous récupérez " + modifier + " mana"));
		} else {
			this.sendMessage(new Message(MsgType.CRITICAL, "Vous perdez " + (-modifier) + " mana"));
		}
	}

	@Override
	public void setMessageReceiver(IMessageReceiver msgRcvr) {
		this.messageReceiver = msgRcvr;
	}

	private void sendMessage(Message msg) {
		if (this.messageReceiver != null) {
			this.messageReceiver.sendMessage(msg);
		}
	}
}
