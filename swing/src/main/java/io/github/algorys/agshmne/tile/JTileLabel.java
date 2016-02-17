package io.github.algorys.agshmne.tile;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import io.github.algorys.agshmne.JPosition;
import io.github.algorys.agshmne.map.tile.Tile;

@SuppressWarnings("serial")
public class JTileLabel extends JPanel {
	private Tile tile;
	private JLabel jlName = new JLabel();
	private JPosition jPosition = new JPosition();

	public JTileLabel(Tile tile) {
		this.setOpaque(false);
		this.setForeground(Color.WHITE);
		this.add(jlName);
		this.add(jPosition);
		setTile(tile);
	}

	@Override
	public void setForeground(Color fg) {
		super.setForeground(fg);
		if (jlName != null) {
			jlName.setForeground(fg);
		}
		if (jPosition != null) {
			jPosition.setForeground(fg);
		}
	}

	public Tile getTile() {
		return tile;
	}

	public void setTile(Tile tile) {
		jlName.setText(tile.getDesc());
		jPosition.setPosition(tile.getPosition());
		this.tile = tile;
	}
}
