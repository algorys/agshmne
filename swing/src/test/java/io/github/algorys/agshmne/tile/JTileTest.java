package io.github.algorys.agshmne.tile;

import javax.swing.JFrame;

import io.github.algorys.agshmne.map.tile.Tile;
import io.github.algorys.agshmne.map.tile.TileType;

public class JTileTest {

	public static void main(String[] args) {
		Tile tile = new Tile(TileType.Forest, "Petit test");
		JFrame jf = new JFrame("Test JTile");
		jf.getContentPane().add(new JTile(tile));
		jf.setSize(jf.getPreferredSize());
		jf.setVisible(true);
	}

}
