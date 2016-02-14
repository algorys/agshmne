package io.github.algorys.agshmne.charactercreation;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import io.github.algorys.agshmne.character.player.PlayerBuilder;
import io.github.algorys.agshmne.items.Item;
import io.github.algorys.agshmne.items.ItemFactory;
import io.github.algorys.agshmne.items.equipable.EquipableItemFactory;

@SuppressWarnings("serial")
public class JInvPanel extends JLabel {
	private JComboBox<Item> firstObject;
	private JComboBox<Item> secondObject;
	
	public JInvPanel(final PlayerBuilder builder){
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbcInv = new GridBagConstraints();
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
		firstObject = new JComboBox<Item>();
		ItemFactory itemFact = new ItemFactory();
		firstObject.addItem(itemFact.createStackableItem());
		firstObject.addItem(itemFact.createStackableItem());
		firstObject.addItem(itemFact.createItem());
		firstObject.addItem(itemFact.createItem());
		firstObject.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					builder.setFirstItem((Item) e.getItem()); 
				}
				
			}
		});
		this.add(firstObject, gbcInv);
		
		// Objet 1
		gbcInv.gridy = 3;
		gbcInv.gridheight = 1;
		gbcInv.gridx = 0;
		gbcInv.gridwidth = 1;
		gbcInv.anchor = GridBagConstraints.EAST;
		gbcInv.fill = GridBagConstraints.NONE;
		secondObject = new JComboBox<Item>();
		EquipableItemFactory equipFact = new EquipableItemFactory();
		secondObject.addItem(equipFact.createRandom());
		secondObject.addItem(equipFact.createRandom());
		secondObject.addItem(equipFact.createRandom());
		secondObject.addItem(equipFact.createRandom());
		secondObject.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					builder.setSecondItem((Item)e.getItem());
				}
			}
		});
		this.add(secondObject, gbcInv);
	
	}
}
