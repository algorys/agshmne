package io.github.algorys.agshmne.charactercreation;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import io.github.algorys.agshmne.character.player.PlayerBuilder;

@SuppressWarnings("serial")
public class JSocialPanel extends JPanel {
	private JTextField jtfName;
	private JComboBox<String> jcbSexe;
	private JComboBox<String> jcbRace;
	private JTextField jtfClasse;

	public JSocialPanel(final PlayerBuilder builder) {
		super();
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbcSocial = new GridBagConstraints();
		// Ajuste la taille du GridBag
		gbcSocial.insets = new Insets(5, 5, 5, 5);

		// TITRE
		gbcSocial.gridy = 0;
		gbcSocial.gridheight = 1;
		gbcSocial.gridx = 0;
		gbcSocial.gridwidth = 4;
		gbcSocial.anchor = GridBagConstraints.CENTER;
		gbcSocial.fill = GridBagConstraints.NONE;
		this.add(new JLabel("FICHE PERSONNAGE JOUEUR"), gbcSocial);

		// Titre Panel
		gbcSocial.gridy = 1;
		gbcSocial.gridheight = 1;
		gbcSocial.gridx = 0;
		gbcSocial.gridwidth = 4;
		gbcSocial.anchor = GridBagConstraints.CENTER;
		gbcSocial.fill = GridBagConstraints.NONE;
		this.add(new JLabel("- Social -"), gbcSocial);

		// NOM
		gbcSocial.gridy = 2;
		gbcSocial.gridheight = 1;
		gbcSocial.gridx = 0;
		gbcSocial.gridwidth = 1;
		gbcSocial.anchor = GridBagConstraints.WEST;
		gbcSocial.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Nom"), gbcSocial);

		gbcSocial.gridy = 2;
		gbcSocial.gridheight = 1;
		gbcSocial.gridx = 1;
		gbcSocial.gridwidth = 1;
		gbcSocial.anchor = GridBagConstraints.WEST;
		gbcSocial.fill = GridBagConstraints.HORIZONTAL;
		jtfName = new JTextField();
		jtfName.setDocument(new JTextFieldLimit(14));
		jtfName.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				builder.setName(jtfName.getText());
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				builder.setName(jtfName.getText());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				builder.setName(jtfName.getText());
			}
		});
		this.add(jtfName, gbcSocial);

		gbcSocial.gridx = 3;
		this.add(new JLabel("Donnez un nom à votre personnage."), gbcSocial);

		// SEXE
		gbcSocial.gridy = 3;
		gbcSocial.gridheight = 1;
		gbcSocial.gridx = 0;
		gbcSocial.gridwidth = 1;
		gbcSocial.anchor = GridBagConstraints.WEST;
		gbcSocial.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Sexe"), gbcSocial);

		gbcSocial.gridy = 3;
		gbcSocial.gridheight = 1;
		gbcSocial.gridx = 1;
		gbcSocial.gridwidth = 1;
		gbcSocial.anchor = GridBagConstraints.WEST;
		gbcSocial.fill = GridBagConstraints.HORIZONTAL;
		jcbSexe = new JComboBox<String>();

		List<String> genderPossibilities = Arrays.asList("Mâle", "Femelle");
		for (String gender : genderPossibilities) {
			jcbSexe.addItem(gender);
		}
		jcbSexe.setSelectedIndex(genderPossibilities.indexOf(builder.getGender()));
		jcbSexe.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					builder.setGender((String) e.getItem());
				}
			}
		});
		this.add(jcbSexe, gbcSocial);

		gbcSocial.gridx = 3;
		this.add(new JLabel("Choisissez votre sexe."), gbcSocial);

		// RACE
		gbcSocial.gridy = 4;
		gbcSocial.gridheight = 1;
		gbcSocial.gridx = 0;
		gbcSocial.gridwidth = 1;
		gbcSocial.anchor = GridBagConstraints.WEST;
		gbcSocial.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Race"), gbcSocial);

		gbcSocial.gridy = 4;
		gbcSocial.gridheight = 1;
		gbcSocial.gridx = 1;
		gbcSocial.gridwidth = 1;
		gbcSocial.anchor = GridBagConstraints.WEST;
		gbcSocial.fill = GridBagConstraints.HORIZONTAL;
		jcbRace = new JComboBox<String>();
		List<String> racePossibilities = Arrays.asList("Humain", "Elfe", "Nain", "Félide", "Yogi", "Valure");
		for (String race : racePossibilities) {
			jcbRace.addItem(race);
		}
		jcbRace.setSelectedIndex(racePossibilities.indexOf(builder.getRace()));
		jcbRace.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					builder.setRace((String) e.getItem());
				}
			}
		});
		this.add(jcbRace, gbcSocial);

		gbcSocial.gridx = 3;
		this.add(new JLabel("Choisissez votre race. (Sans effet pour le moment)"), gbcSocial);

		// CLASSE
		gbcSocial.gridy = 5;
		gbcSocial.gridheight = 1;
		gbcSocial.gridx = 0;
		gbcSocial.gridwidth = 1;
		gbcSocial.anchor = GridBagConstraints.WEST;
		gbcSocial.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Classe"), gbcSocial);

		gbcSocial.gridy = 5;
		gbcSocial.gridheight = 1;
		gbcSocial.gridx = 1;
		gbcSocial.gridwidth = 1;
		gbcSocial.anchor = GridBagConstraints.WEST;
		gbcSocial.fill = GridBagConstraints.HORIZONTAL;
		jtfClasse = new JTextField();
		jtfClasse.setDocument(new JTextFieldLimit(25));
		jtfClasse.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				builder.setJob(jtfClasse.getText());
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				builder.setJob(jtfClasse.getText());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				builder.setJob(jtfClasse.getText());
			}
		});
		this.add(jtfClasse, gbcSocial);

		gbcSocial.gridx = 3;
		this.add(new JLabel("Définissez votre propre classe."), gbcSocial);

	}
}