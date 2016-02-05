package io.github.algorys.agshmne.game.mainpanel;

import java.awt.Dimension;

import javax.swing.JTabbedPane;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.game.actions.ActionCharacter;
import io.github.algorys.agshmne.tile.JTileInventory;

@SuppressWarnings("serial")
public class JPanRight extends JTabbedPane {
	private JTileInventory grdInv;
	private ActionCharacter actionCharacter;
	
	public JPanRight(Player pj) {
		this.setPreferredSize(new Dimension(400, 1000));
		grdInv = new JTileInventory(pj);
		actionCharacter = new ActionCharacter(pj);
		
		this.addTab("Objets à terre", grdInv);
		
		this.addTab("Actions", actionCharacter);
	}
}
