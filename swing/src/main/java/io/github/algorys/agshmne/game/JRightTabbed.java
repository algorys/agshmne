package io.github.algorys.agshmne.game;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import io.github.algorys.agshmne.inventory.GroundInv;

public class JRightTabbed extends JTabbedPane {
	private GroundInv grdInv;
	
	public JRightTabbed() {
		grdInv = new GroundInv();
		JPanel jActions = new JPanel();
		
		this.addTab("Objets à terre", grdInv);
		
		this.addTab("Actions", jActions);
	}
}
