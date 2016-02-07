package io.github.algorys.agshmne.game;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.game.character.JPanCharacter;
import io.github.algorys.agshmne.game.mainpanel.JPanMain;
import io.github.algorys.agshmne.game.mainpanel.JPanRight;
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

		// JPanCharacter : Personnage
		JPanCharacter jpLeft = new JPanCharacter(pj);
		
		//JPanMain : Carte, Inventaire, Equipement, Magie, Quêtes, Villes, ...
		JPanMain mainPan = new JPanMain(this.jregion);
		
		//JPanRight : Objets à terres et Actions générales
		JPanRight tabbedRight = new JPanRight(pj);
		
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

		// Ajout Panneau Final
		JPanel contentPane = new JPanel(new GridBagLayout());
		GridBagConstraints gbcGame = new GridBagConstraints();
		gbcGame.insets = new Insets(5, 5, 5, 5);
		
		gbcGame.gridy = 0;
		gbcGame.gridheight = 1;
		gbcGame.gridx = 0;
		gbcGame.gridwidth = 1;
		gbcGame.anchor = GridBagConstraints.CENTER;
		gbcGame.fill = GridBagConstraints.NONE;
		contentPane.add(jpLeft);
		
		gbcGame.gridy = 0;
		gbcGame.gridheight = 1;
		gbcGame.gridx = 1;
		gbcGame.gridwidth = 2;
		gbcGame.anchor = GridBagConstraints.CENTER;
		gbcGame.fill = GridBagConstraints.NONE;
		contentPane.add(mainPan, gbcGame);
		
		gbcGame.gridy = 0;
		gbcGame.gridheight = 1;
		gbcGame.gridx = 3;
		gbcGame.gridwidth = 1;
		gbcGame.anchor = GridBagConstraints.CENTER;
		gbcGame.fill = GridBagConstraints.NONE;
		contentPane.add(tabbedRight, gbcGame);
		
		this.setContentPane(contentPane);
		this.pack();
	}
}
