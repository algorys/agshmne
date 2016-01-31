package io.github.algorys.agshmne.game.center;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import io.github.algorys.agshmne.region.JRegion;

/* JPCenter
 * Barre racourcis
 */

@SuppressWarnings("serial")
public class JCenterTabbed extends JTabbedPane {

	private JPanel jpMap = new JPanel();
	private JTabCharacter jpPerso;
	private JTabComp jpComp;
	private JTabInv jpInv;
	private JTabEquip jpEquip;
	private JPanel jpMagie = new JPanel();
	private JPanel jpQuest = new JPanel();

	public JCenterTabbed(JRegion jregion) {
		this.setTabPlacement(JTabbedPane.TOP);

		// Carte
		jpMap.setBackground(Color.BLACK);
		jpMap.add(jregion);
		Icon mapIcon = new ImageIcon(JCenterTabbed.class.getClassLoader().getResource("map.png"));
		this.addTab("Carte", mapIcon, jpMap, "Carte");
		// Personnage
		Icon persoIcon = new ImageIcon(JCenterTabbed.class.getClassLoader().getResource("perso.png"));
		jpPerso = new JTabCharacter(jregion.getPersonnage());
		this.addTab("Personnage", persoIcon, jpPerso, "Personnage");
		// Compétences
		Icon compIcon = new ImageIcon(JCenterTabbed.class.getClassLoader().getResource("comp.png"));
		jpComp = new JTabComp(jregion.getPersonnage().getSkills());
		this.addTab("Compétences", compIcon, jpComp, "Compétences");
		// Inventaire
		Icon backpackIcon = new ImageIcon(JCenterTabbed.class.getClassLoader().getResource("backpack.png"));
		jpInv = new JTabInv(jregion.getPersonnage());
		this.addTab("Inventaire", backpackIcon, jpInv, "Inventaire");
		// Equipement
		Icon equipIcon = new ImageIcon(JCenterTabbed.class.getClassLoader().getResource("equip.png"));
		jpEquip = new JTabEquip(jregion.getPersonnage());
		this.addTab("Equipement", equipIcon, jpEquip, "Equipement");
		// Magie
		Icon magieIcon = new ImageIcon(JCenterTabbed.class.getClassLoader().getResource("magie.png"));
		this.addTab("Magie", magieIcon, jpMagie, "Magie");
		// Quêtes
		Icon questIcon = new ImageIcon(JCenterTabbed.class.getClassLoader().getResource("quest.png"));
		this.addTab("Quêtes", questIcon, jpQuest, "Quêtes");
	}
}
