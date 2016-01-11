package io.github.algorys.agshmne.inventory;

import javax.swing.JFrame;

public class InventoryGroungTest {

	public static void main(String[] args) {
		GroundInv grdInv = new GroundInv();
		JFrame jf = new JFrame("Inventory Ground...");
		
		jf.add(grdInv);
		jf.setSize(300, 300);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);

	}

}
