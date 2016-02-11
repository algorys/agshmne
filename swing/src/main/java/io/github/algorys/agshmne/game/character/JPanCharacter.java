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
import io.github.algorys.agshmne.items.Inventory;
import io.github.algorys.agshmne.tile.JTile;

@SuppressWarnings("serial")
public class JPanCharacter extends JPanel {
	private JLabel jlForCurrent;
	private JLabel jlDexCurrent;
	private JLabel jlConCurrent;
	private JLabel jlIntCurrent;
	private JLabel jlChaCurrent;

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
		JLabel jlRace = new JLabel("Race : " + pj.getSocial().getRace() + " (Sexe : " + pj.getSocial().getSexe() + ")");
		jlRace.setForeground(Color.white);
		this.add(jlRace, gbcCharacter);

		gbcCharacter.gridy = 3;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.BOTH;
		JLabel jlJob = new JLabel("Classe : " + pj.getSocial().getClasse());
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
		final JLabel jlLife = new JLabel("" + pj.getVital().getVie());
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
		final JLabel jlMana = new JLabel("" + pj.getVital().getMana());
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
		JLabel jlTiredIcon = new JLabel();
		try {
			Image imgTired = ImageIO.read(JTile.class.getClassLoader().getResource("tired.png"));
			jlTiredIcon.setIcon(new ImageIcon(imgTired));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.add(jlTiredIcon, gbcCharacter);

		gbcCharacter.gridy = 9;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 1;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlTiredTitle = new JLabel("Fatigue : ");
		jlTiredTitle.setForeground(Color.white);
		this.add(jlTiredTitle, gbcCharacter);

		gbcCharacter.gridy = 9;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 2;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.EAST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		final JLabel jlTired = new JLabel("" + pj.getVital().getFatigue());
		jlTired.setForeground(Color.white);
		this.add(jlTired, gbcCharacter);
		pj.getVital().addPropertyChangeListener(Vital.PROPERTY_FATIGUE, new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				jlTired.setText(evt.getNewValue().toString());
			}
		});

		// CARACTERISTIQUES
		gbcCharacter.gridy = 10;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.CENTER;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel titleCarac = new JLabel("Caractéristiques");
		titleCarac.setFont(new Font("URW Chancery L", Font.PLAIN, 30));
		titleCarac.setForeground(Color.green);
		this.add(titleCarac, gbcCharacter);

		// FOR
		gbcCharacter.gridy = 11;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.EAST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlForBase = new JLabel("FOR : ");
		jlForBase.setForeground(Color.white);
		this.add(jlForBase, gbcCharacter);

		gbcCharacter.gridy = 11;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 1;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.CENTER;
		gbcCharacter.fill = GridBagConstraints.NONE;
		jlForBase = new JLabel("" + pj.getAttributes().getFOR());
		jlForBase.setForeground(Color.white);
		this.add(jlForBase, gbcCharacter);

		gbcCharacter.gridy = 11;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 2;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.EAST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		jlForCurrent = new JLabel("(" + pj.getCurrentAttributes().getFOR() + ")");
		jlForCurrent.setForeground(Color.GREEN);
		this.add(jlForCurrent, gbcCharacter);

		// DEX
		gbcCharacter.gridy = 12;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.EAST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlDexTitle = new JLabel("DEX : ");
		jlDexTitle.setForeground(Color.white);
		this.add(jlDexTitle, gbcCharacter);

		gbcCharacter.gridy = 12;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 1;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.CENTER;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlDexBase = new JLabel("" + pj.getAttributes().getDEX());
		jlDexBase.setForeground(Color.white);
		this.add(jlDexBase, gbcCharacter);

		gbcCharacter.gridy = 12;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 2;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.EAST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		jlDexCurrent = new JLabel("(" + pj.getCurrentAttributes().getDEX() + ")");
		jlDexCurrent.setForeground(Color.GREEN);
		this.add(jlDexCurrent, gbcCharacter);

		// CON
		gbcCharacter.gridy = 13;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.EAST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlConTitle = new JLabel("CON : ");
		jlConTitle.setForeground(Color.white);
		this.add(jlConTitle, gbcCharacter);

		gbcCharacter.gridy = 13;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 1;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.CENTER;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlConBase = new JLabel("" + pj.getAttributes().getCON());
		jlConBase.setForeground(Color.white);
		this.add(jlConBase, gbcCharacter);

		gbcCharacter.gridy = 13;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 2;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.EAST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		jlConCurrent = new JLabel("(" + pj.getCurrentAttributes().getCON() + ")");
		jlConCurrent.setForeground(Color.GREEN);
		this.add(jlConCurrent, gbcCharacter);

		// INT
		gbcCharacter.gridy = 14;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.EAST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlIntTitle = new JLabel("INT : ");
		jlIntTitle.setForeground(Color.white);
		this.add(jlIntTitle, gbcCharacter);

		gbcCharacter.gridy = 14;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 1;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.CENTER;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlIntBase = new JLabel("" + pj.getAttributes().getINT());
		jlIntBase.setForeground(Color.white);
		this.add(jlIntBase, gbcCharacter);

		gbcCharacter.gridy = 14;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 2;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.EAST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		jlIntCurrent = new JLabel("(" + pj.getCurrentAttributes().getINT() + ")");
		jlIntCurrent.setForeground(Color.GREEN);
		this.add(jlIntCurrent, gbcCharacter);

		// CHA
		gbcCharacter.gridy = 15;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.EAST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlChaTitle = new JLabel("CHA : ");
		jlChaTitle.setForeground(Color.white);
		this.add(jlChaTitle, gbcCharacter);

		gbcCharacter.gridy = 15;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 1;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.CENTER;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlChaBase = new JLabel("" + pj.getAttributes().getCHA());
		jlChaBase.setForeground(Color.white);
		this.add(jlChaBase, gbcCharacter);

		gbcCharacter.gridy = 15;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 2;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.EAST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		jlChaCurrent = new JLabel("(" + pj.getCurrentAttributes().getCHA() + ")");
		jlChaCurrent.setForeground(Color.GREEN);
		this.add(jlChaCurrent, gbcCharacter);

		pj.addPropertyChangeListener(Character.PROPERTY_CURRENT_ATTRIBUTES, new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getSource() instanceof Player) {
					Player pj = (Player) evt.getSource();
					jlForCurrent.setText("(" + pj.getCurrentAttributes().getFOR() + ")");
					jlDexCurrent.setText("(" + pj.getCurrentAttributes().getDEX() + ")");
					jlConCurrent.setText("(" + pj.getCurrentAttributes().getCON() + ")");
					jlIntCurrent.setText("(" + pj.getCurrentAttributes().getINT() + ")");
					jlChaCurrent.setText("(" + pj.getCurrentAttributes().getCHA() + ")");
				}
			}
		});

		// Gold
		gbcCharacter.gridy = 16;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		final JLabel jlGold = new JLabel("Or restant : " + pj.getInventory().getGold());
		jlGold.setForeground(Color.yellow);
		this.add(jlGold, gbcCharacter);
		pj.getInventory().addPropertyChangeListener(Inventory.PROPERTY_GOLD, new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getNewValue() instanceof Integer) {
					Integer newValue = (Integer) evt.getNewValue();
					jlGold.setText("Or restant : " + newValue);
				}

			}
		});

		// Niveau
		gbcCharacter.gridy = 17;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlLevel = new JLabel("Niveau : " + pj.getXp().getLevel());
		jlLevel.setForeground(Color.magenta);
		this.add(jlLevel, gbcCharacter);

		// Expérience
		gbcCharacter.gridy = 18;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 2;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlXpTitle = new JLabel("Expérience : ");
		jlXpTitle.setForeground(Color.magenta);
		this.add(jlXpTitle, gbcCharacter);

		gbcCharacter.gridy = 18;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 2;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.EAST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		final JLabel jlXp = new JLabel("" + pj.getXp().getXp());
		jlXp.setForeground(Color.magenta);
		this.add(jlXp, gbcCharacter);

		// Expérience
		gbcCharacter.gridy = 19;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.HORIZONTAL;
		final JProgressBar xpBar = new JProgressBar();
		xpBar.setMaximum(pj.getXp().getCurrentStepLevel()); // TODO Changement
															// de niveau
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
