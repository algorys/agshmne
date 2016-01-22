package io.github.algorys.agshmne.action;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.region.Region;
import io.github.algorys.agshmne.tile.Tile;
import io.github.algorys.agshmne.tile.TileType;

public class ActionCharacter extends JPanel implements Observer {
	JButton woodButton;
	private Action cutWood;
	private Character pj;
	private Tile currentTile;
	
	public ActionCharacter(Character pj){
		this.pj = pj;
		pj.addObserver(this);
		woodButton = new JButton("Couper du bois");		
		this.add(woodButton);
		this.update(pj, null);
		
		cutWood = new AbstractAction("Couper du bois") {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Bois coupé !");				
			}
			
		};
		woodButton.setAction(cutWood);
	}

	@Override
	public void update(Observable o, Object arg) {
		this.currentTile = pj.getRegion().getTileFromPosition(pj.getPosition());
		if(this.currentTile.getType() == TileType.Wood) {
			woodButton.setEnabled(true);
		} else {
			this.woodButton.setEnabled(false);
		}		
	}
}
