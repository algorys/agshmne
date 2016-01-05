package io.github.algorys.agshmne.game;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import io.github.algorys.agshmne.region.JRegion;

/* JPCenter
 * Barre racourcis
 */

public class JGameTabbed extends JTabbedPane {
	
	private JPanel jpMap = new JPanel();
	private JPanel jpPerso = new JPanel();
	private JPanel jpComp = new JPanel();
	private JPanel jpInv = new JPanel();
	private JPanel jpEquip = new JPanel();
	private JPanel jpMagie = new JPanel();
	private JPanel jpQuest = new JPanel();
	
	public JGameTabbed(JRegion jregion){
		this.setTabPlacement(JTabbedPane.TOP);
				
		jpMap.setBackground(Color.BLACK);
		jpMap.add(jregion);
		Icon mapIcon = new ImageIcon(JGameTabbed.class.getClassLoader().getResource("map.png"));
		this.addTab(null, mapIcon, jpMap, "Carte");
		
		Icon persoIcon = new ImageIcon(JGameTabbed.class.getClassLoader().getResource("perso.png"));
		this.addTab(null, persoIcon, jpPerso, "Personnage");
		
		Icon compIcon = new ImageIcon(JGameTabbed.class.getClassLoader().getResource("comp.png"));
		this.addTab(null, compIcon, jpComp, "Compétences");
		
		Icon backpackIcon = new ImageIcon(JGameTabbed.class.getClassLoader().getResource("backpack.png"));
		this.addTab(null, backpackIcon, jpInv, "Inventaire");		
		
		Icon equipIcon = new ImageIcon(JGameTabbed.class.getClassLoader().getResource("equip.png"));
		this.addTab(null, equipIcon, jpEquip, "Equipement");
		
		Icon magieIcon = new ImageIcon(JGameTabbed.class.getClassLoader().getResource("magie.png"));
		this.addTab(null, magieIcon, jpMagie, "Magie");
		
		Icon questIcon = new ImageIcon(JGameTabbed.class.getClassLoader().getResource("quest.png"));
		this.addTab(null, questIcon, jpQuest, "Quêtes");
	}
}
