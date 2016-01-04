package io.github.algorys.agshmne.window;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;

public class JCompPanel extends JLabel {
	/*
	* Cuisiner (Unités : repas))
    * Fouiller (DEX : Objet Trouvé)
    * Boucherie (Unités : Viandes)
    * Bûcheron (Unités : bois)
    * Miner (Unités : métaux différents)
    * Cultiver (Unités : Herbes)
    * Pêcher (Unités : Poissons)
    * Magie (INT : Voir Personnage)
	 */
	private JCaracteristic cuisiner;
	private JCaracteristic fouiller;
	private JCaracteristic boucherie;
	private JCaracteristic bucheron;
	private JCaracteristic miner;
    private JCaracteristic cultiver;
    private JCaracteristic pecher;
    private JCaracteristic magie;
    
    public JCompPanel(){
    	super();
		final int MAX_FOR_ONE = 20;
		final int total = 60;
		final int remainingPoints = 0;

		final JCaracteristic cuisiner = new JCaracteristic(10, 1, MAX_FOR_ONE);	
		final JCaracteristic fouiller = new JCaracteristic(10, 1, MAX_FOR_ONE);
		final JCaracteristic boucherie = new JCaracteristic(10, 1, MAX_FOR_ONE);
		final JCaracteristic bucheron = new JCaracteristic(10, 1, MAX_FOR_ONE);
		final JCaracteristic miner = new JCaracteristic(10, 1, MAX_FOR_ONE);
		final JCaracteristic cultiver = new JCaracteristic(10, 1, MAX_FOR_ONE);
		final JCaracteristic pecher = new JCaracteristic(10, 1, MAX_FOR_ONE);
		final JCaracteristic magie = new JCaracteristic(10, 1, MAX_FOR_ONE);
		
		// Property Change Listener
		PropertyChangeListener pcl = new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				int spentPoints = 
						cuisiner.getValue() 
						+ fouiller.getValue() 
						+ boucherie.getValue() 
						+ bucheron.getValue() 
						+ miner.getValue()
						+ cultiver.getValue()
						+ pecher.getValue()
						+ magie.getValue()
						;
				final int remainingPoints = total - spentPoints;
				cuisiner.setMaxValue(Math.min(remainingPoints + cuisiner.getValue(), MAX_FOR_ONE));
				fouiller.setMaxValue(Math.min(remainingPoints + fouiller.getValue(), MAX_FOR_ONE));
				boucherie.setMaxValue(Math.min(remainingPoints + boucherie.getValue(), MAX_FOR_ONE));
				bucheron.setMaxValue(Math.min(remainingPoints + bucheron.getValue(), MAX_FOR_ONE));
				miner.setMaxValue(Math.min(remainingPoints + miner.getValue(), MAX_FOR_ONE));
				cultiver.setMaxValue(Math.min(remainingPoints + miner.getValue(), MAX_FOR_ONE));
				pecher.setMaxValue(Math.min(remainingPoints + miner.getValue(), MAX_FOR_ONE));
				magie.setMaxValue(Math.min(remainingPoints + miner.getValue(), MAX_FOR_ONE));
			}
		};

		// Add listener for each
		cuisiner.addPropertyChangeListener(JCaracteristic.PROPERTY_VALUE, pcl);
		fouiller.addPropertyChangeListener(JCaracteristic.PROPERTY_VALUE, pcl);
		boucherie.addPropertyChangeListener(JCaracteristic.PROPERTY_VALUE, pcl);
		bucheron.addPropertyChangeListener(JCaracteristic.PROPERTY_VALUE, pcl);
		miner.addPropertyChangeListener(JCaracteristic.PROPERTY_VALUE, pcl);
		cultiver.addPropertyChangeListener(JCaracteristic.PROPERTY_VALUE, pcl);
		pecher.addPropertyChangeListener(JCaracteristic.PROPERTY_VALUE, pcl);
		magie.addPropertyChangeListener(JCaracteristic.PROPERTY_VALUE, pcl);

		
		// GidBag Layout
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbcComp = new GridBagConstraints();
		// Ajuste la taille du GridBag
		gbcComp.insets = new Insets(5, 5, 5, 5);

		// TITRE
		gbcComp.gridy = 0;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 0;
		gbcComp.gridwidth = 2;
		gbcComp.anchor = GridBagConstraints.CENTER;
		gbcComp.fill = GridBagConstraints.NONE;
		this.add(new JLabel("FICHE PERSONNAGE JOUEUR"), gbcComp);
		
		// Titre Panel
		gbcComp.gridy = 1;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 0;
		gbcComp.gridwidth = 2;
		gbcComp.anchor = GridBagConstraints.CENTER;
		gbcComp.fill = GridBagConstraints.NONE;
		this.add(new JLabel("- Compétences -"), gbcComp);

		// POINTS
		gbcComp.gridy = 2;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 0;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.EAST;
		gbcComp.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Points à dépenser : "), gbcComp);
		
		gbcComp.gridy = 2;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 1;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.WEST;
		gbcComp.fill = GridBagConstraints.HORIZONTAL;
		this.add(new JLabel("" + remainingPoints), gbcComp);
		
		// Compétences
		// Cuisiner
		gbcComp.gridy = 3;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 0;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.EAST;
		gbcComp.fill = GridBagConstraints.NONE;
		JLabel label = new JLabel("Cuisiner : ");
		label.setToolTipText("Permet de cuisiner de la viandes, poissons...");
		//label.setForeground(new Color(0xffffdd));
		this.add(label, gbcComp);
		
		gbcComp.gridy = 3;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 1;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.WEST;
		gbcComp.fill = GridBagConstraints.HORIZONTAL;
		cuisiner.setOpaque(false);
		this.add(cuisiner, gbcComp);

		
		// Fouiller
		gbcComp.gridy = 4;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 0;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.EAST;
		gbcComp.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Fouiller : voir ce qui est secret, dissimulé, peu visible..."), gbcComp);
		
		gbcComp.gridy = 4;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 1;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.WEST;
		gbcComp.fill = GridBagConstraints.HORIZONTAL;		
		fouiller.setOpaque(false);
		this.add(fouiller, gbcComp);
		
		// Boucherie
		gbcComp.gridy = 5;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 0;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.EAST;
		gbcComp.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Boucherie : découper de la viande. Tenir une boucherie ?"), gbcComp);
		
		gbcComp.gridy = 5;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 1;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.WEST;
		gbcComp.fill = GridBagConstraints.HORIZONTAL;		
		boucherie.setOpaque(false);
		this.add(boucherie, gbcComp);

		// Bucheron
		gbcComp.gridy = 6;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 0;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.EAST;
		gbcComp.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Bûcheron : couper du bois avec une <hache>, ouvrir une scierie ?"), gbcComp);
		
		gbcComp.gridy = 6;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 1;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.WEST;
		gbcComp.fill = GridBagConstraints.HORIZONTAL;		
		bucheron.setOpaque(false);
		this.add(bucheron, gbcComp);
		
		// Miner
		gbcComp.gridy = 7;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 0;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.EAST;
		gbcComp.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Miner : extraire de la roche avec une <pioche>."), gbcComp);
		
		gbcComp.gridy = 7;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 1;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.WEST;
		gbcComp.fill = GridBagConstraints.HORIZONTAL;		
		miner.setOpaque(false);
		this.add(miner, gbcComp);
		
		// Cultiver
		gbcComp.gridy = 8;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 0;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.EAST;
		gbcComp.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Cultiver : faire pousser tout et n'importe quoi."), gbcComp);
		
		gbcComp.gridy = 8;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 1;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.WEST;
		gbcComp.fill = GridBagConstraints.HORIZONTAL;		
		cultiver.setOpaque(false);
		this.add(cultiver, gbcComp);
		
		// Pecher
		gbcComp.gridy = 9;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 0;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.EAST;
		gbcComp.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Pêcher : en bateau ou au bord de la mer."), gbcComp);
		
		gbcComp.gridy = 9;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 1;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.WEST;
		gbcComp.fill = GridBagConstraints.HORIZONTAL;		
		pecher.setOpaque(false);
		this.add(pecher, gbcComp);
		
		// Magie
		gbcComp.gridy = 10;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 0;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.EAST;
		gbcComp.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Magie : apprendre durement les arcanes..."), gbcComp);
		
		gbcComp.gridy = 10;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 1;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.WEST;
		gbcComp.fill = GridBagConstraints.HORIZONTAL;		
		magie.setOpaque(false);
		this.add(magie, gbcComp);
		
		
	}    
    
}
