package io.github.algorys.agshmne.game;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.tile.Tile;

public class JTitleHistory extends JPanel {
	JLabel title;
	
	public JTitleHistory(Character pj){
		this.setPreferredSize(new Dimension(700, 20));
		this.setBackground(Color.lightGray);
		Tile tile = pj.getRegion().getTileFromPosition(pj.getPosition());
		title = new JLabel("[REGION] - " + tile.getType());
		this.add(title);
	}

	public void setTitle(String title) {
		this.title.setText(title);
	}
}
