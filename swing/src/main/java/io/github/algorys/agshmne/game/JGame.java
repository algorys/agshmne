package io.github.algorys.agshmne.game;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import io.github.algorys.agshmne.Game;
import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.game.character.JPanCharacter;
import io.github.algorys.agshmne.game.mainpanel.JPanMain;
import io.github.algorys.agshmne.game.mainpanel.JPanRight;
import io.github.algorys.agshmne.map.JMapRegion;
import io.github.algorys.agshmne.map.Position;

@SuppressWarnings("serial")
public class JGame extends JFrame {
	private Player pj;
	private final JMapRegion jregion;

	public JGame(Player perso) {
		pj = perso;
		jregion = new JMapRegion(this.pj);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		// Ajout Panneau Final
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new GridBagLayout());
		GridBagConstraints gbcGame = new GridBagConstraints();
		gbcGame.insets = new Insets(5, 5, 5, 5);
		gbcGame.fill = GridBagConstraints.BOTH;
		gbcGame.anchor = GridBagConstraints.CENTER;
		gbcGame.gridheight = 1;
		gbcGame.gridwidth = 1;
		gbcGame.gridy = 0;

		// JPanCharacter : Personnage
		gbcGame.gridx = 0;
		gbcGame.weightx = 0;
		gbcGame.weighty = 0;
		contentPane.add(new JPanCharacter(pj), gbcGame);

		// JPanMain : Carte, Inventaire, Equipement, Magie, Quêtes, Villes, ...
		gbcGame.gridx = 1;
		gbcGame.weightx = 1;
		gbcGame.weighty = 1;
		final JPanMain mainPan = new JPanMain(this.jregion);
		contentPane.add(mainPan, gbcGame);

		// JPanRight : Objets à terres et Actions générales
		gbcGame.gridx = 2;
		gbcGame.weightx = 0;
		gbcGame.weighty = 0;
		contentPane.add(new JPanRight(pj), gbcGame);
		pj.getGame().getRegion().newTurn();

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
			@Override
			public boolean dispatchKeyEvent(KeyEvent e) {
				if (mainPan.getSelectedIndex() == JPanMain.MAP_PANEL_INDEX && e.getID() == KeyEvent.KEY_PRESSED) {
					System.out.println("Touché!");
					Game game = pj.getGame();
					switch (e.getKeyCode()) {
					case KeyEvent.VK_LEFT:
						game.setPosition(new Position(game.getPosition().getX() - 1, game.getPosition().getY()));
						pj.getGame().getRegion().newTurn();
						return true;
					case KeyEvent.VK_RIGHT:
						game.setPosition(new Position(game.getPosition().getX() + 1, game.getPosition().getY()));
						pj.getGame().getRegion().newTurn();
						return true;
					case KeyEvent.VK_UP:
						game.setPosition(new Position(game.getPosition().getX(), game.getPosition().getY() + 1));
						pj.getGame().getRegion().newTurn();
						return true;
					case KeyEvent.VK_DOWN:
						game.setPosition(new Position(game.getPosition().getX(), game.getPosition().getY() - 1));
						pj.getGame().getRegion().newTurn();
						return true;
					}
				}
				return false;
			}

		});
		this.setFocusable(true);
	}
}
