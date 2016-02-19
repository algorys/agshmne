package io.github.algorys.agshmne.effect;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.message.IMessageSender;

public interface IEffect extends IMessageSender {
	public void apply(Player pj);
}
