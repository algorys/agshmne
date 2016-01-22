package io.github.algorys.agshmne.game;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import io.github.algorys.agshmne.action.ActionCharacter;
import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.inventory.GroundInv;

public class JRightTabbed extends JTabbedPane {
	private GroundInv grdInv;
	private ActionCharacter actionCharacter;
	
	public JRightTabbed(Character pj) {
		grdInv = new GroundInv(pj);
		actionCharacter = new ActionCharacter(pj);
		
		this.addTab("Objets à terre", grdInv);
		
		this.addTab("Actions", actionCharacter);
	}
}
