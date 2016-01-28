package io.github.algorys.agshmne.game.south;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.player.Player;

@SuppressWarnings("serial")
public class JTitleHistory extends JPanel {
	JLabel title;
	
	public JTitleHistory(Player pj){
		this.setPreferredSize(new Dimension(700, 20));
		this.setBackground(Color.black);
		title = new JLabel("[REGION] - " + pj.getTile().getType());
		title.setForeground(Color.magenta);
		this.add(title);
	}

	public void setTitle(String title) {
		this.title.setText(title);
	}
}
