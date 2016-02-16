package io.github.algorys.agshmne.maps;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import io.github.algorys.agshmne.Game;
import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.map.JMapRegion;
import io.github.algorys.agshmne.map.Position;
import io.github.algorys.agshmne.map.region.RandomRegionFactory;
import io.github.algorys.agshmne.map.region.Region;

public class JRegionTest {
	public static void main(String[] args) {
		JFrame jf = new JFrame("JRegion test");
		jf.setBackground(Color.BLACK);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Region region = new RandomRegionFactory().create();
		final Player personnage = new Player(region);
		jf.getContentPane().add(new JMapRegion(personnage));
		System.out.println("-------------------------------------");
		jf.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				//System.out.println("Touché!");
				Game game = personnage.getGame();
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					game.setPosition(
							new Position(game.getPosition().getX() - 1, game.getPosition().getY()));
					System.out.println("-------------------------------------");
					break;
				case KeyEvent.VK_RIGHT:
					game.setPosition(
							new Position(game.getPosition().getX() + 1, game.getPosition().getY()));
					System.out.println("-------------------------------------");
					break;
				case KeyEvent.VK_UP:
					game.setPosition(
							new Position(game.getPosition().getX(), game.getPosition().getY() + 1));
					System.out.println("-------------------------------------");
					break;
				case KeyEvent.VK_DOWN:
					game.setPosition(
							new Position(game.getPosition().getX(), game.getPosition().getY() - 1));
					System.out.println("-------------------------------------");
					break;
				}

			}
		});

		jf.setSize(jf.getPreferredSize());
		jf.setVisible(true);
	}
}
