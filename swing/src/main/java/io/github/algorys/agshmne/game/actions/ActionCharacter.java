package io.github.algorys.agshmne.action;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.player.Player;

@SuppressWarnings("serial")
public class ActionCharacter extends JPanel {
	
	public ActionCharacter(final Player pj){
		this.setLayout(new GridLayout(0,1));
		// Boutons d'action
		JButton woodButton = new JButton("Couper du Bois");
		JButton oreButton = new JButton("Récolter Minerai");
		JButton fishButton = new JButton("Pêcher");
		
		JButton searchCity = new JButton("Fouiller la Ville");
		JButton searchRegion = new JButton("Fouiller la Région");
		
		this.add(woodButton);
		this.add(oreButton);
		this.add(fishButton);
		this.add(searchRegion);
		this.add(searchCity);
		
		woodButton.setAction(new SkillCutAction(pj));
		oreButton.setAction(new SkillMineAction(pj));
		fishButton.setAction(new SkillFishAction(pj));
		searchRegion.setAction(new SkillSearchRegionAction(pj));
		searchCity.setAction(new SkillSearchCityAction(pj));
	}
}
