package io.github.algorys.agshmne.effect;

import io.github.algorys.agshmne.character.Vital;
import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.message.IMessageReceiver;
import io.github.algorys.agshmne.message.Message;
import io.github.algorys.agshmne.message.MsgType;

public class ManaEffect implements IEffect {
	private int modifier;
	private IMessageReceiver messageReceiver;

	public ManaEffect(int modifier) {
		super();
		this.modifier = modifier;
	}

	@Override
	public void apply(Player pj) {
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
