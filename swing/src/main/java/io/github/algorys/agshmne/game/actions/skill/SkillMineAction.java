package io.github.algorys.agshmne.game.actions.skill;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.character.player.skills.SkillTool;
import io.github.algorys.agshmne.character.player.skills.SkillType;
import io.github.algorys.agshmne.items.stackable.StackableItem;
import io.github.algorys.agshmne.map.tile.TileType;
import io.github.algorys.agshmne.message.IMessageReceiver;
import io.github.algorys.agshmne.message.IMessageSender;
import io.github.algorys.agshmne.message.Message;
import io.github.algorys.agshmne.message.MsgType;

@SuppressWarnings("serial")
public class SkillMineAction extends AbstractAction implements IMessageSender, PropertyChangeListener {
	private final Player pj;
	private IMessageReceiver messageReceiver;

	public SkillMineAction(Player pj, IMessageReceiver msgRcvr) {
		super("Récolter du minerai");
		this.pj = pj;
		pj.addPropertyChangeListener(this);
		this.update(pj.getTile().getType());
		this.setMessageReceiver(msgRcvr);
	}

	@Override
	public void actionPerformed(ActionEvent mine) {
		int mineLevel = pj.getSkills().getSkillLevel(SkillType.miner);
		if (SkillTool.Dice(mineLevel, 10)) {
			pj.getInventory().addItem(new StackableItem("Pierre", 1, 5));
			this.sendMessage(new Message(MsgType.SUCCESS, "Vous récoltez de la Pierre !"));
		} else {
			this.sendMessage(new Message(MsgType.INFO, "Rien d'exploitable..."));
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		update(pj.getTile().getType());
	}

	private void update(TileType tileType) {
		switch (tileType) {
		case Mountain:
		case Hill:
			this.setEnabled(true);
			break;
		default:
			this.setEnabled(false);
		}
	}

	@Override
	public void setMessageReceiver(IMessageReceiver msgRcvr) {
		this.messageReceiver = msgRcvr;
	}
	
	private void sendMessage(Message msg) {
		if(this.messageReceiver != null) {
			messageReceiver.sendMessage(msg);
		}
	}
}
