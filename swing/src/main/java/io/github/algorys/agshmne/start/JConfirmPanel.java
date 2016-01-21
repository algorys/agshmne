package io.github.algorys.agshmne.start;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
		JTextField jtName = new JTextField("Nom : " + social.getPjName());
		jtName.setEditable(false);
		this.add(jtName, gbcConfirm);
		// Sexe
		gbcConfirm.gridy = 3;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JTextField jtSexe = new JTextField("Sexe : " + social.getPjSexe());
		jtSexe.setEditable(false);
		this.add(jtSexe, gbcConfirm);
		// Race
		gbcConfirm.gridy = 4;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JTextField jtRace = new JTextField("Race : " + social.getPjRace());
		jtRace.setEditable(false);
		this.add(jtRace, gbcConfirm);
		// Classe
		gbcConfirm.gridy = 5;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JTextField jtClasse = new JTextField("Classe : " + social.getPjClass());
		jtClasse.setEditable(false);
		this.add(jtClasse, gbcConfirm);
		// Background
		gbcConfirm.gridy = 6;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JTextArea jtBckgrd= new JTextArea("Background : " + social.getPjBackground());
		jtBckgrd.setEditable(false);
		this.add(jtBckgrd, gbcConfirm);
				
		// CARACTERISTIQUES
		gbcConfirm.gridy = 7;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.CENTER;
		gbcConfirm.fill = GridBagConstraints.NONE;
		this.add(new JLabel("- Caractéristiques -"), gbcConfirm);
		// FOR
		gbcConfirm.gridy = 8;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JTextField jtForce = new JTextField("Force : " + carac.getFOR());
		jtForce.setEditable(false);
		this.add(jtForce, gbcConfirm);
		// DEX
		gbcConfirm.gridy = 9;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JTextField jtDexterite = new JTextField("Dextérité : " + carac.getDEX());
		jtDexterite.setEditable(false);
		this.add(jtDexterite, gbcConfirm);
		// CON
		gbcConfirm.gridy = 10;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JTextField jtConstit = new JTextField("Constitution : " + carac.getCON());
		jtConstit.setEditable(false);
		this.add(jtConstit, gbcConfirm);
		// INT
		gbcConfirm.gridy = 11;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JTextField jtIntellect = new JTextField("Intelligence : " + carac.getINT());
		jtIntellect.setEditable(false);
		this.add(jtIntellect, gbcConfirm);
		// CHA
		gbcConfirm.gridy = 12;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JTextField jtCharism = new JTextField("Dextérité : " + carac.getCHA());
		jtCharism.setEditable(false);
		this.add(jtCharism, gbcConfirm);

		// COMPETENCES
		gbcConfirm.gridy = 13;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.CENTER;
		gbcConfirm.fill = GridBagConstraints.NONE;
		this.add(new JLabel("-- Compétences --"), gbcConfirm);
		// Cuisine
		gbcConfirm.gridy = 14;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JTextField jtCuisine = new JTextField("Cuisine : " + comp.getCuisiner());
		jtCuisine.setEditable(false);
		this.add(jtCuisine, gbcConfirm);
		// Fouiller
		gbcConfirm.gridy = 15;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JTextField jtFouiller = new JTextField("Fouiller : " + comp.getFouiller());
		jtFouiller.setEditable(false);
		this.add(jtFouiller, gbcConfirm);
		// Boucherie
		gbcConfirm.gridy = 16;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JTextField jtBoucher = new JTextField("Boucherie : " + comp.getBoucherie());
		jtBoucher.setEditable(false);
		this.add(jtBoucher, gbcConfirm);
		// Bucheron
		gbcConfirm.gridy = 17;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JTextField jtBucheron = new JTextField("Bucheron : " + comp.getBucheron());
		jtBucheron.setEditable(false);
		this.add(jtBucheron, gbcConfirm);
		// Miner
		gbcConfirm.gridy = 18;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JTextField jtMiner = new JTextField("Miner : " + comp.getMiner());
		jtMiner.setEditable(false);
		this.add(jtMiner, gbcConfirm);
		// Cultiver
		gbcConfirm.gridy = 19;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JTextField jtCultiver = new JTextField("Cultiver : " + comp.getCultiver());
		jtCultiver.setEditable(false);
		this.add(jtCultiver, gbcConfirm);
		// Pecher
		gbcConfirm.gridy = 20;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JTextField jtPecher = new JTextField("Cultiver : " + comp.getPecher());
		jtPecher.setEditable(false);
		this.add(jtPecher, gbcConfirm);
		// Magie
		gbcConfirm.gridy = 21;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JTextField jtMagie = new JTextField("Cultiver : " + comp.getMagie());
		jtMagie.setEditable(false);
		this.add(jtMagie, gbcConfirm);
		
		// COMPETENCES
		gbcConfirm.gridy = 22;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.CENTER;
		gbcConfirm.fill = GridBagConstraints.NONE;
		this.add(new JLabel("-- Inventaire de départ --"), gbcConfirm);
		// Premier Objet
		gbcConfirm.gridy = 23;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JTextField jtObjectOne = new JTextField("Objet 1 : " + inv.getFirstObject());
		jtObjectOne.setEditable(false);
		this.add(jtObjectOne, gbcConfirm);
		// Premier Objet
		gbcConfirm.gridy = 24;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JTextField jtObjectTwo = new JTextField("Objet 2 : " + inv.getSecondObject());
		jtObjectTwo.setEditable(false);
		this.add(jtObjectTwo, gbcConfirm);
	}

}
