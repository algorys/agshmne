package io.github.algorys.agshmne.game.mainpanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import io.github.algorys.agshmne.Game;
import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.game.character.JPanSkill;
import io.github.algorys.agshmne.game.character.equipment.JTabEquip;
import io.github.algorys.agshmne.game.character.inventory.JPanInventory;
import io.github.algorys.agshmne.game.quest.JPanQuest;
import io.github.algorys.agshmne.map.JMapRegion;
import io.github.algorys.agshmne.map.JPanMap;
import io.github.algorys.agshmne.map.city.JPanCity;
import io.github.algorys.agshmne.map.desc.JMapDesc;
import io.github.algorys.agshmne.map.tile.Tile;

@SuppressWarnings("serial")
public class JPanTabbed extends JTabbedPane {
	public static final int MAP_PANEL_INDEX = 0;
	public static final int CITY_PANEL_INDEX = 6;

	public JPanTabbed(Game game, final JMapRegion jregion) {
		this.setTabPlacement(JTabbedPane.TOP);
		this.setPreferredSize(new Dimension(1100, 935));

		// Active / Désactive JPanel City
		Player pj = game.getPlayer();
		pj.addPropertyChangeListener(Player.PROPERTY_TILE, new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getNewValue() instanceof Tile) {
					updateCityPanel((Tile) evt.getNewValue());
				}
			}
		});
		// Carte
		JPanel jpMap = new JPanel(new BorderLayout());
		jpMap.setBackground(Color.BLACK);
		jpMap.add(new JMapDesc(game), BorderLayout.NORTH);
		jpMap.add(new JPanMap(jregion), BorderLayout.CENTER);
		Icon mapIcon = new ImageIcon(JPanTabbed.class.getClassLoader().getResource("map.png"));
		this.addTab("Carte", mapIcon, jpMap, "Carte");
		// Compétences
		JPanSkill jpSkill = new JPanSkill(pj.getSkills());
		Icon compIcon = new ImageIcon(JPanTabbed.class.getClassLoader().getResource("comp.png"));
		this.addTab("Compétences", compIcon, jpSkill, "Compétences");
		// Inventaire
		JPanInventory jpInv = new JPanInventory(pj);
		Icon backpackIcon = new ImageIcon(JPanTabbed.class.getClassLoader().getResource("backpack.png"));
		this.addTab("Inventaire", backpackIcon, jpInv, "Inventaire");
		// Equipement
		JTabEquip jpEquip = new JTabEquip(pj);
		Icon equipIcon = new ImageIcon(JPanTabbed.class.getClassLoader().getResource("equip.png"));
		this.addTab("Equipement", equipIcon, jpEquip, "Equipement");
		// Magie
		JPanel jpMagie = new JPanel();
		Icon magieIcon = new ImageIcon(JPanTabbed.class.getClassLoader().getResource("magie.png"));
		this.addTab("Magie", magieIcon, jpMagie, "Magie");
		// Quêtes
		JPanQuest jpQuest = new JPanQuest(pj);
		Icon questIcon = new ImageIcon(JPanTabbed.class.getClassLoader().getResource("quest.png"));
		this.addTab("Quêtes", questIcon, jpQuest, "Quêtes");
		// Villes
		JPanCity jpCity = new JPanCity(pj);
		Icon cityIcon = new ImageIcon(JPanTabbed.class.getClassLoader().getResource("city.png"));
		this.addTab("Ville", cityIcon, jpCity, "Ville");
		updateCityPanel(pj.getTile());
	}

	private void updateCityPanel(Tile newTile) {
		this.setEnabledAt(CITY_PANEL_INDEX, newTile.isCivilized());
	}
}
