package io.github.algorys.agshmne.charactercreation;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import io.github.algorys.agshmne.character.player.PlayerBuilder;
import io.github.algorys.agshmne.character.player.skills.SkillType;

@SuppressWarnings("serial")
public class JConfirmPanel extends JPanel {
	private JTextField jtName;
	private JTextField jtSexe;
	private JTextField jtRace;
	private JTextField jtClasse;
	private JTextArea jtBckgrd;
	
	private JTextField jtForce;
	private JTextField jtDexterite;
	private JTextField jtConstit;
	private JTextField jtIntellect;
	private JTextField jtCharism;
	
	private PlayerBuilder builder;
	
	private JTextField jtMagie;
	private JTextField jtPecher;
	private JTextField jtCultiver;
	private JTextField jtMiner;
	private JTextField jtBucheron;
	private JTextField jtBoucher;
	private JTextField jtFouiller;
	private JTextField jtCuisine;
	private JTextField jtSecondItem;
	private JTextField jtFirstItem;

	public JConfirmPanel(PlayerBuilder builder) {
		super();
		this.builder = builder;
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
		jtName = new JTextField("Nom : " + builder.getName());
		jtName.setEditable(false);
		this.add(jtName, gbcConfirm);
		// Sexe
		gbcConfirm.gridy = 3;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		jtSexe = new JTextField("Sexe : " + builder.getGender());
		jtSexe.setEditable(false);
		this.add(jtSexe, gbcConfirm);
		// Race
		gbcConfirm.gridy = 4;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		jtRace = new JTextField("Race : " + builder.getRace());
		jtRace.setEditable(false);
		this.add(jtRace, gbcConfirm);
		// Classe
		gbcConfirm.gridy = 5;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		jtClasse = new JTextField("Classe : " + builder.getJob());
		jtClasse.setEditable(false);
		this.add(jtClasse, gbcConfirm);
		// Background
		gbcConfirm.gridy = 6;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		jtBckgrd = new JTextArea("Background : " + builder.getHistory());
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
		jtForce = new JTextField("Force : " + builder.getFOR());
		jtForce.setEditable(false);
		this.add(jtForce, gbcConfirm);
		// DEX
		gbcConfirm.gridy = 9;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		jtDexterite = new JTextField("Dextérité : " + builder.getDEX());
		jtDexterite.setEditable(false);
		this.add(jtDexterite, gbcConfirm);
		// CON
		gbcConfirm.gridy = 10;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		jtConstit = new JTextField("Constitution : " + builder.getCON());
		jtConstit.setEditable(false);
		this.add(jtConstit, gbcConfirm);
		// INT
		gbcConfirm.gridy = 11;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		jtIntellect = new JTextField("Intelligence : " + builder.getINT());
		jtIntellect.setEditable(false);
		this.add(jtIntellect, gbcConfirm);
		// CHA
		gbcConfirm.gridy = 12;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		jtCharism = new JTextField("Charisme : " + builder.getCHA());
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
		jtCuisine = new JTextField("Cuisine : " + builder.getSkillLevel(SkillType.cuisine));
		jtCuisine.setEditable(false);
		this.add(jtCuisine, gbcConfirm);
		// Fouiller
		gbcConfirm.gridy = 15;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		jtFouiller = new JTextField("Fouiller : " + builder.getSkillLevel(SkillType.fouiller));
		jtFouiller.setEditable(false);
		this.add(jtFouiller, gbcConfirm);
		// Boucherie
		gbcConfirm.gridy = 16;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		jtBoucher = new JTextField("Boucherie : " + builder.getSkillLevel(SkillType.boucherie));
		jtBoucher.setEditable(false);
		this.add(jtBoucher, gbcConfirm);
		// Bucheron
		gbcConfirm.gridy = 17;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		jtBucheron = new JTextField("Bucheron : " + builder.getSkillLevel(SkillType.bucheron));
		jtBucheron.setEditable(false);
		this.add(jtBucheron, gbcConfirm);
		// Miner
		gbcConfirm.gridy = 18;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		jtMiner = new JTextField("Miner : " + builder.getSkillLevel(SkillType.miner));
		jtMiner.setEditable(false);
		this.add(jtMiner, gbcConfirm);
		// Cultiver
		gbcConfirm.gridy = 19;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		jtCultiver = new JTextField("Cultiver : " + builder.getSkillLevel(SkillType.cultiver));
		jtCultiver.setEditable(false);
		this.add(jtCultiver, gbcConfirm);
		// Pecher
		gbcConfirm.gridy = 20;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		jtPecher = new JTextField("Pêcher : " + builder.getSkillLevel(SkillType.pecher));
		jtPecher.setEditable(false);
		this.add(jtPecher, gbcConfirm);
		// Magie
		gbcConfirm.gridy = 21;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		jtMagie = new JTextField("Magie : " + builder.getSkillLevel(SkillType.magie));
		jtMagie.setEditable(false);
		this.add(jtMagie, gbcConfirm);

		// INVENTAIRE
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
		jtFirstItem = new JTextField("Objet 1 : " + builder.getFirstItem());
		jtFirstItem.setEditable(false);
		this.add(jtFirstItem, gbcConfirm);
		// Premier Objet
		gbcConfirm.gridy = 24;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		jtSecondItem = new JTextField("Objet 2 : " + builder.getSecondItem());
		jtSecondItem.setEditable(false);
		this.add(jtSecondItem, gbcConfirm);
	}

	public void refresh() {
		// Social
		jtName.setText("Nom : " + builder.getName());
		jtSexe.setText("Sexe : " + builder.getGender());
		jtRace.setText("Race : " + builder.getRace());
		jtClasse.setText("Classe : " + builder.getJob());
		jtBckgrd.setText("Background : " + builder.getHistory());
		// Attributs
		jtForce.setText("Force : " + builder.getFOR());
		jtDexterite.setText("Dextérité : " + builder.getDEX());
		jtConstit.setText("Constitution : " + builder.getCON());
		jtIntellect.setText("Intelligence : " + builder.getINT());
		jtCharism.setText("Charisme : " + builder.getCHA());
		// Skills
		jtCuisine.setText("Cuisine : " + builder.getSkillLevel(SkillType.cuisine));
		jtFouiller.setText("Fouiller : " + builder.getSkillLevel(SkillType.fouiller));
		jtBoucher.setText("Boucherie : " + builder.getSkillLevel(SkillType.boucherie));
		jtBucheron.setText("Bucheron : " + builder.getSkillLevel(SkillType.bucheron));
		jtMiner.setText("Miner : " + builder.getSkillLevel(SkillType.miner));
		jtCultiver.setText("Cultiver : " + builder.getSkillLevel(SkillType.cultiver));
		jtPecher.setText("Pêcher : " + builder.getSkillLevel(SkillType.pecher));
		jtMagie.setText("Magie : " + builder.getSkillLevel(SkillType.magie));
		// Object
		jtFirstItem.setText("Objet 1 : " + builder.getFirstItem());
		jtSecondItem.setText("Objet 2 : " + builder.getSecondItem());
	}

}
