package io.github.algorys.agshmne.charactercreation;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.player.PlayerBuilder;
import io.github.algorys.agshmne.character.player.skills.SkillType;

@SuppressWarnings("serial")
public class JConfirmPanel extends JPanel {
	private JLabel jtName;
	private JLabel jtSexe;
	private JLabel jtRace;
	private JLabel jtClasse;

	private JLabel jtForce;
	private JLabel jtDexterite;
	private JLabel jtConstit;
	private JLabel jtIntellect;
	private JLabel jtCharism;

	private PlayerBuilder builder;

	private JLabel jtMagie;
	private JLabel jtPecher;
	private JLabel jtCultiver;
	private JLabel jtMiner;
	private JLabel jtBucheron;
	private JLabel jtBoucher;
	private JLabel jtFouiller;
	private JLabel jtCuisine;
	private JLabel jtSecondItem;
	private JLabel jtFirstItem;

	public JConfirmPanel(PlayerBuilder builder) {
		super();
		this.builder = builder;
		// GridBag Layout
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbcConfirm = new GridBagConstraints();
		gbcConfirm.insets = new Insets(5, 5, 5, 5);

		Font title = new Font("Courier New", Font.PLAIN, 18);

		// TITRE
		gbcConfirm.gridy = 0;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 2;
		gbcConfirm.anchor = GridBagConstraints.CENTER;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JLabel recap = new JLabel("Récapitulatif");
		recap.setFont(new Font("Courier", Font.BOLD, 20));
		this.add(recap, gbcConfirm);

		// SOCIAL
		gbcConfirm.gridy = 1;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 2;
		gbcConfirm.anchor = GridBagConstraints.CENTER;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JLabel social = new JLabel("Social");
		social.setFont(title);
		this.add(social, gbcConfirm);

		// Nom
		gbcConfirm.gridy = 2;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JLabel labelName = new JLabel("Nom : ");
		this.add(labelName, gbcConfirm);

		gbcConfirm.gridx = 1;
		jtName = new JLabel(builder.getName());
		this.add(jtName, gbcConfirm);

		// Sexe
		gbcConfirm.gridy = 3;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JLabel labelGender = new JLabel("Sexe : ");
		this.add(labelGender, gbcConfirm);

		gbcConfirm.gridx = 1;
		jtSexe = new JLabel(builder.getGender());
		this.add(jtSexe, gbcConfirm);

		// Race
		gbcConfirm.gridy = 4;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JLabel labelRace = new JLabel("Race : ");
		this.add(labelRace, gbcConfirm);

		gbcConfirm.gridx = 1;
		jtRace = new JLabel(builder.getRace());
		this.add(jtRace, gbcConfirm);

		// Classe
		gbcConfirm.gridy = 5;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JLabel labelClasse = new JLabel("Classe : ");
		this.add(labelClasse, gbcConfirm);

		gbcConfirm.gridx = 1;
		jtClasse = new JLabel(builder.getJob());
		this.add(jtClasse, gbcConfirm);

		// CARACTERISTIQUES
		gbcConfirm.gridy = 7;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 2;
		gbcConfirm.anchor = GridBagConstraints.CENTER;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JLabel carac = new JLabel("Caractéristiques");
		carac.setFont(title);
		this.add(carac, gbcConfirm);

		// FOR
		gbcConfirm.gridy = 8;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JLabel lbFor = new JLabel("Force : ");
		this.add(lbFor, gbcConfirm);

		gbcConfirm.gridx = 1;
		jtForce = new JLabel("" + builder.getFOR());
		this.add(jtForce, gbcConfirm);

		// DEX
		gbcConfirm.gridy = 9;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JLabel lbDex = new JLabel("Dextérité : ");
		this.add(lbDex, gbcConfirm);

		gbcConfirm.gridx = 1;
		jtDexterite = new JLabel("" + builder.getDEX());
		this.add(jtDexterite, gbcConfirm);

		// CON
		gbcConfirm.gridy = 10;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JLabel lbCon = new JLabel("Constitution : ");
		this.add(lbCon, gbcConfirm);

		gbcConfirm.gridx = 1;
		jtConstit = new JLabel("" + builder.getCON());
		this.add(jtConstit, gbcConfirm);

		// INT
		gbcConfirm.gridy = 11;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JLabel lbInt = new JLabel("Intelligence : ");
		this.add(lbInt, gbcConfirm);

		gbcConfirm.gridx = 1;
		jtIntellect = new JLabel("" + builder.getINT());
		this.add(jtIntellect, gbcConfirm);

		// CHA
		gbcConfirm.gridy = 12;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JLabel lbCha = new JLabel("Charisme : ");
		this.add(lbCha, gbcConfirm);

		gbcConfirm.gridx = 1;
		jtCharism = new JLabel("" + builder.getCHA());
		this.add(jtCharism, gbcConfirm);

		// COMPETENCES
		gbcConfirm.gridy = 13;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 2;
		gbcConfirm.anchor = GridBagConstraints.CENTER;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JLabel comp = new JLabel("Compétences");
		comp.setFont(title);
		this.add(comp, gbcConfirm);

		// Cuisine
		gbcConfirm.gridy = 14;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JLabel jlCui = new JLabel("Cuisine : ");
		this.add(jlCui, gbcConfirm);

		gbcConfirm.gridx = 1;
		jtCuisine = new JLabel("" + builder.getSkillLevel(SkillType.cuisine));
		this.add(jtCuisine, gbcConfirm);

		// Fouiller
		gbcConfirm.gridy = 15;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JLabel jlFou = new JLabel("Fouiller : ");
		this.add(jlFou, gbcConfirm);

		gbcConfirm.gridx = 1;
		jtFouiller = new JLabel("" + builder.getSkillLevel(SkillType.fouiller));
		this.add(jtFouiller, gbcConfirm);

		// Boucherie
		gbcConfirm.gridy = 16;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JLabel jlBou = new JLabel("Boucherie : ");
		this.add(jlBou, gbcConfirm);

		gbcConfirm.gridx = 1;
		jtBoucher = new JLabel("" + builder.getSkillLevel(SkillType.boucherie));
		this.add(jtBoucher, gbcConfirm);

		// Bucheron
		gbcConfirm.gridy = 17;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JLabel jlBuc = new JLabel("Bucheron : ");
		this.add(jlBuc, gbcConfirm);

		gbcConfirm.gridx = 1;
		jtBucheron = new JLabel("" + builder.getSkillLevel(SkillType.bucheron));
		this.add(jtBucheron, gbcConfirm);

		// Miner
		gbcConfirm.gridy = 18;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JLabel jlMin = new JLabel("Miner : ");
		this.add(jlMin, gbcConfirm);

		gbcConfirm.gridx = 1;
		jtMiner = new JLabel("" + builder.getSkillLevel(SkillType.miner));
		this.add(jtMiner, gbcConfirm);

		// Cultiver
		gbcConfirm.gridy = 19;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JLabel jlCul = new JLabel("Cultiver : ");
		this.add(jlCul, gbcConfirm);

		gbcConfirm.gridx = 1;
		jtCultiver = new JLabel("" + builder.getSkillLevel(SkillType.cultiver));
		this.add(jtCultiver, gbcConfirm);

		// Pecher
		gbcConfirm.gridy = 20;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JLabel jlPec = new JLabel("Pêcher : ");
		this.add(jlPec, gbcConfirm);

		gbcConfirm.gridx = 1;
		jtPecher = new JLabel("" + builder.getSkillLevel(SkillType.pecher));
		this.add(jtPecher, gbcConfirm);

		// Magie
		gbcConfirm.gridy = 21;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JLabel jlMag = new JLabel("Magie : ");
		this.add(jlMag, gbcConfirm);

		gbcConfirm.gridx = 1;
		jtMagie = new JLabel("" + builder.getSkillLevel(SkillType.magie));
		this.add(jtMagie, gbcConfirm);

		// INVENTAIRE
		gbcConfirm.gridy = 22;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 2;
		gbcConfirm.anchor = GridBagConstraints.CENTER;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JLabel jlItem = new JLabel("Objets de départ");
		jlItem.setFont(title);
		this.add(jlItem, gbcConfirm);

		// Premier Objet
		gbcConfirm.gridy = 23;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JLabel jlFirst = new JLabel("Objet 1 : ");
		this.add(jlFirst, gbcConfirm);

		gbcConfirm.gridx = 1;
		jtFirstItem = new JLabel("");
		this.add(jtFirstItem, gbcConfirm);

		// Premier Objet
		gbcConfirm.gridy = 24;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JLabel jlSecond = new JLabel("Objet 2 : ");
		this.add(jlSecond, gbcConfirm);

		gbcConfirm.gridx = 1;
		jtSecondItem = new JLabel("");
		this.add(jtSecondItem, gbcConfirm);
	}

	public void refresh() {
		// Social
		jtName.setText(builder.getName());
		jtSexe.setText(builder.getGender());
		jtRace.setText(builder.getRace());
		jtClasse.setText(builder.getJob());
		// Attributs
		jtForce.setText(""+builder.getFOR());
		jtDexterite.setText(""+builder.getDEX());
		jtConstit.setText(""+builder.getCON());
		jtIntellect.setText(""+builder.getINT());
		jtCharism.setText(""+builder.getCHA());
		// Skills
		jtCuisine.setText(""+builder.getSkillLevel(SkillType.cuisine));
		jtFouiller.setText(""+builder.getSkillLevel(SkillType.fouiller));
		jtBoucher.setText(""+builder.getSkillLevel(SkillType.boucherie));
		jtBucheron.setText(""+builder.getSkillLevel(SkillType.bucheron));
		jtMiner.setText(""+builder.getSkillLevel(SkillType.miner));
		jtCultiver.setText(""+builder.getSkillLevel(SkillType.cultiver));
		jtPecher.setText(""+builder.getSkillLevel(SkillType.pecher));
		jtMagie.setText(""+builder.getSkillLevel(SkillType.magie));
		// Object
		jtFirstItem.setText(builder.getFirstItem().getName());
		jtSecondItem.setText(builder.getSecondItem().getName());
	}

}
