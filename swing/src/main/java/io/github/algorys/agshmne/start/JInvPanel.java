package io.github.algorys.agshmne.start;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import io.github.algorys.agshmne.items.ItemFactory;

public class JInvPanel extends JLabel {
	private JComboBox<ItemFactory> firstObject;
	private JComboBox<ItemFactory> secondObject;
	
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
	
		// Objet 1
		gbcInv.gridy = 2;
		gbcInv.gridheight = 1;
		gbcInv.gridx = 0;
		gbcInv.gridwidth = 1;
		gbcInv.anchor = GridBagConstraints.EAST;
		gbcInv.fill = GridBagConstraints.NONE;
		firstObject = new JComboBox<ItemFactory>();
		firstObject.addItem(new ItemFactory());
		firstObject.addItem(new ItemFactory());
		firstObject.addItem(new ItemFactory());
		firstObject.addItem(new ItemFactory());		
		this.add(firstObject, gbcInv);
		
		// Objet 1
		gbcInv.gridy = 3;
		gbcInv.gridheight = 1;
		gbcInv.gridx = 0;
		gbcInv.gridwidth = 1;
		gbcInv.anchor = GridBagConstraints.EAST;
		gbcInv.fill = GridBagConstraints.NONE;
		secondObject = new JComboBox<ItemFactory>();
		secondObject.addItem(new ItemFactory());
		secondObject.addItem(new ItemFactory());
		secondObject.addItem(new ItemFactory());
		secondObject.addItem(new ItemFactory());		
		this.add(secondObject, gbcInv);
	
	}

	public String getFirstObject() {
		return (String) firstObject.getSelectedItem().toString();
	}

	public String getSecondObject() {
		return (String) secondObject.getSelectedItem().toString();
	}
	
}
