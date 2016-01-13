package io.github.algorys.agshmne.game;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.movement.Position;
import io.github.algorys.agshmne.region.JRegion;
import io.github.algorys.agshmne.region.Region;

public class JGame extends JFrame {
	private Region region = new Region();
	private Character pj = new Character(region);
	private final JRegion jregion;
	
	public JGame(Character perso){
		pj = perso;
		jregion = new JRegion(this.pj);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JPanel jpSouth = new JPanel();
		JPanel jpWest = new JPanel();
		/*
		 * JPCenter :
		 * Permet d'accéder aux différentes interfaces du jeu.
		 */
		JCenterTabbed tabbedCenter = new JCenterTabbed(this.jregion);

		
		/*
		 * JPSouth
		 * Infos textuelles : descriptions des lieux, objets disponibles, position, etc...
		 */
		final JLabel jlRegion = new JLabel("Sur une case " + pj.getRegion().getTileFromPosition(pj.getPosition()));
		final JLabel jlPosition = new JLabel("Personnage en position " + pj.getPosition().getX() + " , " + pj.getPosition().getY());
		
		jpSouth.add(jlPosition);
		jpSouth.add(jlRegion);
		
		this.setFocusable(true);
		this.addKeyListener(new KeyAdapter() {
	
			@Override
			public void keyPressed(KeyEvent e) {
				//System.out.println("Touché!");
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					pj.setPosition(
							new Position(pj.getPosition().getX() - 1, pj.getPosition().getY()));
					jlPosition.setText("Personnage en position " + pj.getPosition().getX() + " , " + pj.getPosition().getY());
					jlRegion.setText("Sur une case " + pj.getRegion().getTileFromPosition(pj.getPosition()));
					break;
				case KeyEvent.VK_RIGHT:
					pj.setPosition(
							new Position(pj.getPosition().getX() + 1, pj.getPosition().getY()));
					jlPosition.setText("Personnage en position " + pj.getPosition().getX() + " , " + pj.getPosition().getY());
					jlRegion.setText("Sur une case " + pj.getRegion().getTileFromPosition(pj.getPosition()));
					break;
				case KeyEvent.VK_UP:
					pj.setPosition(
							new Position(pj.getPosition().getX(), pj.getPosition().getY() + 1));
					jlPosition.setText("Personnage en position " + pj.getPosition().getX() + " , " + pj.getPosition().getY());
					jlRegion.setText("Sur une case " + pj.getRegion().getTileFromPosition(pj.getPosition()));
					break;
				case KeyEvent.VK_DOWN:
					pj.setPosition(
							new Position(pj.getPosition().getX(), pj.getPosition().getY() - 1));
							jlPosition.setText("Personnage en position " + pj.getPosition().getX() + " , " + pj.getPosition().getY());
							jlRegion.setText("Sur une case " + pj.getRegion().getTileFromPosition(pj.getPosition()));
					break;
				}
	
			}
			
			
		});
		
		/*
		 * JPEast
		 * Objets à terres
		 * Actions pj et compétences
		 */
		JRightTabbed tabbedRight = new JRightTabbed();
		
		/*
		 * JPWest
		 * Personnage / Ville
		 */
		JLabel jlWest = new JLabel("Personnage / Ville");
		JLabel caracWest = new JLabel("CHA : " + pj.getAttributes().getCHA());
		jpWest.add(jlWest);	
		jpWest.add(caracWest);
		
		
		// Ajout Panneau Final
		JPanel contentPane = new JPanel(new BorderLayout());
		//contentPane.add(jpCenter, BorderLayout.CENTER);
		contentPane.add(tabbedCenter, BorderLayout.CENTER);
		contentPane.add(tabbedRight, BorderLayout.EAST);
		contentPane.add(jpSouth, BorderLayout.SOUTH);
		contentPane.add(jpWest, BorderLayout.WEST);
		
		this.setContentPane(contentPane);
		this.pack();
	}
}
