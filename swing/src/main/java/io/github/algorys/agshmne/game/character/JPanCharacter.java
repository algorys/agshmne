package io.github.algorys.agshmne.game.character;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import io.github.algorys.agshmne.character.Attribute;
import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.character.player.PlayerSocial;
import io.github.algorys.agshmne.character.player.PlayerXP;
import io.github.algorys.agshmne.game.character.design.ProgressBarUI;
import io.github.algorys.agshmne.items.Inventory;

@SuppressWarnings("serial")
public class JPanCharacter extends JPanel {

	public JPanCharacter(Player pj) {
		Inventory inventory = pj.getInventory();
		PlayerXP xp = pj.getXp();
		PlayerSocial social = pj.getSocial();

		this.setBackground(Color.black);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbcCharacter = new GridBagConstraints();
		gbcCharacter.insets = new Insets(5, 5, 5, 5);

		// Nom PJ
		gbcCharacter.gridy = 0;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.CENTER;
		gbcCharacter.fill = GridBagConstraints.HORIZONTAL;
		JLabel jpPerso = new JLabel(pj.getName());
		jpPerso.setFont(new Font("URW Chancery L", Font.PLAIN, 40));
		jpPerso.setForeground(Color.white);
		this.add(jpPerso, gbcCharacter);

		// SOCIAL
		gbcCharacter.gridy = 1;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.CENTER;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel titleSocial = new JLabel("Social");
		titleSocial.setFont(new Font("URW Chancery L", Font.PLAIN, 30));
		titleSocial.setForeground(Color.green);
		this.add(titleSocial, gbcCharacter);

		// Race
		gbcCharacter.gridy = 2;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.HORIZONTAL;
		JLabel jlRace = new JLabel("Race : " + social.getRace() + " (Sexe : " + social.getSexe() + ")");
		jlRace.setForeground(Color.white);
		this.add(jlRace, gbcCharacter);

		gbcCharacter.gridy = 3;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.BOTH;
		JLabel jlJob = new JLabel("Classe : " + social.getClasse());
		jlJob.setForeground(Color.white);
		this.add(jlJob, gbcCharacter);

		// Vital
		gbcCharacter.gridy = 5;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.CENTER;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel titleVital = new JLabel("Vitaux");
		titleVital.setFont(new Font("URW Chancery L", Font.PLAIN, 30));
		titleVital.setForeground(Color.green);
		this.add(titleVital, gbcCharacter);

		gbcCharacter.gridy = 6;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.CENTER;
		gbcCharacter.fill = GridBagConstraints.HORIZONTAL;
		this.add(new JPlayerVital(pj.getVital()), gbcCharacter);
		
		// CARACTERISTIQUES
		gbcCharacter.gridy = 7;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.CENTER;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel titleCarac = new JLabel("Caractéristiques");
		titleCarac.setFont(new Font("URW Chancery L", Font.PLAIN, 30));
		titleCarac.setForeground(Color.green);
		this.add(titleCarac, gbcCharacter);

		gbcCharacter.gridy = 8;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.CENTER;
		gbcCharacter.fill = GridBagConstraints.HORIZONTAL;
		final JPlayerAttribute jPlayerAttribute = new JPlayerAttribute(pj.getAttributes(), pj.getCurrentAttributes());
		this.add(jPlayerAttribute, gbcCharacter);

		pj.addPropertyChangeListener(Character.PROPERTY_CURRENT_ATTRIBUTES, new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getNewValue() instanceof Attribute) {
					jPlayerAttribute.updateCurrentAttributes((Attribute) evt.getNewValue());
				}
			}
		});

		// Gold
		gbcCharacter.gridy = 9;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		final JLabel jlGold = new JLabel("Or restant : " + inventory.getGold());
		jlGold.setForeground(Color.yellow);
		this.add(jlGold, gbcCharacter);
		inventory.addPropertyChangeListener(Inventory.PROPERTY_GOLD, new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getNewValue() instanceof Integer) {
					Integer newValue = (Integer) evt.getNewValue();
					jlGold.setText("Or restant : " + newValue);
				}

			}
		});

		// Niveau
		gbcCharacter.gridy = 10;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlLevel = new JLabel("Niveau : " + xp.getLevel());
		jlLevel.setForeground(Color.magenta);
		this.add(jlLevel, gbcCharacter);

		// Expérience
		gbcCharacter.gridy = 11;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 2;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlXpTitle = new JLabel("Expérience : ");
		jlXpTitle.setForeground(Color.magenta);
		this.add(jlXpTitle, gbcCharacter);

		gbcCharacter.gridy = 11;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 2;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.EAST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		final JLabel jlXp = new JLabel("" + xp.getXp());
		jlXp.setForeground(Color.magenta);
		this.add(jlXp, gbcCharacter);

		// Expérience
		gbcCharacter.gridy = 12;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.HORIZONTAL;
		final JProgressBar xpBar = new JProgressBar();
		xpBar.setMaximum(xp.getCurrentStepLevel()); // TODO Changement
													// de niveau
		xpBar.setMinimum(0); // TODO Changement de niveau (si on recommence à 0)
		xpBar.setValue(xp.getXp());
		xpBar.setBackground(Color.black);
		xpBar.setForeground(Color.green);
		xpBar.setUI(new ProgressBarUI());
		this.add(xpBar, gbcCharacter);

		xp.addPropertyChangeListener(PlayerXP.PROPERTY_XP, new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getNewValue() instanceof Integer) {
					Integer newValue = (Integer) evt.getNewValue();
					jlXp.setText(newValue.toString());
					xpBar.setValue(newValue);
				}
			}
		});
	}
}
