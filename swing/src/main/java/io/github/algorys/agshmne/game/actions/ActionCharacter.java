package io.github.algorys.agshmne.game.actions;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

import io.github.algorys.agshmne.Game;

@SuppressWarnings("serial")
public class ActionCharacter extends JPanel {
	
	public ActionCharacter(Game game){
		this.setLayout(new GridBagLayout());
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
		
		woodButton.setAction(new SkillCutAction(game.getPlayer()));
		oreButton.setAction(new SkillMineAction(game.getPlayer()));
		fishButton.setAction(new SkillFishAction(game.getPlayer()));
		searchRegion.setAction(new SkillSearchRegionAction(game));
		searchCity.setAction(new SkillSearchCityAction(game.getPlayer()));
	}
}
