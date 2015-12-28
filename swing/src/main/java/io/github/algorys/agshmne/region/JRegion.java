package io.github.algorys.agshmne.region;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import io.github.algorys.agshmne.deplacement.Position;
import io.github.algorys.agshmne.personnage.Personnage;
import io.github.algorys.agshmne.tile.JTile;
import io.github.algorys.agshmne.tile.Tile;

public class JRegion extends JPanel implements Observer {
	private Personnage personnage;
	private JTile[][] jtiles;

	public JRegion(Personnage personnage) {
		super();
		if (personnage == null) {
			throw new NullPointerException("personnage cannot be null");
		}
		this.personnage = personnage;
		this.personnage.addObserver(this);

		Position position = personnage.getPosition();

		jtiles = new JTile[7][7];
		this.setLayout(new GridLayout(7, 7));
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				jtiles[i][j] = new JTile(personnage.getRegion()
						.getTileFromPosition(new Position(position.getX() + j - 3, position.getY() + (7 - i) - 3)));
				this.add(jtiles[i][j]);
			}
		}
	}

	public Personnage getPersonnage() {
		return personnage;
	}

	public void setPersonnage(Personnage personnage) {
		if (personnage == null) {
			throw new NullPointerException("personnage ne doit pas être null");
		}
		this.personnage.deleteObserver(this);
		this.personnage = personnage;
		this.personnage.addObserver(this);
		this.updateDisplay();
	}

	private void updateDisplay() {
		Position position = this.personnage.getPosition();

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				Region region = this.personnage.getRegion();
				Position newPosition = new Position(position.getX() + j - 3, position.getY() + (7 - i) - 3);
				Tile tile = region.getTileFromPosition(newPosition);
				jtiles[i][j].setModel(tile);
			}
		}
		this.repaint();
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(350, 350);
	}

	@Override
	public void paint(Graphics g) {
		super.paintComponents(g);
		g.setPaintMode();
		if(g instanceof Graphics2D) {
			Graphics2D g2 = (Graphics2D)g;
			g2.setStroke(new BasicStroke(5));
			g2.setColor(Color.BLUE);
			g2.drawRoundRect(150, 150, 50, 50, 5, 5);
		} else {
			g.setColor(Color.BLUE);
			g.drawRect(150, 150, 50, 50);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Notifié : " + o);
		System.out.println("perso = " + personnage);
		if (o == this.personnage) {
			this.updateDisplay();
		}
	}

}
