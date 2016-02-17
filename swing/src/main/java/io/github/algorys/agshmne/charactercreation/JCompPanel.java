package io.github.algorys.agshmne.charactercreation;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import io.github.algorys.agshmne.caracteristic.JCaracteristic;
import io.github.algorys.agshmne.character.player.PlayerBuilder;
import io.github.algorys.agshmne.character.player.skills.SkillType;

@SuppressWarnings("serial")
public class JCompPanel extends JPanel {
	private JLabel jlRemaining;
    
    public JCompPanel(final PlayerBuilder builder){
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
				builder.setSkill(SkillType.cuisine, cuisiner.getValue());
				builder.setSkill(SkillType.fouiller, fouiller.getValue());
				builder.setSkill(SkillType.boucherie, boucherie.getValue());
				builder.setSkill(SkillType.bucheron, bucheron.getValue());
				builder.setSkill(SkillType.miner, miner.getValue());
				builder.setSkill(SkillType.cultiver, cultiver.getValue());
				builder.setSkill(SkillType.pecher, pecher.getValue());
				builder.setSkill(SkillType.magie, magie.getValue());
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

		// GridBag Layout
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
		initSkill(gbcComp, 3, "Cuisiner : ", "Permet de cuisiner de la viandes, poissons...", cuisiner);
		initSkill(gbcComp, 4, "Fouiller : ", "Voir ce qui est secret, dissimulé, peu visible...", fouiller);
		initSkill(gbcComp, 5, "Boucherie : ", "Découper de la viande. Tenir une boucherie ?", boucherie);
		initSkill(gbcComp, 6, "Bûcheron : ", "Couper du bois avec une <hache>, ouvrir une scierie ?", bucheron);
		initSkill(gbcComp, 7, "Miner : ", "Extraire de la roche avec une <pioche>.", miner);
		initSkill(gbcComp, 8, "Cultiver : ", "Faire pousser tout et n'importe quoi.", cultiver);
		initSkill(gbcComp, 9, "Pêcher : ", "En bateau ou au bord de la mer.", pecher);
		initSkill(gbcComp, 10, "Magie : ", "Apprendre durement les arcanes...", magie);
	}

	private void initSkill(GridBagConstraints gbcComp, int gridy, String title, String description,
			JCaracteristic jCaracteristic) {
		gbcComp.gridy = gridy;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 0;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.EAST;
		gbcComp.fill = GridBagConstraints.NONE;
		JLabel jlCompTitle = new JLabel(title);
		jlCompTitle.setForeground(new Color(0x886A08));
		this.add(jlCompTitle, gbcComp);
		gbcComp.gridy = gridy;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 1;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.CENTER;
		gbcComp.fill = GridBagConstraints.HORIZONTAL;
		jCaracteristic.setOpaque(false);
		this.add(jCaracteristic, gbcComp);
		gbcComp.gridy = gridy;
		gbcComp.gridheight = 1;
		gbcComp.gridx = 2;
		gbcComp.gridwidth = 1;
		gbcComp.anchor = GridBagConstraints.WEST;
		gbcComp.fill = GridBagConstraints.HORIZONTAL;
		this.add(new JLabel(description), gbcComp);
	}
}
