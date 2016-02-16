package io.github.algorys.agshmne.map.desc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.game.mainpanel.JPanMain;
import io.github.algorys.agshmne.tile.JTile;

@SuppressWarnings("serial")
public class JMapXY extends JPanel {
	JLabel jlPosition = new JLabel("Position inconnue");
	JLabel jlTurn = new JLabel("Début Campagne");
	
	public JMapXY(Player pj){
		this.setPreferredSize(new Dimension(700, 30));
		this.setBackground(Color.black);
		jlPosition.setForeground(Color.green);
		Image img;
		try {
			img = ImageIO.read(JTile.class.getClassLoader().getResource("compass.png"));
			Image newimg = img.getScaledInstance(32, 32,  java.awt.Image.SCALE_SMOOTH);
			ImageIcon newIcon = new ImageIcon(newimg);
			jlPosition.setIcon(newIcon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jlPosition.setText("Position : " + pj.getPosition().getX() + ", " + pj.getPosition().getY());
		jlTurn.setForeground(Color.cyan);
		jlTurn.setText("Tour " + pj.getRegion().getTurn());
		
		this.add(jlTurn);
		this.add(jlPosition);
	}

	public void setDescPosition(Player pj) {
		jlPosition.setText("Position : " + pj.getPosition().getX() + ", " + pj.getPosition().getY());
		jlTurn.setText("Tour " + pj.getRegion().getTurn());
	}
}
