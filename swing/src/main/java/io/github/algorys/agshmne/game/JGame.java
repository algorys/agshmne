package io.github.algorys.agshmne.game;

import java.awt.BorderLayout;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.game.history.JDescGame;
import io.github.algorys.agshmne.game.mainpanel.JPanMain;
import io.github.algorys.agshmne.game.mainpanel.JPanActionGroundInv;
import io.github.algorys.agshmne.map.JMapRegion;
import io.github.algorys.agshmne.map.Position;
import io.github.algorys.agshmne.map.region.RandomRegionFactory;
import io.github.algorys.agshmne.map.region.Region;

@SuppressWarnings("serial")
public class JGame extends JFrame {
	private Region region = new RandomRegionFactory().create();
	private Player pj = new Player(region);
	private final JMapRegion jregion;

	public JGame(Player perso) {
		pj = perso;
		jregion = new JMapRegion(this.pj);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		// TODO Faire le panneau WEST
		JPanel jpWest = new JPanel();
		/*
		 * JPCenter : Permet d'accéder aux différentes interfaces du jeu.
		 */
		JPanMain mainPan = new JPanMain(this.jregion);
		
		/*
		 * SOUTH : TODO : En cours...
		 */
		final JDescGame descGame = new JDescGame(pj);
		

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
			@Override
			public boolean dispatchKeyEvent(KeyEvent e) {
				if (e.getID() == KeyEvent.KEY_PRESSED) {
					System.out.println("Touché!");
					switch (e.getKeyCode()) {
					case KeyEvent.VK_LEFT:
						pj.setPosition(new Position(pj.getPosition().getX() - 1, pj.getPosition().getY()));
						return true;
					case KeyEvent.VK_RIGHT:
						pj.setPosition(new Position(pj.getPosition().getX() + 1, pj.getPosition().getY()));
						return true;
					case KeyEvent.VK_UP:
						pj.setPosition(new Position(pj.getPosition().getX(), pj.getPosition().getY() + 1));
						return true;
					case KeyEvent.VK_DOWN:
						pj.setPosition(new Position(pj.getPosition().getX(), pj.getPosition().getY() - 1));
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
		JPanActionGroundInv tabbedRight = new JPanActionGroundInv(pj);

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
		contentPane.add(mainPan, BorderLayout.CENTER);
		contentPane.add(tabbedRight, BorderLayout.EAST);
		contentPane.add(descGame, BorderLayout.SOUTH);
		contentPane.add(jpWest, BorderLayout.WEST);

		this.setContentPane(contentPane);
		this.pack();
	}
}
