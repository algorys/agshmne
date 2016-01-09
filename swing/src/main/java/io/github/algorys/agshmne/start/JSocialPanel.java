package io.github.algorys.agshmne.start;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class JSocialPanel extends JPanel {
	private JTextField jtfName;
	private JTextArea jtaBackground;
	private JComboBox<String> jcbSexe;
	private JComboBox<String> jcbRace;
	private JTextField jtfClasse;

	public JSocialPanel() {
		super();
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbcSocial = new GridBagConstraints();
		// Ajuste la taille du GridBag
		gbcSocial.insets = new Insets(5, 5, 5, 5);

		// TITRE
		gbcSocial.gridy = 0;
		gbcSocial.gridheight = 1;
		gbcSocial.gridx = 0;
		gbcSocial.gridwidth = 2;
		gbcSocial.anchor = GridBagConstraints.CENTER;
		gbcSocial.fill = GridBagConstraints.NONE;
		this.add(new JLabel("FICHE PERSONNAGE JOUEUR"), gbcSocial);
		
		// Titre Panel
		gbcSocial.gridy = 1;
		gbcSocial.gridheight = 1;
		gbcSocial.gridx = 0;
		gbcSocial.gridwidth = 2;
		gbcSocial.anchor = GridBagConstraints.CENTER;
		gbcSocial.fill = GridBagConstraints.NONE;
		this.add(new JLabel("- Social -"), gbcSocial);

		// NOM
		gbcSocial.gridy = 2;
		gbcSocial.gridheight = 1;
		gbcSocial.gridx = 0;
		gbcSocial.gridwidth = 1;
		gbcSocial.anchor = GridBagConstraints.EAST;
		gbcSocial.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Nom"), gbcSocial);

		gbcSocial.gridy = 2;
		gbcSocial.gridheight = 1;
		gbcSocial.gridx = 1;
		gbcSocial.gridwidth = 1;
		gbcSocial.anchor = GridBagConstraints.WEST;
		gbcSocial.fill = GridBagConstraints.HORIZONTAL;
		jtfName = new JTextField();
		this.add(jtfName, gbcSocial);

		// SEXE
		gbcSocial.gridy = 3;
		gbcSocial.gridheight = 1;
		gbcSocial.gridx = 0;
		gbcSocial.gridwidth = 1;
		gbcSocial.anchor = GridBagConstraints.EAST;
		gbcSocial.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Sexe"), gbcSocial);
		
		gbcSocial.gridy = 3;
		gbcSocial.gridheight = 1;
		gbcSocial.gridx = 1;
		gbcSocial.gridwidth = 1;
		gbcSocial.anchor = GridBagConstraints.WEST;
		gbcSocial.fill = GridBagConstraints.HORIZONTAL;
		jcbSexe = new JComboBox<String>();
		jcbSexe.addItem("Male");
		jcbSexe.addItem("Femelle");
		this.add(jcbSexe, gbcSocial);
		
		// RACE
		gbcSocial.gridy = 4;
		gbcSocial.gridheight = 1;
		gbcSocial.gridx = 0;
		gbcSocial.gridwidth = 1;
		gbcSocial.anchor = GridBagConstraints.EAST;
		gbcSocial.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Race"), gbcSocial);
				
		gbcSocial.gridy = 4;
		gbcSocial.gridheight = 1;
		gbcSocial.gridx = 1;
		gbcSocial.gridwidth = 1;
		gbcSocial.anchor = GridBagConstraints.WEST;
		gbcSocial.fill = GridBagConstraints.HORIZONTAL;
		jcbRace = new JComboBox<String>();
		jcbRace.addItem("Humain (+1 compétence)");
		jcbRace.addItem("Elfe (+1 DEX)");
		jcbRace.addItem("Demi-Elfe (+1 CHA");
		jcbRace.addItem("Nain (+1 FOR)");
		this.add(jcbRace, gbcSocial);
		
		// CLASSE
		gbcSocial.gridy = 5;
		gbcSocial.gridheight = 1;
		gbcSocial.gridx = 0;
		gbcSocial.gridwidth = 1;
		gbcSocial.anchor = GridBagConstraints.EAST;
		gbcSocial.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Classe"), gbcSocial);
				
		gbcSocial.gridy = 5;
		gbcSocial.gridheight = 1;
		gbcSocial.gridx = 1;
		gbcSocial.gridwidth = 1;
		gbcSocial.anchor = GridBagConstraints.WEST;
		gbcSocial.fill = GridBagConstraints.HORIZONTAL;
		jtfClasse = new JTextField();
		this.add(jtfClasse, gbcSocial);
		
		// BACKGROUND
		gbcSocial.gridy = 6;
		gbcSocial.gridheight = 1;
		gbcSocial.gridx = 0;
		gbcSocial.gridwidth = 1;
		gbcSocial.anchor = GridBagConstraints.EAST;
		gbcSocial.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Background"), gbcSocial);

		gbcSocial.gridy = 6;
		gbcSocial.gridheight = 1;
		gbcSocial.gridx = 1;
		gbcSocial.gridwidth = 1;
		gbcSocial.anchor = GridBagConstraints.WEST;
		gbcSocial.fill = GridBagConstraints.NONE;
		jtaBackground = new JTextArea(5, 50);
		jtaBackground.setBorder(new BevelBorder(BevelBorder.LOWERED));
		this.add(jtaBackground, gbcSocial);
		
		
	}

	public String getPjName() {
		return jtfName.getText();
	}
	
	public String getPjSexe() {
		return (String)jcbSexe.getSelectedItem();
	}
	
	public String getPjRace() {
		return (String)jcbRace.getSelectedItem();
	}
	
	public String getPjClass() {
		return jtfClasse.getText();
	}
	
	public String getPjBackground() {
		return jtaBackground.getText();
	}
	
}