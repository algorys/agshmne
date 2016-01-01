package io.github.algorys.agshmne.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import io.github.algorys.agshmne.deplacement.Position;
import io.github.algorys.agshmne.personnage.Personnage;
import io.github.algorys.agshmne.region.Region;

public class JGame extends JFrame {
	private Region region = new Region();
	private Personnage pj = new Personnage(region);
	
	
	public JGame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.add(new JGameWorld(region, pj));
		
		this.addKeyListener(new KeyListener() {
			
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
					pj.setPosition(
							new Position(pj.getPosition().getX() - 1, pj.getPosition().getY()));
					break;
				case KeyEvent.VK_RIGHT:
					pj.setPosition(
							new Position(pj.getPosition().getX() + 1, pj.getPosition().getY()));
					break;
				case KeyEvent.VK_UP:
					pj.setPosition(
							new Position(pj.getPosition().getX(), pj.getPosition().getY() + 1));
					break;
				case KeyEvent.VK_DOWN:
					pj.setPosition(
							new Position(pj.getPosition().getX(), pj.getPosition().getY() - 1));
					break;
				}
	
			}
		});
	}
}