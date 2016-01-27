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

import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.map.Position;
import io.github.algorys.agshmne.map.region.Region;
import io.github.algorys.agshmne.map.tile.Tile;
import io.github.algorys.agshmne.tile.JTile;

@SuppressWarnings("serial")
public class JRegion extends JPanel implements Observer {
	private Character personnage;
	private JTile[][] jtiles;

	public JRegion(Character personnage) {
		super();
		if (personnage == null) {
			throw new NullPointerException("personnage cannot be null");
		}
		this.personnage = personnage;
		this.personnage.addObserver(this);

		Position position = personnage.getPosition();
		System.out.println("------- Création J Region --------");

		jtiles = new JTile[13][13];
		this.setLayout(new GridLayout(13, 13));
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 13; j++) {
				jtiles[i][j] = new JTile(personnage.getRegion()
						.getTileFromPosition(new Position(position.getX() + j - 6, position.getY() + (6 - i))));
				this.add(jtiles[i][j]);
			}
		//System.out.println("Personnage JRegion " + personnage.getPosition().getX() + ", " + personnage.getPosition().getY());
		}
		this.setFocusable(true);
	}

	public Character getPersonnage() {
		this.personnage.deleteObserver(this);
		this.personnage.addObserver(this);
		this.updateDisplay();
		return personnage;
	}

	public void setPersonnage(Character personnage) {
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

		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 13; j++) {
				Region region = this.personnage.getRegion();
				Position newPosition = new Position(position.getX() + j - 6, position.getY() + (6 - i));
				Tile tile = region.getTileFromPosition(newPosition);
				jtiles[i][j].setModel(tile);
			}
		}
		this.invalidate();
		this.repaint();
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(700, 700);
	}

	@Override
	public void paint(Graphics g) {
		super.paintComponents(g);
		g.setPaintMode();
		if(g instanceof Graphics2D) {
			Graphics2D g2 = (Graphics2D)g;
			g2.setStroke(new BasicStroke(3));
			g2.setColor(new Color(178, 102, 255));
			g2.drawRoundRect(322, 322, 50, 50, 5, 5);
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
