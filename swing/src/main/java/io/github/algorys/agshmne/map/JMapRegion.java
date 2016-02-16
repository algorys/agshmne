package io.github.algorys.agshmne.map;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import io.github.algorys.agshmne.Game;
import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.map.Position;
import io.github.algorys.agshmne.map.region.Region;
import io.github.algorys.agshmne.map.tile.Tile;
import io.github.algorys.agshmne.tile.JTile;

@SuppressWarnings("serial")
public class JMapRegion extends JPanel implements PropertyChangeListener {
	private final class MovePJMouseListener extends MouseAdapter {
		private int diffX = 0;
		private int diffY = -1;

		public MovePJMouseListener(int diffX, int diffY) {
			super();
			this.diffX = diffX;
			this.diffY = diffY;
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			if (e.getSource() instanceof JTile) {
				((JTile) e.getSource()).setBorder(new LineBorder(Color.GREEN));
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (e.getSource() instanceof JTile) {
				((JTile) e.getSource()).setBorder(BorderFactory.createLineBorder(Color.BLACK));
			}
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			Game game = JMapRegion.this.personnage.getGame();
			game.setPosition(new Position(game.getPosition().getX() + diffX, game.getPosition().getY() + diffY));
			JMapRegion.this.personnage.getRegion().newTurn();
		}
	}

	private Player personnage;
	private JTile[][] jtiles;

	public JMapRegion(Player personnage) {
		super();
		if (personnage == null) {
			throw new NullPointerException("personnage cannot be null");
		}
		this.personnage = personnage;
		this.personnage.addPropertyChangeListener(Player.PROPERTY_POSITION, this);

		Position position = personnage.getGame().getPosition();

		jtiles = new JTile[7][7];
		this.setLayout(new GridLayout(7, 7));
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				jtiles[i][j] = new JTile(personnage.getRegion()
						.getTileFromPosition(new Position(position.getX() + j - 3, position.getY() + (3 - i))));
				this.add(jtiles[i][j]);
			}
		}
		jtiles[2][3].addMouseListener(new MovePJMouseListener(0, 1));
		jtiles[4][3].addMouseListener(new MovePJMouseListener(0, -1));
		jtiles[3][2].addMouseListener(new MovePJMouseListener(-1, 0));
		jtiles[3][4].addMouseListener(new MovePJMouseListener(1, 0));
		this.setFocusable(true);
	}

	public Player getPersonnage() {
		return personnage;
	}

	private void updateDisplay() {
		Position position = this.personnage.getGame().getPosition();

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				Region region = this.personnage.getRegion();
				Position newPosition = new Position(position.getX() + j - 3, position.getY() + (3 - i));
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
		if (g instanceof Graphics2D) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(3));
			g2.setColor(new Color(178, 102, 255));
			g2.drawRoundRect(300, 300, 100, 100, 5, 5);
		} else {
			g.setColor(Color.BLUE);
			g.drawRect(150, 150, 130, 130);
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getSource() == this.personnage) {
			this.updateDisplay();
		}
	}
}
