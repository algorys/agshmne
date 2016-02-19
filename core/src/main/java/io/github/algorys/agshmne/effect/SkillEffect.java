package io.github.algorys.agshmne.effect;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.character.player.skills.SkillType;
import io.github.algorys.agshmne.message.IMessageReceiver;
import io.github.algorys.agshmne.message.Message;
import io.github.algorys.agshmne.message.MsgType;

public class SkillEffect implements IEffect {
	private SkillType skillType;
	private int modifier;
	private IMessageReceiver messageReceiver;

	public SkillEffect(SkillType skillType, int modifier) {
		super();
		this.skillType = skillType;
		this.modifier = modifier;
	}

	@Override
	public void apply(Player pj) {
		int level = pj.getSkills().getSkillLevel(skillType);
		pj.getSkills().setSkillLevel(skillType, level + modifier);
		if (modifier > 0) {
			this.sendMessage(
					new Message(MsgType.SUCCESS, "Votre compétence " + skillType + " augmente de " + modifier));
		} else {
			this.sendMessage(
					new Message(MsgType.CRITICAL, "Votre compétence " + skillType + " diminue de " + modifier));
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
