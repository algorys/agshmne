package io.github.algorys.agshmne.game.actions.skill;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.character.player.skills.SkillTool;
import io.github.algorys.agshmne.character.player.skills.SkillType;
import io.github.algorys.agshmne.items.Item;
import io.github.algorys.agshmne.items.ItemFactory;
import io.github.algorys.agshmne.message.IMessageReceiver;
import io.github.algorys.agshmne.message.IMessageSender;
import io.github.algorys.agshmne.message.Message;
import io.github.algorys.agshmne.message.MsgType;

@SuppressWarnings("serial")
public class SkillSearchCityAction extends AbstractAction implements IMessageSender, PropertyChangeListener {
	private final Player pj;
	private IMessageReceiver messageReceiver;

	public SkillSearchCityAction(Player pj, IMessageReceiver msgRcvr) {
		super("Fouiller la Ville");
		this.pj = pj;
		pj.addPropertyChangeListener(this);
		this.setEnabled(pj.getTile().isCivilized());
		this.setMessageReceiver(msgRcvr);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Vous fouillez la Ville !");
		if (SkillTool.Dice(pj.getSkills().getSkillLevel(SkillType.fouiller), 10)) {
			Item item = new ItemFactory().createRandom();
			pj.getTile().addItem(item);
			this.sendMessage(new Message(MsgType.SUCCESS, "Vous avez trouvé quelque chose : " + item.getName()));
		}
		this.setEnabled(false);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		this.setEnabled(pj.getTile().isCivilized());
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
