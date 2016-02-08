package io.github.algorys.agshmne.game.character;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.BevelBorder;

import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.character.Vital;
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
		gbcCharacter.insets = new Insets(5, 5, 5, 5);

		// Nom PJ
		gbcCharacter.gridy = 0;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.CENTER;
		gbcCharacter.fill = GridBagConstraints.HORIZONTAL;
		JLabel jpPerso = new JLabel(pj.getName());
		jpPerso.setFont(new Font("URW Chancery L", Font.PLAIN,40));
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
		titleSocial.setFont(new Font("URW Chancery L", Font.PLAIN,30));
		titleSocial.setForeground(Color.green);
		this.add(titleSocial, gbcCharacter);

		// Race
		gbcCharacter.gridy = 2;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.HORIZONTAL;
		JLabel jlRace = new JLabel("Race : " + pj.getSocial().getRace() + " (Sexe : " + pj.getSocial().getSexe() + ")");
		jlRace.setForeground(Color.white);
		this.add(jlRace, gbcCharacter);

		gbcCharacter.gridy = 3;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlJob = new JLabel("Classe : " + pj.getSocial().getClasse());
		jlJob.setForeground(Color.white);
		this.add(jlJob, gbcCharacter);

		gbcCharacter.gridy = 4;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlBackGrd = new JLabel("Background : " + pj.getSocial().getBackground());
		jlBackGrd.setForeground(Color.white);
		this.add(jlBackGrd, gbcCharacter);

		// Vital
		gbcCharacter.gridy = 5;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.CENTER;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel titleVital = new JLabel("Vitaux");
		titleVital.setFont(new Font("URW Chancery L", Font.PLAIN,30));
		titleVital.setForeground(Color.green);
		this.add(titleVital, gbcCharacter);

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
		JLabel jlLifeTitle = new JLabel("Vie : ");
		jlLifeTitle.setForeground(Color.white);
		this.add(jlLifeTitle, gbcCharacter);

		gbcCharacter.gridy = 6;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 2;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.EAST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		final JLabel jlLife = new JLabel(""+pj.getVital().getVie());
		jlLife.setForeground(Color.white);
		this.add(jlLife, gbcCharacter);

		pj.getVital().addPropertyChangeListener(Vital.PROPERTY_VIE, new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getNewValue() instanceof Integer) {
					jlLife.setText(evt.getNewValue().toString());
				}
			}
		});

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
		JLabel jlMana = new JLabel("Mana : " + pj.getVital().getMana());
		jlMana.setForeground(Color.white);
		this.add(jlMana, gbcCharacter);

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
		JLabel jlHungry = new JLabel("Faim : " + pj.getVital().getFaim());
		jlHungry.setForeground(Color.white);
		this.add(jlHungry, gbcCharacter);

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
		JLabel jlTired = new JLabel("Fatigue : " + pj.getVital().getFatigue());
		jlTired.setForeground(Color.white);
		this.add(jlTired, gbcCharacter);

		// CARACTERISTIQUES
		gbcCharacter.gridy = 10;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.CENTER;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel titleCarac = new JLabel("Caractéristiques");
		titleCarac.setFont(new Font("URW Chancery L", Font.PLAIN,30));
		titleCarac.setForeground(Color.green);
		this.add(titleCarac, gbcCharacter);
		
		// FOR
		gbcCharacter.gridy = 11;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		jlFor = new JLabel("<html><body>FOR : " +pj.getAttributes().getFOR() +
				" (<span style=color:#00FF00;>" + pj.getCurrentAttributes().getFOR() + "</span>)</body></html>");
		jlFor.setForeground(Color.white);
		this.add(jlFor, gbcCharacter);
		// DEX
		gbcCharacter.gridy = 12;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		jlDex = new JLabel("<html><body>DEX : " +pj.getAttributes().getDEX() +
				" (<span style=color:#00FF00;>" + pj.getCurrentAttributes().getDEX() + "</span>)</body></html>");
		jlDex.setForeground(Color.white);
		this.add(jlDex, gbcCharacter);
		// CON
		gbcCharacter.gridy = 13;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		jlCon = new JLabel("<html><body>CON : " +pj.getAttributes().getCON() +
				" (<span style=color:#00FF00;>" + pj.getCurrentAttributes().getCON() + "</span>)</body></html>");
		jlCon.setForeground(Color.white);
		this.add(jlCon, gbcCharacter);
		// INT
		gbcCharacter.gridy = 14;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		jlInt = new JLabel("<html><body>INT : " +pj.getAttributes().getINT() +
				" (<span style=color:#00FF00;>" + pj.getCurrentAttributes().getINT() + "</span>)</body></html>");
		jlInt.setForeground(Color.white);
		this.add(jlInt, gbcCharacter);
		// CHA
		gbcCharacter.gridy = 15;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		jlCha = new JLabel("<html><body>CHA : " +pj.getAttributes().getCHA() +
				" (<span style=color:#00FF00;>" + pj.getCurrentAttributes().getCHA() + "</span>)</body></html>");
		jlCha.setForeground(Color.white);
		this.add(jlCha, gbcCharacter);

		pj.addPropertyChangeListener(Character.PROPERTY_CURRENT_ATTRIBUTES, new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getSource() instanceof Player) {
					Player pj = (Player) evt.getSource();
					jlFor.setText("<html><body>FOR : " +pj.getAttributes().getFOR() +
							" (<span style=color:#00FF00;>" + pj.getCurrentAttributes().getFOR() + "</span>)</body></html>");
					jlDex.setText("<html><body>DEX : " +pj.getAttributes().getDEX() +
							" (<span style=color:#00FF00;>" + pj.getCurrentAttributes().getDEX() + "</span>)</body></html>");
					jlCon.setText("<html><body>CON : " +pj.getAttributes().getCON() +
							" (<span style=color:#00FF00;>" + pj.getCurrentAttributes().getCON() + "</span>)</body></html>");
					jlInt.setText("<html><body>INT : " +pj.getAttributes().getINT() +
							" (<span style=color:#00FF00;>" + pj.getCurrentAttributes().getINT() + "</span>)</body></html>");
					jlCha.setText("<html><body>CHA : " +pj.getAttributes().getCHA() +
							" (<span style=color:#00FF00;>" + pj.getCurrentAttributes().getCHA() + "</span>)</body></html>");
				}

			}
		});
		
		// Niveau
		gbcCharacter.gridy = 16;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlLevel = new JLabel("Niveau : " + pj.getXp().getLevel());
		jlLevel.setForeground(Color.magenta);
		this.add(jlLevel, gbcCharacter);
		
		// Expérience
		gbcCharacter.gridy = 17;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlXp = new JLabel("Experience : " + pj.getXp().getXp());
		jlXp.setForeground(Color.magenta);
		this.add(jlXp, gbcCharacter);
		
		// Expérience
		gbcCharacter.gridy = 18;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.HORIZONTAL;
		JProgressBar xpBar = new JProgressBar();
		xpBar.setMaximum(pj.getXp().getCurrentStepLevel());
	    xpBar.setMinimum(pj.getLevel() - 1);
	    xpBar.setValue(pj.getXp().getXp());
	    xpBar.setForeground(Color.green);
	    xpBar.setBorder(new BevelBorder(BevelBorder.LOWERED));
	    this.add(xpBar, gbcCharacter);
	}
}
