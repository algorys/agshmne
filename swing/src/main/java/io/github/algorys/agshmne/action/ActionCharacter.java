package io.github.algorys.agshmne.action;

import javax.swing.JButton;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.Character;

public class ActionCharacter extends JPanel {
	public ActionCharacter(final Character pj){
		// Boutons d'action
		JButton woodButton = new JButton("Couper du Bois");
		JButton oreButton = new JButton("Récolter Minerai");
		JButton searchRegion = new JButton("Fouiller la Ville");
		
		this.add(woodButton);
		this.add(oreButton);
		this.add(searchRegion);
		
		woodButton.setAction(new SkillCutAction(pj));
		oreButton.setAction(new SkillMineAction(pj));
		searchRegion.setAction(new SkillSearchCityAction(pj));
	}
}
