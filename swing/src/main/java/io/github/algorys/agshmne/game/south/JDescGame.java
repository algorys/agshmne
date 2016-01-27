package io.github.algorys.agshmne.game.south;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.player.Player;

@SuppressWarnings("serial")
public class JDescGame extends JPanel {
	JTitleHistory titleHistory;
	JCivilized civilized;
	
	public JDescGame(Player pj){
		this.setPreferredSize(new Dimension(710, 100));
		BoxLayout blSouth = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(blSouth);
		
		// Description Région
		titleHistory = new JTitleHistory(pj);
		titleHistory.setTitle("Region : " + pj.getTile().getDesc());
		
		// Région Civilisée
		this.civilized = new JCivilized(pj);
		this.civilized.setCivilized(pj.getTile().isCivilized());
		
		// TODO Danger aux alentour (Rouge)
		// TODO Actions Personnage**this.add(titleHistory);
		
		this.add(titleHistory);
		this.add(civilized);
	}
	
	public void updateLabels(Player pj) {
		titleHistory.setTitle("Region : " + pj.getTile().getDesc());
		civilized.setCivilized(pj.getTile().isCivilized());
	}
}
