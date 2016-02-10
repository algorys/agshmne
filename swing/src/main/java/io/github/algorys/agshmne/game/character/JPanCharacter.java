package io.github.algorys.agshmne.game.character;

import java.awt.Color;
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
import io.github.algorys.agshmne.character.player.PlayerXP;
import io.github.algorys.agshmne.tile.JTile;

@SuppressWarnings("serial")
public class JPanCharacter extends JPanel {
	private JLabel jlFor;
	private JLabel jlDex;
	private JLabel jlCon;
	private JLabel jlInt;
	private JLabel jlCha;
	
	public JPanCharacter(Player pj) {
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
		JLabel jlLifeIcon = new JLabel();
		try {
			Image imgLife = ImageIO.read(JTile.class.getClassLoader().getResource("life.png"));
			jlLifeIcon.setIcon(new ImageIcon(imgLife));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.add(jlLifeIcon, gbcCharacter);

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
		JLabel jlManaIcon = new JLabel();
		try {
			Image imgMana = ImageIO.read(JTile.class.getClassLoader().getResource("mana.png"));
			jlManaIcon.setIcon(new ImageIcon(imgMana));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.add(jlManaIcon, gbcCharacter);
		gbcCharacter.gridy = 7;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 1;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlManaTitle = new JLabel("Mana : ");
		jlManaTitle.setForeground(Color.white);
		this.add(jlManaTitle, gbcCharacter);

		gbcCharacter.gridy = 7;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 2;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.EAST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		final JLabel jlMana = new JLabel(""+pj.getVital().getMana());
		jlMana.setForeground(Color.white);
		this.add(jlMana, gbcCharacter);
		pj.getVital().addPropertyChangeListener(Vital.PROPERTY_MANA, new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				jlMana.setText(evt.getNewValue().toString());
			}
		});

		// Faim
		gbcCharacter.gridy = 8;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlHungryIcon = new JLabel();
		try {
			Image imgFood = ImageIO.read(JTile.class.getClassLoader().getResource("meat.png"));
			jlHungryIcon.setIcon(new ImageIcon(imgFood));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.add(jlHungryIcon, gbcCharacter);

		gbcCharacter.gridy = 8;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 1;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlHungryTitle = new JLabel("Faim : ");
		jlHungryTitle.setForeground(Color.white);
		this.add(jlHungryTitle, gbcCharacter);
		
		gbcCharacter.gridy = 8;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 2;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.EAST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		final JLabel jlHungry = new JLabel("" + pj.getVital().getFaim());
		jlHungry.setForeground(Color.white);
		this.add(jlHungry, gbcCharacter);
		pj.getVital().addPropertyChangeListener(Vital.PROPERTY_FAIM, new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				jlHungry.setText(evt.getNewValue().toString());
			}
		});

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
		gbcCharacter.gridwidth = 2;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlXpTitle = new JLabel("Expérience : ");
		jlXpTitle.setForeground(Color.magenta);
		this.add(jlXpTitle, gbcCharacter);

		gbcCharacter.gridy = 17;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 2;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.EAST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		final JLabel jlXp = new JLabel(""+pj.getXp().getXp());
		jlXp.setForeground(Color.magenta);
		this.add(jlXp, gbcCharacter);

		// Expérience
		gbcCharacter.gridy = 18;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.HORIZONTAL;
		final JProgressBar xpBar = new JProgressBar();
		xpBar.setMaximum(pj.getXp().getCurrentStepLevel()); // TODO Changement de niveau
		xpBar.setMinimum(0); // TODO Changement de niveau (si on recommence à 0)
		xpBar.setValue(pj.getXp().getXp());
		xpBar.setForeground(Color.green);
		xpBar.setBorder(new BevelBorder(BevelBorder.LOWERED));
		this.add(xpBar, gbcCharacter);

		pj.getXp().addPropertyChangeListener(PlayerXP.PROPERTY_XP, new PropertyChangeListener() {

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
