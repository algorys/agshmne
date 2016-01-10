package io.github.algorys.agshmne.start;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import io.github.algorys.agshmne.caracteristic.JCaracteristic;

public class JCaracPanel extends JPanel {
	/*
	* Caractéristiques (Force, Dextérité, Constitution, Intelligence et
	* Charisme) 4 Vitales : 
	* Vie et Mana → dépensées par combat / compétences
	* Fatigue et Faim → incrémenté à chaque déplacement
	*/

	private JCaracteristic FOR;	
	private JCaracteristic DEX;
	private JCaracteristic CON;
	private JCaracteristic INT;
	private JCaracteristic CHA;
	
	public JCaracPanel() {
		super();
		final int MAX_FOR_ONE = 20;
		final int total = 60;
		final JCaracteristic FOR = new JCaracteristic(10, 1, MAX_FOR_ONE);	
		final JCaracteristic DEX = new JCaracteristic(10, 1, MAX_FOR_ONE);		
		final JCaracteristic CON = new JCaracteristic(10, 1, MAX_FOR_ONE);
		final JCaracteristic INT = new JCaracteristic(10, 1, MAX_FOR_ONE);
		final JCaracteristic CHA = new JCaracteristic(10, 1, MAX_FOR_ONE);

		// Property Change Listener
		PropertyChangeListener pcl = new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				int spentPoints = FOR.getValue() + DEX.getValue() + CON.getValue() + INT.getValue() + CHA.getValue();
				int remainingPoints = total - spentPoints;
				FOR.setMaxValue(Math.min(remainingPoints + FOR.getValue(), MAX_FOR_ONE));
				DEX.setMaxValue(Math.min(remainingPoints + DEX.getValue(), MAX_FOR_ONE));
				CON.setMaxValue(Math.min(remainingPoints + CON.getValue(), MAX_FOR_ONE));
				INT.setMaxValue(Math.min(remainingPoints + INT.getValue(), MAX_FOR_ONE));
				CHA.setMaxValue(Math.min(remainingPoints + CHA.getValue(), MAX_FOR_ONE));
			}
		};
		
		// Add listener for each
		FOR.addPropertyChangeListener(JCaracteristic.PROPERTY_VALUE, pcl);
		DEX.addPropertyChangeListener(JCaracteristic.PROPERTY_VALUE, pcl);
		CON.addPropertyChangeListener(JCaracteristic.PROPERTY_VALUE, pcl);
		INT.addPropertyChangeListener(JCaracteristic.PROPERTY_VALUE, pcl);
		CHA.addPropertyChangeListener(JCaracteristic.PROPERTY_VALUE, pcl);
		
		this.FOR = FOR;
		this.DEX = DEX;
		this.CON = CON;
		this.INT = INT;
		this.CHA = CHA;
		
		// GidBag Layout
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
		this.add(new JLabel(""), gbcCarac);
		
		// CARACTERISTIQUES
		// FOR
		gbcCarac.gridy = 3;
		gbcCarac.gridheight = 1;
		gbcCarac.gridx = 0;
		gbcCarac.gridwidth = 1;
		gbcCarac.anchor = GridBagConstraints.EAST;
		gbcCarac.fill = GridBagConstraints.NONE;
		this.add(new JLabel("FOR : l'attaque au corps à corps. Pousser, tirer, casser ! "), gbcCarac);
		
		gbcCarac.gridy = 3;
		gbcCarac.gridheight = 1;
		gbcCarac.gridx = 1;
		gbcCarac.gridwidth = 1;
		gbcCarac.anchor = GridBagConstraints.WEST;
		gbcCarac.fill = GridBagConstraints.HORIZONTAL;
		FOR.setOpaque(false);
		this.add(FOR, gbcCarac);

		
		// DEX
		gbcCarac.gridy = 4;
		gbcCarac.gridheight = 1;
		gbcCarac.gridx = 0;
		gbcCarac.gridwidth = 1;
		gbcCarac.anchor = GridBagConstraints.EAST;
		gbcCarac.fill = GridBagConstraints.NONE;
		this.add(new JLabel("DEX : attaque à distance et actions délicates"), gbcCarac);
		
		gbcCarac.gridy = 4;
		gbcCarac.gridheight = 1;
		gbcCarac.gridx = 1;
		gbcCarac.gridwidth = 1;
		gbcCarac.anchor = GridBagConstraints.WEST;
		gbcCarac.fill = GridBagConstraints.HORIZONTAL;		
		DEX.setOpaque(false);
		this.add(DEX, gbcCarac);
		
		// CON
		gbcCarac.gridy = 5;
		gbcCarac.gridheight = 1;
		gbcCarac.gridx = 0;
		gbcCarac.gridwidth = 1;
		gbcCarac.anchor = GridBagConstraints.EAST;
		gbcCarac.fill = GridBagConstraints.NONE;
		this.add(new JLabel("CON : la vie et les résitances aux poisons... "), gbcCarac);
		
		gbcCarac.gridy = 5;
		gbcCarac.gridheight = 1;
		gbcCarac.gridx = 1;
		gbcCarac.gridwidth = 1;
		gbcCarac.anchor = GridBagConstraints.WEST;
		gbcCarac.fill = GridBagConstraints.HORIZONTAL;		
		CON.setOpaque(false);
		this.add(CON, gbcCarac);

		// INT
		gbcCarac.gridy = 6;
		gbcCarac.gridheight = 1;
		gbcCarac.gridx = 0;
		gbcCarac.gridwidth = 1;
		gbcCarac.anchor = GridBagConstraints.EAST;
		gbcCarac.fill = GridBagConstraints.NONE;
		this.add(new JLabel("INT : magie et connaissances"), gbcCarac);
		
		gbcCarac.gridy = 6;
		gbcCarac.gridheight = 1;
		gbcCarac.gridx = 1;
		gbcCarac.gridwidth = 1;
		gbcCarac.anchor = GridBagConstraints.WEST;
		gbcCarac.fill = GridBagConstraints.HORIZONTAL;		
		INT.setOpaque(false);
		this.add(INT, gbcCarac);
		
		// CHA
		gbcCarac.gridy = 7;
		gbcCarac.gridheight = 1;
		gbcCarac.gridx = 0;
		gbcCarac.gridwidth = 1;
		gbcCarac.anchor = GridBagConstraints.EAST;
		gbcCarac.fill = GridBagConstraints.NONE;
		this.add(new JLabel("CHA : la manière dont vous influez le monde."), gbcCarac);
		
		gbcCarac.gridy = 7;
		gbcCarac.gridheight = 1;
		gbcCarac.gridx = 1;
		gbcCarac.gridwidth = 1;
		gbcCarac.anchor = GridBagConstraints.WEST;
		gbcCarac.fill = GridBagConstraints.HORIZONTAL;		
		CHA.setOpaque(false);
		this.add(CHA, gbcCarac);
		
		
	}

	public int getFOR() {
		return FOR.getValue();
	}

	public int getDEX() {
		return DEX.getValue();
	}

	public int getCON() {
		return CON.getValue();
	}

	public int getINT() {
		return INT.getValue();
	}

	public int getCHA() {
		return CHA.getValue();
	}

}
