package io.github.algorys.agshmne.window;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JCaracPanel extends JPanel {
	/*
	* Caractéristiques (Force, Dextérité, Constitution, Intelligence et
	* Charisme) 4 Vitales : 
	* Vie et Mana → dépensées par combat / compétences
	* Fatigue et Faim → incrémenté à chaque déplacement
	*/
	private int FOR, DEX, CON, INT, CHA = 10;
	
	final int MAX_FOR_ONE = 20;
	final JCaracteristic jcTotal = new JCaracteristic(MAX_FOR_ONE + 2, 2, 40);
	final int total = 10;

	public JCaracPanel() {
		super();
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbcCarac = new GridBagConstraints();
		// Ajuste la taille du GridBag
		gbcCarac.insets = new Insets(5, 5, 5, 5);

		// TITRE
		gbcCarac.gridy = 0;
		gbcCarac.gridheight = 1;
		gbcCarac.gridx = 0;
		gbcCarac.gridwidth = 2;
		gbcCarac.anchor = GridBagConstraints.CENTER;
		gbcCarac.fill = GridBagConstraints.NONE;
		this.add(new JLabel("FICHE PERSONNAGE JOUEUR"), gbcCarac);
		
		// Titre Panel
		gbcCarac.gridy = 1;
		gbcCarac.gridheight = 1;
		gbcCarac.gridx = 0;
		gbcCarac.gridwidth = 2;
		gbcCarac.anchor = GridBagConstraints.CENTER;
		gbcCarac.fill = GridBagConstraints.NONE;
		this.add(new JLabel("- Caractéristiques -"), gbcCarac);

		// POINTS
		gbcCarac.gridy = 2;
		gbcCarac.gridheight = 1;
		gbcCarac.gridx = 0;
		gbcCarac.gridwidth = 1;
		gbcCarac.anchor = GridBagConstraints.EAST;
		gbcCarac.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Points à dépenser : "), gbcCarac);
		
		gbcCarac.gridy = 2;
		gbcCarac.gridheight = 1;
		gbcCarac.gridx = 1;
		gbcCarac.gridwidth = 1;
		gbcCarac.anchor = GridBagConstraints.WEST;
		gbcCarac.fill = GridBagConstraints.HORIZONTAL;
		this.add(jcTotal, gbcCarac);
		
		// CARACTERISTIQUES
		// FOR
		gbcCarac.gridy = 3;
		gbcCarac.gridheight = 1;
		gbcCarac.gridx = 0;
		gbcCarac.gridwidth = 1;
		gbcCarac.anchor = GridBagConstraints.EAST;
		gbcCarac.fill = GridBagConstraints.NONE;
		this.add(new JLabel("FOR"), gbcCarac);
		
		gbcCarac.gridy = 3;
		gbcCarac.gridheight = 1;
		gbcCarac.gridx = 1;
		gbcCarac.gridwidth = 1;
		gbcCarac.anchor = GridBagConstraints.WEST;
		gbcCarac.fill = GridBagConstraints.HORIZONTAL;
		final JCaracteristic FOR = new JCaracteristic(10, 1, MAX_FOR_ONE);	
		FOR.setOpaque(false);
		this.add(FOR, gbcCarac);

		
		// DEX
		gbcCarac.gridy = 4;
		gbcCarac.gridheight = 1;
		gbcCarac.gridx = 0;
		gbcCarac.gridwidth = 1;
		gbcCarac.anchor = GridBagConstraints.EAST;
		gbcCarac.fill = GridBagConstraints.NONE;
		this.add(new JLabel("DEX"), gbcCarac);
		
		gbcCarac.gridy = 4;
		gbcCarac.gridheight = 1;
		gbcCarac.gridx = 1;
		gbcCarac.gridwidth = 1;
		gbcCarac.anchor = GridBagConstraints.WEST;
		gbcCarac.fill = GridBagConstraints.HORIZONTAL;
		final JCaracteristic DEX = new JCaracteristic(10, 1, MAX_FOR_ONE);
		DEX.setOpaque(false);
		this.add(DEX, gbcCarac);
		
		// CON
		gbcCarac.gridy = 5;
		gbcCarac.gridheight = 1;
		gbcCarac.gridx = 0;
		gbcCarac.gridwidth = 1;
		gbcCarac.anchor = GridBagConstraints.EAST;
		gbcCarac.fill = GridBagConstraints.NONE;
		this.add(new JLabel("CON"), gbcCarac);

		// INT
		gbcCarac.gridy = 6;
		gbcCarac.gridheight = 1;
		gbcCarac.gridx = 0;
		gbcCarac.gridwidth = 1;
		gbcCarac.anchor = GridBagConstraints.EAST;
		gbcCarac.fill = GridBagConstraints.NONE;
		this.add(new JLabel("INT"), gbcCarac);
		
		// CHA
		gbcCarac.gridy = 7;
		gbcCarac.gridheight = 1;
		gbcCarac.gridx = 0;
		gbcCarac.gridwidth = 1;
		gbcCarac.anchor = GridBagConstraints.EAST;
		gbcCarac.fill = GridBagConstraints.NONE;
		this.add(new JLabel("CHA"), gbcCarac);

		PropertyChangeListener pcl = new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				int spentPoints = FOR.getValue() + DEX.getValue();
				int remainingPoints = total - spentPoints;
				FOR.setMaxValue(Math.min(remainingPoints + FOR.getValue(), MAX_FOR_ONE));
				DEX.setMaxValue(Math.min(remainingPoints + DEX.getValue(), MAX_FOR_ONE));
			}
		};
		
		jcTotal.addPropertyChangeListener(JCaracteristic.PROPERTY_VALUE, pcl);
		FOR.addPropertyChangeListener(JCaracteristic.PROPERTY_VALUE, pcl);
		DEX.addPropertyChangeListener(JCaracteristic.PROPERTY_VALUE, pcl);
		
		
		
	}
	
	

	public int getFOR() {
		return FOR;
	}

	public int getDEX() {
		return DEX;
	}

	public int getCON() {
		return CON;
	}

	public int getINT() {
		return INT;
	}

	public int getCHA() {
		return CHA;
	}
}
