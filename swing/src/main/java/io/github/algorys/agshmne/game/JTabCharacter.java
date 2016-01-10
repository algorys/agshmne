package io.github.algorys.agshmne.game;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.Character;

import io.github.algorys.agshmne.tile.JTile;

public class JTabCharacter extends JPanel {
	
	public JTabCharacter(Character pj) {
		// GidBag Layout
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
		this.add(new JLabel("PERSONNAGE"), gbcCharacter);
		
		// COLONNE GAUCHE
		gbcCharacter.gridy = 1;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 2;
		gbcCharacter.anchor = GridBagConstraints.CENTER;
		gbcCharacter.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Vitaux"), gbcCharacter);
		
		// TODO PdVs et Mana
		gbcCharacter.gridy = 2;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Vie : 0 | Mana : 0"), gbcCharacter);
		
		gbcCharacter.gridy = 2;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 1;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Fatigue : 0 | Faim : 0"), gbcCharacter);
		
		gbcCharacter.gridy = 3;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 2;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Caractéristiques"), gbcCharacter);
		
		gbcCharacter.gridy = 4;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 2;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		this.add(new JLabel("FOR : " + pj.getAttributes().getFOR()), gbcCharacter);
		
		gbcCharacter.gridy = 5;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 2;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		this.add(new JLabel("DEX : " + pj.getAttributes().getDEX()), gbcCharacter);
		
		gbcCharacter.gridy = 6;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 2;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		this.add(new JLabel("CON : " + pj.getAttributes().getCON()), gbcCharacter);
		
		// COLONNE DROITE
		gbcCharacter.gridy = 1;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 2;
		gbcCharacter.gridwidth = 2;
		gbcCharacter.anchor = GridBagConstraints.EAST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Compétences"), gbcCharacter);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int width = getPreferredSize().width;
		int height = getPreferredSize().height;
		int x = (this.getWidth() - width) / 2;
		int y = (this.getHeight() - height) / 2;
		try {
			Image img = ImageIO.read(JTile.class.getClassLoader().getResource("parchemin.png"));
			Image imgBack = ImageIO.read(JTile.class.getClassLoader().getResource("table.png") );
			g.drawImage(imgBack, 0, 0, this.getWidth(), this.getHeight(), this);
			g.drawImage(img, x, y, width, height, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
