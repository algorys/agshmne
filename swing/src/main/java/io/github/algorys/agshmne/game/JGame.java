package io.github.algorys.agshmne.game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.map.region.Region;
import io.github.algorys.agshmne.map.tile.Tile;
import io.github.algorys.agshmne.movement.Position;
import io.github.algorys.agshmne.region.JRegion;

@SuppressWarnings("serial")
public class JGame extends JFrame {
	private Region region = new Region();
	private Character pj = new Character(region);
	private final JRegion jregion;

	public JGame(Character perso) {
		pj = perso;
		jregion = new JRegion(this.pj);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		// TODO Faire le panneau WEST
		JPanel jpWest = new JPanel();
		/*
		 * JPCenter : Permet d'accéder aux différentes interfaces du jeu.
		 */
		JCenterTabbed tabbedCenter = new JCenterTabbed(this.jregion);
		
		/*
		 * SOUTH : TODO : En cours...
		 */
		JPanel jpSouth = new JPanel();
		jpSouth.setPreferredSize(new Dimension(710, 100));
		BoxLayout blSouth = new BoxLayout(jpSouth, BoxLayout.Y_AXIS);
		jpSouth.setLayout(blSouth);
		final JTitleHistory titleHistory = new JTitleHistory(pj);
		Tile currentTile = pj.getTile();
		titleHistory.setTitle("Region : " + currentTile.getDesc());
		final JCivilized civilized = new JCivilized(pj);
		civilized.setCivilized(currentTile.isCivilized());
		jpSouth.add(titleHistory);
		jpSouth.add(civilized);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
			@Override
			public boolean dispatchKeyEvent(KeyEvent e) {
				if (e.getID() == KeyEvent.KEY_PRESSED) {
					System.out.println("Touché!");
					switch (e.getKeyCode()) {
					case KeyEvent.VK_LEFT:
						pj.setPosition(new Position(pj.getPosition().getX() - 1, pj.getPosition().getY()));
						titleHistory.setTitle("Region : " + pj.getTile().getDesc());
						civilized.setCivilized(pj.getTile().isCivilized());
						
						return true;
					case KeyEvent.VK_RIGHT:
						pj.setPosition(new Position(pj.getPosition().getX() + 1, pj.getPosition().getY()));
						titleHistory.setTitle("Region : " + pj.getTile().getDesc());
						civilized.setCivilized(pj.getTile().isCivilized());
						
						return true;
					case KeyEvent.VK_UP:
						pj.setPosition(new Position(pj.getPosition().getX(), pj.getPosition().getY() + 1));
						titleHistory.setTitle("Region : " + pj.getTile().getDesc());
						civilized.setCivilized(pj.getTile().isCivilized());
						
						return true;
					case KeyEvent.VK_DOWN:
						pj.setPosition(new Position(pj.getPosition().getX(), pj.getPosition().getY() - 1));
						titleHistory.setTitle("Region : " + pj.getTile().getDesc());
						civilized.setCivilized(pj.getTile().isCivilized());
						
						return true;
					}
				}
				return false;
			}

		});
		this.setFocusable(true);

		/*
		 * JPEast Objets à terres Actions pj et compétences
		 */
		JRightTabbed tabbedRight = new JRightTabbed(pj);

		/*
		 * JPWest Personnage / Ville
		 */
		JLabel jlWest = new JLabel("Personnage / Ville");
		JLabel caracWest = new JLabel("CHA : " + pj.getAttributes().getCHA());
		jpWest.add(jlWest);
		jpWest.add(caracWest);
		
		

		// Ajout Panneau Final
		JPanel contentPane = new JPanel(new BorderLayout());
		// contentPane.add(jpCenter, BorderLayout.CENTER);
		contentPane.add(tabbedCenter, BorderLayout.CENTER);
		contentPane.add(tabbedRight, BorderLayout.EAST);
		contentPane.add(jpSouth, BorderLayout.SOUTH);
		contentPane.add(jpWest, BorderLayout.WEST);

		this.setContentPane(contentPane);
		this.pack();
	}
}
