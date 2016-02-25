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
		JLabel jlLifeTitle = new JLabel("Vie");
		jlLifeTitle.setForeground(Color.white);

		final JLabel jlLife = new JLabel("" + vital.getLife());
		jlLife.setForeground(Color.yellow);
		try {
			Image imgLife = ImageIO.read(JPlayerVital.class.getClassLoader().getResource("life.png"));
			Image newImgLife = imgLife.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
			jlLife.setIcon(new ImageIcon(newImgLife));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel jlLifeMax = new JLabel("/ " + vital.getMaxLife());
		jlLifeMax.setForeground(Color.white);

		gbcCharacter.gridy = 1;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.HORIZONTAL;
		final JProgressBar jpLife = vitalProgressBar(vital.getMaxLife(), vital.getLife(), Color.red);
		
		vital.addPropertyChangeListener(Vital.PROPERTY_LIFE, new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getNewValue() instanceof Integer) {
					jlLife.setText(evt.getNewValue().toString());
					jpLife.setValue((Integer)evt.getNewValue());
				}
			}
		});
		
		JLayeredPane layerLife = layerProgressBar(jpLife, jlLifeTitle, jlLife, jlLifeMax);
		this.add(layerLife, gbcCharacter);
		
		// MANA
		gbcCharacter.gridy = 2;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlManaTitle = new JLabel("Mana");
		jlManaTitle.setForeground(Color.white);

		final JLabel jlMana = new JLabel("" + vital.getMana());
		jlMana.setForeground(Color.yellow);
		try {
			Image imgMana = ImageIO.read(JPlayerVital.class.getClassLoader().getResource("mana.png"));
			Image newImgMana = imgMana.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
			jlMana.setIcon(new ImageIcon(newImgMana));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel jlManaMax = new JLabel("/ " + vital.getMaxMana());
		jlManaMax.setForeground(Color.white);
		
		gbcCharacter.gridy = 3;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.HORIZONTAL;
		final JProgressBar jpMana = vitalProgressBar(vital.getMaxMana(), vital.getMana(), new Color(51, 51, 255));
		
		vital.addPropertyChangeListener(Vital.PROPERTY_MANA, new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				jlMana.setText(evt.getNewValue().toString());
				jpMana.setValue((Integer)evt.getNewValue());
			}
		});
		
		JLayeredPane layerMana = layerProgressBar(jpMana, jlManaTitle, jlMana, jlManaMax);
		this.add(layerMana, gbcCharacter);
		
		// FAIM
		gbcCharacter.gridy = 4;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlFaimTitle = new JLabel("Faim");
		jlFaimTitle.setForeground(Color.white);
//		this.add(jlFaimTitle, gbcCharacter);

		final JLabel jlFaim = new JLabel("" + vital.getHunger());
		jlFaim.setForeground(Color.yellow);
		try {
			Image imgFaim = ImageIO.read(JPlayerVital.class.getClassLoader().getResource("meat.png"));
			Image newImgFaim = imgFaim.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
			jlFaim.setIcon(new ImageIcon(newImgFaim));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel jlFaimMax = new JLabel("/ " + vital.getMaxHunger());
		jlFaimMax.setForeground(Color.white);
		
		gbcCharacter.gridy = 5;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.HORIZONTAL;
		final JProgressBar jProgressHunger = vitalProgressBar(vital.getMaxHunger(), vital.getHunger(), Color.yellow);
		
		vital.addPropertyChangeListener(Vital.PROPERTY_HUNGER, new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				jlFaim.setText(evt.getNewValue().toString());
				jProgressHunger.setValue((Integer)evt.getNewValue());
			}
		});
		
		JLayeredPane layerFaim = layerProgressBar(jProgressHunger, jlFaimTitle, jlFaim, jlFaimMax);
		this.add(layerFaim, gbcCharacter);
		
		// FATIGUE
		gbcCharacter.gridy = 6;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.NONE;
		JLabel jlFatigTitle = new JLabel("Fatigue");
		jlFatigTitle.setForeground(Color.white);

		final JLabel jlFatig = new JLabel("" + vital.getFatigue());
		jlFatig.setForeground(Color.yellow);
		try {
			Image imgFatig = ImageIO.read(JPlayerVital.class.getClassLoader().getResource("tired.png"));
			Image newImgFatig = imgFatig.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
			jlFatig.setIcon(new ImageIcon(newImgFatig));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel jlFatigMax = new JLabel("/ " + vital.getMaxFatigue());
		jlFatigMax.setForeground(Color.white);
		
		gbcCharacter.gridy = 7;
		gbcCharacter.gridheight = 1;
		gbcCharacter.gridx = 0;
		gbcCharacter.gridwidth = 4;
		gbcCharacter.anchor = GridBagConstraints.WEST;
		gbcCharacter.fill = GridBagConstraints.HORIZONTAL;
		final JProgressBar jProgressFatig = vitalProgressBar(vital.getMaxFatigue(), vital.getFatigue(), Color.green);
		
		vital.addPropertyChangeListener(Vital.PROPERTY_FATIGUE, new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				jlFatig.setText(evt.getNewValue().toString());
				jProgressFatig.setValue((Integer)evt.getNewValue());
			}
		});
		
		JLayeredPane layerFatig = layerProgressBar(jProgressFatig, jlFatigTitle, jlFatig, jlFatigMax);
		this.add(layerFatig, gbcCharacter);
	}
	
	private JProgressBar vitalProgressBar(int max, int current, Color color) {
		JProgressBar prBar = new JProgressBar();
		prBar.setMaximum(max);
		prBar.setForeground(color);
		prBar.setBackground(Color.BLACK);
		prBar.setValue(current);
		prBar.setUI(new ProgressBarUI());
		return prBar;
	}
	private JLayeredPane layerProgressBar(JProgressBar prBar, JLabel jlLabelTitle, JLabel current, JLabel max){
		JLayeredPane layer = new JLayeredPane();
		layer.add(prBar, new Integer(1));
		prBar.setBounds(0, 0, 190, 35);
		layer.setSize(190, 35);
		layer.setPreferredSize(new Dimension(190, 35));
		layer.setOpaque(false);
		JPanel progressText = new JPanel();
		progressText.setOpaque(false);
		progressText.add(jlLabelTitle);
		progressText.add(current);
		progressText.add(max);
		layer.add(progressText, new Integer(2));
		progressText.setBounds(0, 0, 190, 35);
		return layer;
	}
}
