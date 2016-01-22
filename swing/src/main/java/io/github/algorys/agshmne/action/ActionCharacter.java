package io.github.algorys.agshmne.action;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.items.craft.lowWood;
import io.github.algorys.agshmne.tile.Tile;
import io.github.algorys.agshmne.tile.TileType;

public class ActionCharacter extends JPanel implements Observer {
	JButton woodButton;
	JButton oreButton;
	private Action cutWood;
	private Action mineOre;
	private final Character pj;
	private Tile currentTile;
	
	public ActionCharacter(final Character pj){
		this.pj = pj;
		pj.addObserver(this);
		
		// Boutons d'action
		woodButton = new JButton("Couper du bois");
		oreButton = new JButton("Récolter Minerai");
		this.add(woodButton);
		this.add(oreButton);
		
		cutWood = new AbstractAction("Couper du bois") {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Bois coupé !");	
				pj.getInventory().addItem(new lowWood());
			}
			
		};
		woodButton.setAction(cutWood);
		
		mineOre = new AbstractAction("Récolter Minerai") {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Minerai trouvé !");	
				pj.getInventory().addItem(new lowWood());
			}
			
		};
		oreButton.setAction(mineOre);
		
		this.update(pj, null);
	}

	@Override
	public void update(Observable o, Object arg) {
		this.currentTile = pj.getRegion().getTileFromPosition(pj.getPosition());
		if(this.currentTile.getType() == TileType.Wood || this.currentTile.getType() == TileType.Forest) {
			woodButton.setEnabled(true);
		} else {
			this.woodButton.setEnabled(false);
		}
		if(this.currentTile.getType() == TileType.Mountain) {
			oreButton.setEnabled(true);
		} else {
			this.oreButton.setEnabled(false);
		}
		this.currentTile.addObserver(this);
	}
}
