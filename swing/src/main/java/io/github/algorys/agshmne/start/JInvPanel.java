package io.github.algorys.agshmne.start;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;

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
		this.add(new JLabel("Vous êtes trop pauvre !"), gbcInv);
	
	}
}
