package io.github.algorys.agshmne.game.character;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.tile.JTile;

@SuppressWarnings("serial")
public class JPanCharacter extends JPanel {
	private JLabel jlFor;
	private JLabel jlDex;
	private JLabel jlCon;
	private JLabel jlInt;
	private JLabel jlCha;
	
	public JPanCharacter(Player pj) {
		this.setPreferredSize(new Dimension(300, 1000));
		this.setBackground(Color.black);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbcCharacter = new GridBagConstraints();
		// Ajuste la taille du GridBag
		gbcCharacter.insets = new Insets(5, 5, 5, 5);

		// TITRE
		gbcCharacter.gridy = 0;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.CENTER;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jpPerso = new JLabel("Nom : " + pj.getName());
		jpPerso.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jpPerso.setForeground(Color.white);
		this.add(jpPerso, gbcCharacter);

		// SOCIAL
		gbcCharacter.gridy = 1;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.CENTER;
		gbcCharacter.fill = GridBagConstraints.NONE;
		this.add(new JLabel("--- Social ---"), gbcCharacter);

		// Race
		gbcCharacter.gridy = 2;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.CENTER;
		gbcCharacter.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Race : " + pj.getSocial().getRace() + " (Sexe : " + pj.getSocial().getSexe() + ")"),
				gbcCharacter);

		gbcCharacter.gridy = 3;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.CENTER;
		gbcCharacter.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Classe : " + pj.getSocial().getClasse()), gbcCharacter);

		gbcCharacter.gridy = 4;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.CENTER;
		gbcCharacter.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Background : " + pj.getSocial().getBackground()), gbcCharacter);

		// COLONNE GAUCHE
		// Vital
		gbcCharacter.gridy = 5;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 2;
		gbcCharacter.anchor = GridBagConstraints.CENTER;
		gbcCharacter.fill = GridBagConstraints.NONE;
		this.add(new JLabel("--- Vitaux ---"), gbcCharacter);

		// PdVs
		gbcCharacter.gridy = 6;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jIcon = new JLabel();
		Image imgLife;
		try {
			imgLife = ImageIO.read(JTile.class.getClassLoader().getResource("life.png"));
			jIcon.setIcon(new ImageIcon(imgLife));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.add(jIcon, gbcCharacter);
		gbcCharacter.gridy = 6;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 1;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Vie : " + pj.getVital().getVie()), gbcCharacter);

		// Mana
		gbcCharacter.gridy = 7;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jMana = new JLabel();
		Image imgMana;
		try {
			imgMana = ImageIO.read(JTile.class.getClassLoader().getResource("mana.png"));
			jMana.setIcon(new ImageIcon(imgMana));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.add(jMana, gbcCharacter);
		gbcCharacter.gridy = 7;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 1;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Mana : " + pj.getVital().getMana()), gbcCharacter);

		// Faim
		gbcCharacter.gridy = 8;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jHungry = new JLabel();
		Image imgFood;
		try {
			imgFood = ImageIO.read(JTile.class.getClassLoader().getResource("meat.png"));
			jHungry.setIcon(new ImageIcon(imgFood));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.add(jHungry, gbcCharacter);
		gbcCharacter.gridy = 8;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 1;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Faim : " + pj.getVital().getFaim()), gbcCharacter);

		// Fatigue
		gbcCharacter.gridy = 9;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jTired = new JLabel();
		Image imgTired;
		try {
			imgTired = ImageIO.read(JTile.class.getClassLoader().getResource("tired.png"));
			jTired.setIcon(new ImageIcon(imgTired));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.add(jTired, gbcCharacter);
		gbcCharacter.gridy = 9;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 1;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Fatigue : " + pj.getVital().getFatigue()), gbcCharacter);

		// COLONNE DROITE
		// Caractéristiques
		gbcCharacter.gridy = 10;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.CENTER;
		gbcCharacter.fill = GridBagConstraints.NONE;
		this.add(new JLabel("--- Caractéristiques ---"), gbcCharacter);
		// FOR
		gbcCharacter.gridy = 11;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.CENTER;
		gbcCharacter.fill = GridBagConstraints.NONE;
		jlFor = new JLabel("FOR : " + pj.getCurrentAttributes().getFOR());
		jlFor.setForeground(Color.white);
		this.add(jlFor, gbcCharacter);
		// DEX
		gbcCharacter.gridy = 12;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.CENTER;
		gbcCharacter.fill = GridBagConstraints.NONE;
		jlDex = new JLabel("DEX : " + pj.getCurrentAttributes().getDEX());
		jlDex.setForeground(Color.white);
		this.add(jlDex, gbcCharacter);
		// CON
		gbcCharacter.gridy = 13;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.CENTER;
		gbcCharacter.fill = GridBagConstraints.NONE;
		jlCon = new JLabel("CON : " + pj.getCurrentAttributes().getCON());
		jlCon.setForeground(Color.white);
		this.add(jlCon, gbcCharacter);
		// INT
		gbcCharacter.gridy = 14;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.CENTER;
		gbcCharacter.fill = GridBagConstraints.NONE;
		jlInt = new JLabel("INT : " + pj.getCurrentAttributes().getINT());
		jlInt.setForeground(Color.white);
		this.add(jlInt, gbcCharacter);
		// CHA
		gbcCharacter.gridy = 15;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.CENTER;
		gbcCharacter.fill = GridBagConstraints.NONE;
		jlCha = new JLabel("CHA : " + pj.getCurrentAttributes().getCHA());
		jlCha.setForeground(Color.white);
		this.add(jlCha, gbcCharacter);

		pj.addPropertyChangeListener(Character.PROPERTY_CURRENT_ATTRIBUTES, new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getSource() instanceof Player) {
					Player pj = (Player) evt.getSource();
					jlFor.setText("FOR : " + pj.getCurrentAttributes().getFOR());
					jlDex.setText("DEX : " + pj.getCurrentAttributes().getDEX());
					jlCon.setText("CON : " + pj.getCurrentAttributes().getCON());
					jlInt.setText("INT : " + pj.getCurrentAttributes().getINT());
					jlCha.setText("CHA : " + pj.getCurrentAttributes().getCHA());
				}

			}
		});
	}
}
