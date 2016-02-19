package io.github.algorys.agshmne.adventure.locality;

import io.github.algorys.agshmne.adventure.IAdventure;
import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.effect.IEffect;
import io.github.algorys.agshmne.message.IMessageReceiver;
import io.github.algorys.agshmne.message.Message;

public class Locality implements IAdventure {
	private String name;
	private IEffect effect;
	private String desc;
	private String descEffect;
	private IMessageReceiver messageReceiver;

	public Locality(String name, IEffect effect, String desc, final String descEffect) {
		this.name = name;
		this.effect = effect;
		this.effect.setMessageReceiver(new IMessageReceiver() {
			@Override
			public void sendMessage(Message message) {
				Locality.this.sendMessage(new Message(message.getType(), descEffect + message.getMessage()));
			}
		});
		this.desc = desc;
		this.descEffect = descEffect;
	}

	public void interact(Player pj) {
		this.effect.apply(pj);
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	public String getDescEffect() {
		return descEffect;
	}

	@Override
	public void setMessageReceiver(IMessageReceiver msgRcvr) {
		this.messageReceiver = msgRcvr;
	}

	private void sendMessage(Message msg) {
		if (this.messageReceiver != null) {
			messageReceiver.sendMessage(msg);
		}
	}
}
