package io.github.algorys.agshmne.start;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import io.github.algorys.agshmne.character.Character;

public class JConfirmPanel extends JPanel {
	
	public JConfirmPanel(JSocialPanel social, JCaracPanel carac, JCompPanel comp, JInvPanel inv) {
		super();
		
		// GidBag Layout
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbcConfirm = new GridBagConstraints();
		// Ajuste la taille du GridBag
		gbcConfirm.insets = new Insets(5, 5, 5, 5);

		// TITRE
		gbcConfirm.gridy = 0;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.CENTER;
		gbcConfirm.fill = GridBagConstraints.NONE;
		this.add(new JLabel("CONFIRMATION"), gbcConfirm);
		
		// SOCIAL
		gbcConfirm.gridy = 1;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 2;
		gbcConfirm.anchor = GridBagConstraints.CENTER;
		gbcConfirm.fill = GridBagConstraints.NONE;
		this.add(new JLabel("-- SOCIAL --"), gbcConfirm);

		// Nom
		gbcConfirm.gridy = 2;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JTextField jtName = new JTextField("Nom : " + social.getMyName());
		jtName.setEditable(false);
		this.add(jtName, gbcConfirm);
				
		// CARACTERISTIQUES
		gbcConfirm.gridy = 3;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.CENTER;
		gbcConfirm.fill = GridBagConstraints.NONE;
		this.add(new JLabel("- Caractéristiques -"), gbcConfirm);
		
		// FOR
		gbcConfirm.gridy = 4;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JTextField jtForce = new JTextField("Force : " + carac.getFOR());
		jtForce.setEditable(false);
		this.add(jtForce, gbcConfirm);

		
		// DEX
		gbcConfirm.gridy = 5;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JTextField jtDexterite = new JTextField("Dextérité : " + carac.getDEX());
		jtDexterite.setEditable(false);
		this.add(jtDexterite, gbcConfirm);
		
		// COMPETENCES
		
		gbcConfirm.gridy = 6;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.CENTER;
		gbcConfirm.fill = GridBagConstraints.NONE;
		this.add(new JLabel("-- Compétences --"), gbcConfirm);
		
		gbcConfirm.gridy = 7;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JTextField jtCuisine = new JTextField("Cuisine : " + comp.getCuisiner());
		jtCuisine.setEditable(false);
		this.add(jtCuisine, gbcConfirm);
	}

}
