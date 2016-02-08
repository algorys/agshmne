package io.github.algorys.agshmne.map.desc;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.map.Position;

@SuppressWarnings("serial")
public class JMapXY extends JPanel {
	JLabel jlPosition = new JLabel("Position inconnue");
	
	public JMapXY(Player pj){
		this.setPreferredSize(new Dimension(700, 20));
		this.setBackground(Color.black);
		jlPosition.setForeground(Color.green);
		jlPosition.setText("Position : " + pj.getPosition().getX() + ", " + pj.getPosition().getY());
		
		this.add(jlPosition);
	}

	public void setDescPosition(Position position) {
		jlPosition.setText("Position : " + position.getX() + ", " + position.getY());
	}
}
