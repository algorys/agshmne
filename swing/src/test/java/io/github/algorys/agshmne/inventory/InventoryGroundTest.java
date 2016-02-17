package io.github.algorys.agshmne.inventory;

import javax.swing.JFrame;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.character.player.PlayerBuilder;
import io.github.algorys.agshmne.tile.JTileInventory;

public class InventoryGroundTest {

	public static void main(String[] args) {
		Player pj = new PlayerBuilder().create();
		JTileInventory grdInv = new JTileInventory(pj);
		JFrame jf = new JFrame("Inventory Ground...");
		
		jf.add(grdInv);
		jf.setSize(300, 300);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);

	}

}
