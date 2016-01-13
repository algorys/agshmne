package io.github.algorys.agshmne.game;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import io.github.algorys.agshmne.inventory.GroundInv;
import io.github.algorys.agshmne.character.Character;

public class JRightTabbed extends JTabbedPane {
	private GroundInv grdInv;
	
	public JRightTabbed(Character pj) {
		grdInv = new GroundInv(pj);
		JPanel jActions = new JPanel();
		
		this.addTab("Objets à terre", grdInv);
		
		this.addTab("Actions", jActions);
	}
}
