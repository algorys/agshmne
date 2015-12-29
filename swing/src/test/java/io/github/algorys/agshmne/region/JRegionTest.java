package io.github.algorys.agshmne.region;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import io.github.algorys.agshmne.deplacement.Position;
import io.github.algorys.agshmne.personnage.Personnage;

public class JRegionTest {
	public static void main(String[] args) {
		JFrame jf = new JFrame("JRegion test");
		jf.setBackground(Color.BLACK);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Region region = new Region();
		final Personnage personnage = new Personnage(region);
		jf.getContentPane().add(new JRegion(personnage));

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
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					personnage.setPosition(
							new Position(personnage.getPosition().getX() - 1, personnage.getPosition().getY()));
					break;
				case KeyEvent.VK_RIGHT:
					personnage.setPosition(
							new Position(personnage.getPosition().getX() + 1, personnage.getPosition().getY()));
					break;
				case KeyEvent.VK_UP:
					personnage.setPosition(
							new Position(personnage.getPosition().getX(), personnage.getPosition().getY() + 1));
					break;
				case KeyEvent.VK_DOWN:
					personnage.setPosition(
							new Position(personnage.getPosition().getX(), personnage.getPosition().getY() - 1));
					break;
				}

			}
		});

		jf.setSize(jf.getPreferredSize());
		jf.setVisible(true);
	}
}
