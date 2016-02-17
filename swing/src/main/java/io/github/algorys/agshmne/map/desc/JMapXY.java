package io.github.algorys.agshmne.map.desc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import io.github.algorys.agshmne.Game;
import io.github.algorys.agshmne.JPosition;
import io.github.algorys.agshmne.tile.JTile;

@SuppressWarnings("serial")
public class JMapXY extends JPanel {
	private final JPosition jPosition;
	private final JLabel jlTurn = new JLabel("Début Campagne");

	public JMapXY(Game game) {
		this.setPreferredSize(new Dimension(700, 30));
		this.setBackground(Color.black);
		JLabel jlPosition = new JLabel("Position : ");
		jlPosition.setForeground(Color.green);
		Image img;
		try {
			img = ImageIO.read(JTile.class.getClassLoader().getResource("compass.png"));
			Image newimg = img.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
			ImageIcon newIcon = new ImageIcon(newimg);
			jlPosition.setIcon(newIcon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jlTurn.setForeground(Color.cyan);
		jPosition = new JPosition(game.getPosition());
		jPosition.setForeground(Color.green);
		this.add(jlTurn);
		this.add(jlPosition);
		this.add(jPosition);

		setDescPosition(game);
	}

	public void setDescPosition(Game game) {
		jPosition.setPosition(game.getPosition());
		jlTurn.setText("Tour " + game.getTurn());
	}
}
