package io.github.algorys.agshmne.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.items.craft.Copper;
import io.github.algorys.agshmne.tile.TileType;

public class ActionCharacter extends JPanel {
	public ActionCharacter(final Character pj){
		// Boutons d'action
		JButton woodButton = new JButton("Couper du bois");
		JButton oreButton = new JButton("Récolter Minerai");
		this.add(woodButton);
		this.add(oreButton);
		
		woodButton.setAction(new CompetenceCutAction(pj));
		oreButton.setAction(new CompetenceMineAction(pj));
	}
}
