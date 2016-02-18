package io.github.algorys.agshmne.game.character;

import java.awt.Color;
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

import io.github.algorys.agshmne.character.Vital;
import io.github.algorys.agshmne.tile.JTile;

@SuppressWarnings("serial")
public class JPlayerVital extends JPanel {
	public JPlayerVital(Vital vital) {
		super(new GridBagLayout());
		this.setOpaque(false);
		GridBagConstraints gbcCharacter = new GridBagConstraints();
		gbcCharacter.insets = new Insets(5, 5, 5, 5);
		// PdVs
		gbcCharacter.gridy = 0;
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

		gbcCharacter.gridy = 0;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 1;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlLifeTitle = new JLabel("Vie : ");
		jlLifeTitle.setForeground(Color.white);
		this.add(jlLifeTitle, gbcCharacter);

		gbcCharacter.gridy = 0;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 2;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.EAST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		final JLabel jlLife = new JLabel("" + vital.getLife());
		jlLife.setForeground(Color.white);
		this.add(jlLife, gbcCharacter);

		vital.addPropertyChangeListener(Vital.PROPERTY_VIE, new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getNewValue() instanceof Integer) {
					jlLife.setText(evt.getNewValue().toString());
				}
			}
		});
		
		gbcCharacter.gridy = 0;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 3;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.EAST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlLifeMax = new JLabel("/ " + Vital.MAX_LIFE);
		jlLifeMax.setForeground(Color.blue);
		this.add(jlLifeMax, gbcCharacter);

		// Mana
		gbcCharacter.gridy = 1;
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
		gbcCharacter.gridy = 1;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 1;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlManaTitle = new JLabel("Mana : ");
		jlManaTitle.setForeground(Color.white);
		this.add(jlManaTitle, gbcCharacter);

		gbcCharacter.gridy = 1;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 2;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.EAST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		final JLabel jlMana = new JLabel("" + vital.getMana());
		jlMana.setForeground(Color.white);
		this.add(jlMana, gbcCharacter);
		vital.addPropertyChangeListener(Vital.PROPERTY_MANA, new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				jlMana.setText(evt.getNewValue().toString());
			}
		});
		
		gbcCharacter.gridy = 1;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 3;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.EAST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlManaMax = new JLabel("/ " + Vital.MAX_MANA);
		jlManaMax.setForeground(Color.blue);
		this.add(jlManaMax, gbcCharacter);

		// Faim
		gbcCharacter.gridy = 2;
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

		gbcCharacter.gridy = 2;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 1;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlHungryTitle = new JLabel("Faim : ");
		jlHungryTitle.setForeground(Color.white);
		this.add(jlHungryTitle, gbcCharacter);

		gbcCharacter.gridy = 2;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 2;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.EAST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		final JLabel jlHungry = new JLabel("" + vital.getHunger());
		jlHungry.setForeground(Color.white);
		this.add(jlHungry, gbcCharacter);
		vital.addPropertyChangeListener(Vital.PROPERTY_HUNGER, new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				jlHungry.setText(evt.getNewValue().toString());
			}
		});
		
		gbcCharacter.gridy = 2;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 3;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.EAST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlHungryMax = new JLabel("/ " + Vital.MAX_HUNGER);
		jlHungryMax.setForeground(Color.blue);
		this.add(jlHungryMax, gbcCharacter);

		// Fatigue
		gbcCharacter.gridy = 3;
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

		gbcCharacter.gridy = 3;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 1;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlTiredTitle = new JLabel("Fatigue : ");
		jlTiredTitle.setForeground(Color.white);
		this.add(jlTiredTitle, gbcCharacter);

		gbcCharacter.gridy = 3;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 2;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.EAST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		final JLabel jlTired = new JLabel("" + vital.getFatigue());
		jlTired.setForeground(Color.white);
		this.add(jlTired, gbcCharacter);
		vital.addPropertyChangeListener(Vital.PROPERTY_FATIGUE, new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				jlTired.setText(evt.getNewValue().toString());
			}
		});
		
		gbcCharacter.gridy = 3;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 3;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.EAST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlTiredMax = new JLabel("/ " + Vital.MAX_FATIGUE);
		jlTiredMax.setForeground(Color.blue);
		this.add(jlTiredMax, gbcCharacter);
	}
}
