package io.github.algorys.agshmne.game.mainpanel;

import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.game.character.JTabCharacter;
import io.github.algorys.agshmne.game.character.JTabComp;
import io.github.algorys.agshmne.game.character.equipment.JTabEquip;
import io.github.algorys.agshmne.game.character.inventory.JTabInv;
import io.github.algorys.agshmne.map.JMapRegion;

@SuppressWarnings("serial")
public class JPanMain extends JTabbedPane implements PropertyChangeListener {

	private JPanel jpMap = new JPanel();
	private JTabCharacter jpPerso;
	private JTabComp jpComp;
	private JTabInv jpInv;
	private JTabEquip jpEquip;
	private JPanel jpMagie = new JPanel();
	private JPanel jpQuest = new JPanel();
	private JPanel jpCity = new JPanel();
	private JMapRegion jregion;

	public JPanMain(final JMapRegion jregion) {
		this.jregion = jregion;
		this.setTabPlacement(JTabbedPane.TOP);
		jregion.getPersonnage().addPropertyChangeListener(Player.PROPERTY_POSITION, this);
		// Carte
		jpMap.setBackground(Color.BLACK);
		jpMap.add(jregion);
		Icon mapIcon = new ImageIcon(JPanMain.class.getClassLoader().getResource("map.png"));
		this.addTab("Carte", mapIcon, jpMap, "Carte");
		// Personnage
		Icon persoIcon = new ImageIcon(JPanMain.class.getClassLoader().getResource("perso.png"));
		jpPerso = new JTabCharacter(jregion.getPersonnage());
		this.addTab("Personnage", persoIcon, jpPerso, "Personnage");
		// Compétences
		Icon compIcon = new ImageIcon(JPanMain.class.getClassLoader().getResource("comp.png"));
		jpComp = new JTabComp(jregion.getPersonnage().getSkills());
		this.addTab("Compétences", compIcon, jpComp, "Compétences");
		// Inventaire
		Icon backpackIcon = new ImageIcon(JPanMain.class.getClassLoader().getResource("backpack.png"));
		jpInv = new JTabInv(jregion.getPersonnage());
		this.addTab("Inventaire", backpackIcon, jpInv, "Inventaire");
		// Equipement
		Icon equipIcon = new ImageIcon(JPanMain.class.getClassLoader().getResource("equip.png"));
		jpEquip = new JTabEquip(jregion.getPersonnage());
		this.addTab("Equipement", equipIcon, jpEquip, "Equipement");
		// Magie
		Icon magieIcon = new ImageIcon(JPanMain.class.getClassLoader().getResource("magie.png"));
		this.addTab("Magie", magieIcon, jpMagie, "Magie");
		// Quêtes
		Icon questIcon = new ImageIcon(JPanMain.class.getClassLoader().getResource("quest.png"));
		this.addTab("Quêtes", questIcon, jpQuest, "Quêtes");
		// Villes
		Icon cityIcon = new ImageIcon(JPanMain.class.getClassLoader().getResource("city.png"));
		this.addTab("Ville", cityIcon, jpCity, "Ville");
		this.addPropertyChangeListener(this);
		if (jregion.getPersonnage().getTile().isCivilized()) {
			this.setEnabledAt(7, true);
		} else {
			this.setEnabledAt(7, false);
		}

	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// System.out.println("On passe bien par ici");
		if (jregion.getPersonnage().getTile().isCivilized()) {
			this.setEnabledAt(7, true);
		} else {
			this.setEnabledAt(7, false);
		}

	}
}
