package io.github.algorys.agshmne.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import io.github.algorys.agshmne.deplacement.Position;
import io.github.algorys.agshmne.personnage.Personnage;
import io.github.algorys.agshmne.region.JRegion;
import io.github.algorys.agshmne.region.Region;

public class JGame extends JFrame {
	private Region region = new Region();
	private Personnage pj = new Personnage(region);
	
	
	public JGame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JPanel jp = new JPanel();
		final JRegion jregion = new JRegion(pj);
		jp.setBackground(Color.BLACK);
		jp.setSize(new Dimension(350,350));
		jp.add(jregion);
		this.add(jp);
		
		JPanel outputPane = new JPanel();
		Position position = pj.getPosition();
		final JLabel jlRegion = new JLabel("Sur une case " + jregion.getTileFromPerso(pj));
		final JLabel jlPosition = new JLabel("Personnage en position " + pj.getPosition().getX() + " , " + pj.getPosition().getY());
		
		outputPane.add(jlPosition);
		outputPane.add(jlRegion);
		
		JPanel contentPane = new JPanel(new BorderLayout());
		contentPane.add(jp, BorderLayout.NORTH);
		contentPane.add(outputPane, BorderLayout.SOUTH);
		this.setContentPane(contentPane);
		this.pack();
		
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
					jlPosition.setText("APRES Personnage en position " + pj.getPosition().getX() + " , " + pj.getPosition().getY());
					jlRegion.setText("Sur une case " + jregion.getTileFromPerso(pj));
					break;
				case KeyEvent.VK_RIGHT:
					pj.setPosition(
							new Position(pj.getPosition().getX() + 1, pj.getPosition().getY()));
					jlPosition.setText("Personnage en position " + pj.getPosition().getX() + " , " + pj.getPosition().getY());
					jlRegion.setText("Sur une case " + jregion.getTileFromPerso(pj));
					break;
				case KeyEvent.VK_UP:
					pj.setPosition(
							new Position(pj.getPosition().getX(), pj.getPosition().getY() + 1));
					jlPosition.setText("Personnage en position " + pj.getPosition().getX() + " , " + pj.getPosition().getY());
					jlRegion.setText("Sur une case " + jregion.getTileFromPerso(pj));
					break;
				case KeyEvent.VK_DOWN:
					pj.setPosition(
							new Position(pj.getPosition().getX(), pj.getPosition().getY() - 1));
							jlPosition.setText("Personnage en position " + pj.getPosition().getX() + " , " + pj.getPosition().getY());
							jlRegion.setText("Sur une case " + jregion.getTileFromPerso(pj));
					break;
				}
	
			}
		});
	}
}