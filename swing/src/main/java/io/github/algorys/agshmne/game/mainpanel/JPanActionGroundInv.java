package io.github.algorys.agshmne.game.mainpanel;

import javax.swing.JTabbedPane;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.game.actions.ActionCharacter;
import io.github.algorys.agshmne.tile.JTileInventory;

@SuppressWarnings("serial")
public class JPanActionGroundInv extends JTabbedPane {
	private JTileInventory grdInv;
	private ActionCharacter actionCharacter;
	
	public JPanActionGroundInv(Player pj) {
		grdInv = new JTileInventory(pj);
		actionCharacter = new ActionCharacter(pj);
		
		this.addTab("Objets à terre", grdInv);
		
		this.addTab("Actions", actionCharacter);
	}
}
