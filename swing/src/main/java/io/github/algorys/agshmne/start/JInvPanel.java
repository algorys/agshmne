package io.github.algorys.agshmne.start;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import io.github.algorys.agshmne.inventory.InventoryFactory;
import io.github.algorys.agshmne.inventory.InventoryItem;
import io.github.algorys.agshmne.items.factory.AppleFactory;
import io.github.algorys.agshmne.items.factory.CloakFactory;
import io.github.algorys.agshmne.items.factory.NailFactory;
import io.github.algorys.agshmne.items.factory.OrangeFactory;
import io.github.algorys.agshmne.items.factory.PotionManaFactory;
import io.github.algorys.agshmne.items.factory.RandomFactory;
import io.github.algorys.agshmne.items.factory.StrongAxeFactory;

public class JInvPanel extends JLabel {
	
	public JInvPanel(){
		// GidBag Layout
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbcInv = new GridBagConstraints();
		// Ajuste la taille du GridBag
		gbcInv.insets = new Insets(5, 5, 5, 5);
	
		// TITRE
		gbcInv.gridy = 0;
		gbcInv.gridheight = 1;
		gbcInv.gridx = 0;
		gbcInv.gridwidth = 2;
		gbcInv.anchor = GridBagConstraints.CENTER;
		gbcInv.fill = GridBagConstraints.NONE;
		this.add(new JLabel("FICHE PERSONNAGE JOUEUR"), gbcInv);
		
		// Titre Panel
		gbcInv.gridy = 1;
		gbcInv.gridheight = 1;
		gbcInv.gridx = 0;
		gbcInv.gridwidth = 2;
		gbcInv.anchor = GridBagConstraints.CENTER;
		gbcInv.fill = GridBagConstraints.NONE;
		this.add(new JLabel("- Inventaire -"), gbcInv);
	
		// POINTS
		gbcInv.gridy = 2;
		gbcInv.gridheight = 1;
		gbcInv.gridx = 0;
		gbcInv.gridwidth = 1;
		gbcInv.anchor = GridBagConstraints.EAST;
		gbcInv.fill = GridBagConstraints.NONE;
		JComboBox<InventoryFactory> objectList = new JComboBox<InventoryFactory>();
		objectList.addItem(new InventoryFactory());
		objectList.addItem(new InventoryFactory());
		objectList.addItem(new InventoryFactory());
		objectList.addItem(new InventoryFactory());
		
		this.add(objectList, gbcInv);
	
	}
	
}
