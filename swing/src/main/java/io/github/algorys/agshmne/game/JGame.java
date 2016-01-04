package io.github.algorys.agshmne.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import io.github.algorys.agshmne.deplacement.Position;
import io.github.algorys.agshmne.personnage.Personnage;
import io.github.algorys.agshmne.region.JRegion;
import io.github.algorys.agshmne.region.Region;

public class JGame extends JFrame {
	private Region region = new Region();
	private Personnage pj = new Personnage(region);
	private final JRegion jregion = new JRegion(this.pj);
	
	public JGame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JPanel jpEast = new JPanel();
		JPanel jpSouth = new JPanel();
		JPanel jpWest = new JPanel();

		/* JPCenter
		 * Barre racourcis
		 * Magie (Menu / Combat) : Liste les sorts du personnage. Possibilité pour le joueur de lancer certains sorts selon le contexte (En combat tous les sorts seront lançables / En Zone de jeu non !)
		 * Personnage (Menu): donnera un aperçu des caractéristiques du personnage. Cet onglet servira notamment aux passage de niveaux. (Bouton – et + pour les points)
		 * Inventaire (Menu): affichera la liste des objets que possède le personnage. Certains objets comme les potions offriront des actions supplémentaires (comme boire, manger, équiper, enchanter, etc.) via un bouton.
		 * Équipement (Menu): affichera une silhouette du personnage et de ce qu'il porte actuellement. Les équipements possibles seront : Tête, Bras, Torse, Jambes, 2 anneaux, 2 mains, Sac-à-dos (pour la capacité) et 1 Compagnon (Pet).
		  * Le Personnage pourra retirer des équipements via ce menu.
		  * Le personnage pourra renommer son Pet et l'enlever.
		 * Compétences (Menu): les compétences seront le plus possibles variés afin de fournir au joueur le plus de combinaisons possibles. Le joueur aura certaines compétences de bases et d'autres qu'il pourra apprendre. Certaines compétences pourront être utilisés ici, comme Atelier.
		 * Carte (Menu): affichera la carte en plus grand (toutes les cases idéalement) et au minimum les types de Cases. Le Joueur pourra ajouter des marqueurs avec texte.
		 * Quêtes (Menu): montrera les quêtes acceptées par le personnage.
		 * 
         * TODO AJOUTER Tabbed Panes !
		 */
		JPanel jpMap = new JPanel();
		JPanel jpPerso = new JPanel();
		JPanel jpComp = new JPanel();
		JPanel jpInv = new JPanel();
		JPanel jpEquip = new JPanel();
		JPanel jpMagie = new JPanel();
		JPanel jpQuest = new JPanel();
		
		JTabbedPane tabbedNorth = new JTabbedPane();
				
		jpMap.setBackground(Color.BLACK);
		jpMap.add(this.jregion);
		tabbedNorth.addTab("Map", jpMap);
		
		tabbedNorth.addTab("Personnage", jpPerso);
		
		tabbedNorth.addTab("Compétences", jpComp);
		
		tabbedNorth.addTab("Inventaire", jpInv);
		
		tabbedNorth.addTab("Equipement", jpEquip);
		
		tabbedNorth.addTab("Magie", jpMagie);
		
		tabbedNorth.addTab("Quêtes", jpQuest);
		
		/*
		 * JPEast
		 * Objets à terres
		 * Actions pj et compétences
		 */
		 
		//Objets
		JPanel jpObjets = new JPanel();
		JLabel jlObjets = new JLabel("Objets à terre");
		jpObjets.add(jlObjets);
		
		// Actions
		JPanel jpActions = new JPanel();
		JLabel jlActions = new JLabel("Creuser, Bûcher, ");
		jpActions.add(jlActions);
		
		jpEast.add(jpObjets);
		jpEast.add(jpActions);

		
		/*
		 * JPSouth
		 * Infos textuelles : descriptions des lieux, objets disponibles, position, etc...
		 */
		final JLabel jlRegion = new JLabel("Sur une case " + pj.getRegion().getTileFromPosition(pj.getPosition()));
		final JLabel jlPosition = new JLabel("Personnage en position " + pj.getPosition().getX() + " , " + pj.getPosition().getY());
		
		jpSouth.add(jlPosition);
		jpSouth.add(jlRegion);
		
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
		this.setFocusable(true);
		/*
		 * JPWest
		 * Personnage / Ville
		 */
		JLabel jlWest = new JLabel("Personnage / Ville");
		jpWest.add(jlWest);	
		
		
		// Ajout Panneau Final
		JPanel contentPane = new JPanel(new BorderLayout());
		//contentPane.add(jpCenter, BorderLayout.CENTER);
		contentPane.add(tabbedNorth, BorderLayout.CENTER);
		contentPane.add(jpEast, BorderLayout.EAST);
		contentPane.add(jpSouth, BorderLayout.SOUTH);
		contentPane.add(jpWest, BorderLayout.WEST);
		
		this.setContentPane(contentPane);
		this.pack();
	}
}
