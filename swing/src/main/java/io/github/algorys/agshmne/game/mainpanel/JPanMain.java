package io.github.algorys.agshmne.game.mainpanel;

import java.awt.Color;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.game.character.JPanSkill;
import io.github.algorys.agshmne.game.character.equipment.JTabEquip;
import io.github.algorys.agshmne.game.character.inventory.JPanInventory;
import io.github.algorys.agshmne.game.quest.JPanQuest;
import io.github.algorys.agshmne.map.JMapRegion;
import io.github.algorys.agshmne.map.city.JPanCity;
import io.github.algorys.agshmne.map.desc.JMapDesc;
import io.github.algorys.agshmne.map.tile.Tile;

@SuppressWarnings("serial")
public class JPanMain extends JTabbedPane {
	public static final int MAP_PANEL_INDEX = 0;
	public static final int CITY_PANEL_INDEX = 6;
	private JPanel jpMap = new JPanel();
	private JPanSkill jpComp;
	private JPanInventory jpInv;
	private JTabEquip jpEquip;
	private JPanel jpMagie = new JPanel();
	private JPanQuest jpQuest;

	public JPanMain(final JMapRegion jregion) {
		this.setTabPlacement(JTabbedPane.TOP);
		this.setPreferredSize(new Dimension(1100, 1000));

		// Carte
		Player pj = jregion.getPersonnage();
		pj.addPropertyChangeListener(Player.PROPERTY_TILE, new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getNewValue() instanceof Tile) {
					updateCityPanel((Tile) evt.getNewValue());
				}
			}
		});
		jpMap.setBackground(Color.BLACK);
		JMapDesc descGame = new JMapDesc(pj);
		jpMap.add(descGame);
		jpMap.add(jregion);
		Icon mapIcon = new ImageIcon(JPanMain.class.getClassLoader().getResource("map.png"));
		this.addTab("Carte", mapIcon, jpMap, "Carte");
		// Compétences
		Icon compIcon = new ImageIcon(JPanMain.class.getClassLoader().getResource("comp.png"));
		jpComp = new JPanSkill(pj.getSkills());
		this.addTab("Compétences", compIcon, jpComp, "Compétences");
		// Inventaire
		Icon backpackIcon = new ImageIcon(JPanMain.class.getClassLoader().getResource("backpack.png"));
		jpInv = new JPanInventory(pj);
		this.addTab("Inventaire", backpackIcon, jpInv, "Inventaire");
		// Equipement
		Icon equipIcon = new ImageIcon(JPanMain.class.getClassLoader().getResource("equip.png"));
		jpEquip = new JTabEquip(pj);
		this.addTab("Equipement", equipIcon, jpEquip, "Equipement");
		// Magie
		Icon magieIcon = new ImageIcon(JPanMain.class.getClassLoader().getResource("magie.png"));
		this.addTab("Magie", magieIcon, jpMagie, "Magie");
		// Quêtes
		Icon questIcon = new ImageIcon(JPanMain.class.getClassLoader().getResource("quest.png"));
		jpQuest = new JPanQuest(pj);
		this.addTab("Quêtes", questIcon, jpQuest, "Quêtes");
		// Villes
		Icon cityIcon = new ImageIcon(JPanMain.class.getClassLoader().getResource("city.png"));
		JPanCity jpCity = new JPanCity(pj);
		this.addTab("Ville", cityIcon, jpCity, "Ville");
		updateCityPanel(pj.getTile());
	}

	private void updateCityPanel(Tile newTile) {
		this.setEnabledAt(CITY_PANEL_INDEX, newTile.isCivilized());
	}
}
