package io.github.algorys.agshmne.game.mainpanel;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.game.actions.ActionCharacter;
import io.github.algorys.agshmne.tile.JTileInventory;

@SuppressWarnings("serial")
public class JPanRight extends JPanel {
	private JTileInventory grdInv;
	private ActionCharacter actionCharacter;
	
	public JPanRight(Player pj) {
		this.setPreferredSize(new Dimension(400, 1000));
		grdInv = new JTileInventory(pj);
		actionCharacter = new ActionCharacter(pj);
		
		JLabel jlGround = new JLabel("Objets au sol : ");
		this.add(jlGround);
		this.add("Objets à terre", grdInv);
		
		JLabel jlAction = new JLabel("Actions générales");
		this.add(jlAction);
		this.add("Actions", actionCharacter);
	}
}
