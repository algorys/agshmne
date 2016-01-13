package io.github.algorys.agshmne.start;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import io.github.algorys.agshmne.caracteristic.JCaracteristic;

public class JCompPanel extends JPanel {
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
	private JLabel jlRemaining;
    
    public JCompPanel(){
    	super();
		final int MAX_FOR_ONE = 5;
		final int total = 10;

		final JCaracteristic cuisiner = new JCaracteristic(1, 1, MAX_FOR_ONE);	
		final JCaracteristic fouiller = new JCaracteristic(1, 1, MAX_FOR_ONE);
		final JCaracteristic boucherie = new JCaracteristic(1, 1, MAX_FOR_ONE);
		final JCaracteristic bucheron = new JCaracteristic(1, 1, MAX_FOR_ONE);
		final JCaracteristic miner = new JCaracteristic(1, 1, MAX_FOR_ONE);
		final JCaracteristic cultiver = new JCaracteristic(1, 1, MAX_FOR_ONE);
		final JCaracteristic pecher = new JCaracteristic(1, 1, MAX_FOR_ONE);
		final JCaracteristic magie = new JCaracteristic(1, 1, MAX_FOR_ONE);
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
		int remainingPoints = total - spentPoints;
		
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
				int remainingPoints = total - spentPoints;
				cuisiner.setMaxValue(Math.min(remainingPoints + cuisiner.getValue(), MAX_FOR_ONE));
				fouiller.setMaxValue(Math.min(remainingPoints + fouiller.getValue(), MAX_FOR_ONE));
				boucherie.setMaxValue(Math.min(remainingPoints + boucherie.getValue(), MAX_FOR_ONE));
				bucheron.setMaxValue(Math.min(remainingPoints + bucheron.getValue(), MAX_FOR_ONE));
				miner.setMaxValue(Math.min(remainingPoints + miner.getValue(), MAX_FOR_ONE));
				cultiver.setMaxValue(Math.min(remainingPoints + cultiver.getValue(), MAX_FOR_ONE));
				pecher.setMaxValue(Math.min(remainingPoints + pecher.getValue(), MAX_FOR_ONE));
				magie.setMaxValue(Math.min(remainingPoints + magie.getValue(), MAX_FOR_ONE));
				jlRemaining.setText(""+remainingPoints);
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

		this.cuisiner = cuisiner;
		this.fouiller = fouiller;
		this.boucherie = boucherie;
		this.bucheron = boucherie;
		this.miner = miner;
		this.cultiver = cultiver;
		this.pecher = pecher;
		this.magie = magie;
		
		// GidBag Layout
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbcComp = new GridBagConstraints();
		// Ajuste la taille du GridBag
		gbcComp.insets = new Insets(5, 5, 5, 5);

		// TITRE
		gbcComp.gridy = 0;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 0;
		gbcComp.gridwidth = 3;
		gbcComp.anchor = GridBagConstraints.CENTER;
		gbcComp.fill = GridBagConstraints.NONE;
		this.add(new JLabel("FICHE PERSONNAGE JOUEUR"), gbcComp);
		
		// Titre Panel
		gbcComp.gridy = 1;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 0;
		gbcComp.gridwidth = 3;
		gbcComp.anchor = GridBagConstraints.CENTER;
		gbcComp.fill = GridBagConstraints.NONE;
		this.add(new JLabel("- Compétences -"), gbcComp);

		// POINTS
		gbcComp.gridy = 2;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 1;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.EAST;
		gbcComp.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Points à dépenser : "), gbcComp);
		
		gbcComp.gridy = 2;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 2;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.WEST;
		gbcComp.fill = GridBagConstraints.HORIZONTAL;
		jlRemaining = new JLabel(""+remainingPoints);
		this.add(jlRemaining, gbcComp);
		
		// Compétences
		// Cuisiner
		gbcComp.gridy = 3;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 0;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.EAST;
		gbcComp.fill = GridBagConstraints.NONE;
		JLabel jlCuisiner = new JLabel("Cuisiner : ");
		jlCuisiner.setForeground(new Color(0x886A08));
		this.add(jlCuisiner, gbcComp);
		
		gbcComp.gridy = 3;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 1;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.CENTER;
		gbcComp.fill = GridBagConstraints.HORIZONTAL;
		cuisiner.setOpaque(false);
		this.add(cuisiner, gbcComp);
		gbcComp.gridy = 3;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 2;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.WEST;
		gbcComp.fill = GridBagConstraints.HORIZONTAL;
		this.add(new JLabel("Permet de cuisiner de la viandes, poissons..."), gbcComp);
		
		// Fouiller
		gbcComp.gridy = 4;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 0;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.EAST;
		gbcComp.fill = GridBagConstraints.NONE;
		JLabel jlFouiller = new JLabel("Fouiller : ");
		jlFouiller.setForeground(new Color(0x886A08));
		this.add(jlFouiller, gbcComp);
		
		gbcComp.gridy = 4;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 1;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.CENTER;
		gbcComp.fill = GridBagConstraints.HORIZONTAL;		
		fouiller.setOpaque(false);
		this.add(fouiller, gbcComp);		
		gbcComp.gridy = 4;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 2;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.WEST;
		gbcComp.fill = GridBagConstraints.HORIZONTAL;		
		this.add(new JLabel("Voir ce qui est secret, dissimulé, peu visible..."), gbcComp);
		
		// Boucherie
		gbcComp.gridy = 5;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 0;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.EAST;
		gbcComp.fill = GridBagConstraints.NONE;
		JLabel jlBoucher = new JLabel("Boucherie : ");
		jlBoucher.setForeground(new Color(0x886A08));
		this.add(jlBoucher, gbcComp);
		
		gbcComp.gridy = 5;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 1;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.CENTER;
		gbcComp.fill = GridBagConstraints.HORIZONTAL;		
		boucherie.setOpaque(false);
		this.add(boucherie, gbcComp);
		gbcComp.gridy = 5;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 2;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.WEST;
		gbcComp.fill = GridBagConstraints.HORIZONTAL;
		this.add(new JLabel("Découper de la viande. Tenir une boucherie ?"), gbcComp);

		// Bucheron
		gbcComp.gridy = 6;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 0;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.EAST;
		gbcComp.fill = GridBagConstraints.NONE;
		JLabel jlBucher = new JLabel("Bûcheron : ");
		jlBucher.setForeground(new Color(0x886A08));
		this.add(jlBucher, gbcComp);
		
		gbcComp.gridy = 6;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 1;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.CENTER;
		gbcComp.fill = GridBagConstraints.HORIZONTAL;		
		bucheron.setOpaque(false);
		this.add(bucheron, gbcComp);
		gbcComp.gridy = 6;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 2;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.WEST;
		gbcComp.fill = GridBagConstraints.HORIZONTAL;
		this.add(new JLabel("Couper du bois avec une <hache>, ouvrir une scierie ?"), gbcComp);
		
		// Miner
		gbcComp.gridy = 7;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 0;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.EAST;
		gbcComp.fill = GridBagConstraints.NONE;
		JLabel jlMiner = new JLabel("Miner : ");
		jlMiner.setForeground(new Color(0x886A08));
		this.add(jlMiner, gbcComp);
		
		gbcComp.gridy = 7;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 1;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.CENTER;
		gbcComp.fill = GridBagConstraints.HORIZONTAL;		
		miner.setOpaque(false);
		this.add(miner, gbcComp);
		gbcComp.gridy = 7;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 2;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.WEST;
		gbcComp.fill = GridBagConstraints.HORIZONTAL;
		this.add(new JLabel("Extraire de la roche avec une <pioche>."), gbcComp);
		
		// Cultiver
		gbcComp.gridy = 8;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 0;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.EAST;
		gbcComp.fill = GridBagConstraints.NONE;
		JLabel jlCultiver = new JLabel("Cultiver : ");
		jlCultiver.setForeground(new Color(0x886A08));
		this.add(jlCultiver, gbcComp);
		
		gbcComp.gridy = 8;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 1;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.CENTER;
		gbcComp.fill = GridBagConstraints.HORIZONTAL;		
		cultiver.setOpaque(false);
		this.add(cultiver, gbcComp);
		gbcComp.gridy = 8;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 2;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.WEST;
		gbcComp.fill = GridBagConstraints.HORIZONTAL;
		this.add(new JLabel("Faire pousser tout et n'importe quoi."), gbcComp);
		
		// Pecher
		gbcComp.gridy = 9;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 0;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.EAST;
		gbcComp.fill = GridBagConstraints.NONE;
		JLabel jlPecher = new JLabel("Pêcher : ");
		jlPecher.setForeground(new Color(0x886A08));
		this.add(jlPecher, gbcComp);
		
		gbcComp.gridy = 9;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 1;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.CENTER;
		gbcComp.fill = GridBagConstraints.HORIZONTAL;		
		pecher.setOpaque(false);
		this.add(pecher, gbcComp);
		gbcComp.gridy = 9;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 2;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.WEST;
		gbcComp.fill = GridBagConstraints.HORIZONTAL;		
		this.add(new JLabel("En bateau ou au bord de la mer."), gbcComp);
		
		// Magie
		gbcComp.gridy = 10;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 0;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.EAST;
		gbcComp.fill = GridBagConstraints.NONE;
		JLabel jlMagie = new JLabel("Magie : ");
		jlMagie.setForeground(new Color(0x886A08));
		this.add(jlMagie, gbcComp);
		
		gbcComp.gridy = 10;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 1;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.CENTER;
		gbcComp.fill = GridBagConstraints.HORIZONTAL;		
		magie.setOpaque(false);
		this.add(magie, gbcComp);
		gbcComp.gridy = 10;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 2;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.WEST;
		gbcComp.fill = GridBagConstraints.HORIZONTAL;
		this.add(new JLabel("Apprendre durement les arcanes..."), gbcComp);
	}

	public int getCuisiner() {
		return cuisiner.getValue();
	}

	public int getFouiller() {
		return fouiller.getValue();
	}

	public int getBoucherie() {
		return boucherie.getValue();
	}

	public int getBucheron() {
		return bucheron.getValue();
	}

	public int getMiner() {
		return miner.getValue();
	}

	public int getCultiver() {
		return cultiver.getValue();
	}

	public int getPecher() {
		return pecher.getValue();
	}

	public int getMagie() {
		return magie.getValue();
	}    
    
}
