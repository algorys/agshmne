package io.github.algorys.agshmne.inventory;

import javax.swing.JFrame;

import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.region.Region;

public class InventoryGroungTest {

	public static void main(String[] args) {
		Region region = new Region();
		Character pj = new Character(region);
		GroundInv grdInv = new GroundInv(pj);
		JFrame jf = new JFrame("Inventory Ground...");
		
		jf.add(grdInv);
		jf.setSize(300, 300);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);

	}

}
