package io.github.algorys.agshmne.action;

import javax.swing.JButton;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.Character;

public class ActionCharacter extends JPanel {
	
	public ActionCharacter(final Character pj){
		// Boutons d'action
		JButton woodButton = new JButton("Couper du Bois");
		JButton oreButton = new JButton("Récolter Minerai");
		JButton searchCity = new JButton("Fouiller la Ville");
		JButton searchRegion = new JButton("Fouiller la Région");
		
		this.add(woodButton);
		this.add(oreButton);
		this.add(searchRegion);
		this.add(searchCity);
		
		woodButton.setAction(new SkillCutAction(pj));
		oreButton.setAction(new SkillMineAction(pj));
		searchRegion.setAction(new SkillSearchRegionAction(pj));
		searchCity.setAction(new SkillSearchCityAction(pj));
	}
}
