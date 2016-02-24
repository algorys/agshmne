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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import io.github.algorys.agshmne.character.Vital;
import io.github.algorys.agshmne.game.character.design.ProgressBarUI;

@SuppressWarnings("serial")
public class JPlayerVital extends JPanel {
	public JPlayerVital(final Vital vital) {
		super(new GridBagLayout());
		this.setOpaque(false);
		GridBagConstraints gbcCharacter = new GridBagConstraints();
		gbcCharacter.insets = new Insets(0, 5, 5, 5);
		
		// LIFE
		gbcCharacter.gridy = 0;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlLifeIcon = new JLabel();
		try {
			Image imgLife = ImageIO.read(JPlayerVital.class.getClassLoader().getResource("life.png"));
			jlLifeIcon.setIcon(new ImageIcon(imgLife));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.add(jlLifeIcon, gbcCharacter);

		gbcCharacter.gridy = 0;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 2;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlLifeTitle = new JLabel("Vie");
		jlLifeTitle.setForeground(Color.white);
		this.add(jlLifeTitle, gbcCharacter);

		final JLabel jlLife = new JLabel("" + vital.getLife());
		jlLife.setForeground(Color.yellow);
		JLabel jlLifeMax = new JLabel("/ " + vital.getMaxLife());
		jlLifeMax.setForeground(Color.white);

		gbcCharacter.gridy = 1;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.EAST;
		gbcCharacter.fill = GridBagConstraints.HORIZONTAL;
		final JProgressBar jpLife = new JProgressBar();
		jpLife.setMaximum(vital.getMaxLife());
		jpLife.setForeground(Color.red);
		jpLife.setBackground(Color.BLACK);
		jpLife.setValue(vital.getLife());
		jpLife.setUI(new ProgressBarUI());
		
		vital.addPropertyChangeListener(Vital.PROPERTY_LIFE, new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getNewValue() instanceof Integer) {
					jlLife.setText(evt.getNewValue().toString());
					jpLife.setValue((Integer)evt.getNewValue());
				}
			}
		});
		// LayeredPane pour Life
		JLayeredPane layerLife = layerProgressBar(jpLife, jlLife, jlLifeMax);
		this.add(layerLife, gbcCharacter);
		
		// MANA
		gbcCharacter.gridy = 2;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlManaIcon = new JLabel();
		try {
			Image imgMana = ImageIO.read(JPlayerVital.class.getClassLoader().getResource("mana.png"));
			jlManaIcon.setIcon(new ImageIcon(imgMana));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.add(jlManaIcon, gbcCharacter);
		
		gbcCharacter.gridy = 2;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 2;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlManaTitle = new JLabel("Mana");
		jlManaTitle.setForeground(Color.white);
		this.add(jlManaTitle, gbcCharacter);

		final JLabel jlMana = new JLabel("" + vital.getMana());
		jlMana.setForeground(Color.yellow);
		JLabel jlManaMax = new JLabel("/ " + vital.getMaxMana());
		jlManaMax.setForeground(Color.white);
		
		gbcCharacter.gridy = 3;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.CENTER;
		gbcCharacter.fill = GridBagConstraints.HORIZONTAL;
		final JProgressBar jpMana = new JProgressBar();
		jpMana.setMaximum(vital.getMaxMana());
		jpMana.setForeground(new Color(51, 51, 255));
		jpMana.setBackground(Color.BLACK);
		jpMana.setValue(vital.getMana());
		jpMana.setUI(new ProgressBarUI());
		
		vital.addPropertyChangeListener(Vital.PROPERTY_MANA, new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				jlMana.setText(evt.getNewValue().toString());
				jpMana.setValue((Integer)evt.getNewValue());
			}
		});
		
		JLayeredPane layerMana = layerProgressBar(jpMana, jlMana, jlManaMax);
		this.add(layerMana, gbcCharacter);

		// Faim
		gbcCharacter.gridy = 4;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlHungryIcon = new JLabel();
		try {
			Image imgFood = ImageIO.read(JPlayerVital.class.getClassLoader().getResource("meat.png"));
			jlHungryIcon.setIcon(new ImageIcon(imgFood));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.add(jlHungryIcon, gbcCharacter);

		gbcCharacter.gridy = 4;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 1;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlHungryTitle = new JLabel("Faim : ");
		jlHungryTitle.setForeground(Color.white);
		this.add(jlHungryTitle, gbcCharacter);

		gbcCharacter.gridy = 4;
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
				int newValue = (Integer) evt.getNewValue();
				updateColorVital(newValue, vital.getMaxHunger(), jlHungry);
			}
		});
		
		gbcCharacter.gridy = 4;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 3;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.EAST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlHungryMax = new JLabel("/ " + vital.getMaxHunger());
		jlHungryMax.setForeground(Color.blue);
		this.add(jlHungryMax, gbcCharacter);

		// Fatigue
		gbcCharacter.gridy = 6;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlTiredIcon = new JLabel();
		try {
			Image imgTired = ImageIO.read(JPlayerVital.class.getClassLoader().getResource("tired.png"));
			jlTiredIcon.setIcon(new ImageIcon(imgTired));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.add(jlTiredIcon, gbcCharacter);

		gbcCharacter.gridy = 6;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 1;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlTiredTitle = new JLabel("Fatigue : ");
		jlTiredTitle.setForeground(Color.white);
		this.add(jlTiredTitle, gbcCharacter);

		gbcCharacter.gridy = 6;
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
				int newValue = (Integer) evt.getNewValue();
				updateColorVital(newValue, vital.getMaxFatigue(), jlTired);
			}
		});
		
		gbcCharacter.gridy = 6;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 3;
		gbcCharacter.gridwidth = 1;
		gbcCharacter.anchor = GridBagConstraints.EAST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlTiredMax = new JLabel("/ " + vital.getMaxFatigue());
		jlTiredMax.setForeground(Color.blue);
		this.add(jlTiredMax, gbcCharacter);
	}
	
	private void updateColorVital(int newValue, int maxValue, JLabel label) {
		int critical = maxValue - (maxValue / 4);
		if(newValue < (maxValue / 2)) {
			label.setForeground(Color.white);
		}
		if(newValue > (maxValue / 2)) {
			label.setForeground(Color.yellow);
		} 
		if (newValue > critical){
			label.setForeground(Color.red);
		}
	}
	
	private JLayeredPane layerProgressBar(JProgressBar prBar, JLabel current, JLabel max){
		JLayeredPane layer = new JLayeredPane();
		layer.add(prBar, new Integer(1));
		prBar.setBounds(0, 0, 200, 25);
		layer.setSize(200, 25);
		layer.setPreferredSize(new Dimension(200, 25));
		layer.setOpaque(false);
		JPanel progressText = new JPanel();
		progressText.setOpaque(false);
		progressText.add(current);
		progressText.add(max);
		layer.add(progressText, new Integer(2));
		progressText.setBounds(0, 0, 200, 25);
		return layer;
	}
}
