package io.github.algorys.agshmne.game.actions;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

import io.github.algorys.agshmne.Game;
import io.github.algorys.agshmne.game.actions.skill.SkillCutAction;
import io.github.algorys.agshmne.game.actions.skill.SkillFishAction;
import io.github.algorys.agshmne.game.actions.skill.SkillMineAction;
import io.github.algorys.agshmne.game.actions.skill.SkillSearchCityAction;
import io.github.algorys.agshmne.game.actions.skill.SkillSearchRegionAction;
import io.github.algorys.agshmne.message.IMessageReceiver;
import io.github.algorys.agshmne.message.IMessageSender;

@SuppressWarnings("serial")
public class ActionCharacter extends JPanel implements IMessageSender {
	
	private IMessageReceiver messageReceiver;

	public ActionCharacter(Game game){
		this.setLayout(new GridBagLayout());
		this.setMessageReceiver(game);
		GridBagConstraints gbcActions = new GridBagConstraints();
		gbcActions.insets = new Insets(5, 5, 5, 5);
		
		// Boutons d'action
		JButton woodButton = new JButton("Couper du Bois");
		JButton oreButton = new JButton("Récolter Minerai");
		JButton fishButton = new JButton("Pêcher");
		
		JButton searchCity = new JButton("Fouiller la Ville");
		JButton searchRegion = new JButton("Fouiller la Région");
		
		gbcActions.gridy = 0;
		gbcActions.gridheight = 1;
		gbcActions.gridx = 0;
		gbcActions.gridwidth = 4;
		gbcActions.anchor = GridBagConstraints.CENTER;
		gbcActions.fill = GridBagConstraints.HORIZONTAL;
		this.add(woodButton, gbcActions);
		
		gbcActions.gridy = 1;
		gbcActions.gridheight = 1;
		gbcActions.gridx = 0;
		gbcActions.gridwidth = 4;
		gbcActions.anchor = GridBagConstraints.CENTER;
		gbcActions.fill = GridBagConstraints.HORIZONTAL;
		this.add(oreButton, gbcActions);
		
		gbcActions.gridy = 2;
		gbcActions.gridheight = 1;
		gbcActions.gridx = 0;
		gbcActions.gridwidth = 4;
		gbcActions.anchor = GridBagConstraints.CENTER;
		gbcActions.fill = GridBagConstraints.HORIZONTAL;
		this.add(fishButton, gbcActions);
		
		gbcActions.gridy = 3;
		gbcActions.gridheight = 1;
		gbcActions.gridx = 0;
		gbcActions.gridwidth = 4;
		gbcActions.anchor = GridBagConstraints.CENTER;
		gbcActions.fill = GridBagConstraints.HORIZONTAL;
		this.add(searchRegion, gbcActions);
		
		gbcActions.gridy = 4;
		gbcActions.gridheight = 1;
		gbcActions.gridx = 0;
		gbcActions.gridwidth = 4;
		gbcActions.anchor = GridBagConstraints.CENTER;
		gbcActions.fill = GridBagConstraints.HORIZONTAL;
		this.add(searchCity, gbcActions);
		
		woodButton.setAction(new SkillCutAction(game.getPlayer(), messageReceiver));
		oreButton.setAction(new SkillMineAction(game.getPlayer(), messageReceiver));
		fishButton.setAction(new SkillFishAction(game.getPlayer(), messageReceiver));
		searchRegion.setAction(new SkillSearchRegionAction(game, messageReceiver));
		searchCity.setAction(new SkillSearchCityAction(game.getPlayer(), messageReceiver));
	}

	@Override
	public void setMessageReceiver(IMessageReceiver msgRcvr) {
		this.messageReceiver = msgRcvr;
	}
}
