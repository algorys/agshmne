package io.github.algorys.agshmne.window;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

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
	private int VIE, MANA;
	private int fatigue, faim; 

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

		// CARACTERISTIQUES
		
	}
}
