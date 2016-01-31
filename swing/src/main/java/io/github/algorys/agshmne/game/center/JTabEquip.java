package io.github.algorys.agshmne.game.center;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.items.BodyPart;
import io.github.algorys.agshmne.items.EquipableItem;
import io.github.algorys.agshmne.tile.JTile;

@SuppressWarnings("serial")
public class JTabEquip extends JPanel {
	List<EquipableItem> equipment;
	JLabel jlHead;
	JLabel jlChest;
	JLabel jlArms;
	JLabel jlLegs;
	JLabel jlRightHand;
	JLabel jlLeftHand;

	public JTabEquip(Player pj) {
		this.equipment = pj.getInventory().getEquipment();

		this.setLayout(new GridBagLayout());
		GridBagConstraints gbcEquip = new GridBagConstraints();
		gbcEquip.insets = new Insets(5, 5, 5, 5);

		// TITRE
		gbcEquip.gridy = 0;
		gbcEquip.gridheight = 1;
		gbcEquip.gridx = 0;
		gbcEquip.gridwidth = 4;
		gbcEquip.anchor = GridBagConstraints.CENTER;
		gbcEquip.fill = GridBagConstraints.NONE;
		this.add(new JLabel("ÉQUIPEMENT"), gbcEquip);

		// Tete
		gbcEquip.gridy = 1;
		gbcEquip.gridheight = 1;
		gbcEquip.gridx = 0;
		gbcEquip.gridwidth = 4;
		gbcEquip.anchor = GridBagConstraints.CENTER;
		gbcEquip.fill = GridBagConstraints.NONE;
		jlHead = new JLabel("Tête : " + this.getEquipFromPart(BodyPart.HEAD));
		this.add(jlHead, gbcEquip);

		// Torse
		gbcEquip.gridy = 2;
		gbcEquip.gridheight = 1;
		gbcEquip.gridx = 0;
		gbcEquip.gridwidth = 4;
		gbcEquip.anchor = GridBagConstraints.CENTER;
		gbcEquip.fill = GridBagConstraints.NONE;
		jlChest = new JLabel("Torse : " + this.getEquipFromPart(BodyPart.CHEST));
		this.add(jlChest, gbcEquip);

		// Bras
		gbcEquip.gridy = 3;
		gbcEquip.gridheight = 1;
		gbcEquip.gridx = 0;
		gbcEquip.gridwidth = 4;
		gbcEquip.anchor = GridBagConstraints.CENTER;
		gbcEquip.fill = GridBagConstraints.NONE;
		jlArms = new JLabel("Bras : " + this.getEquipFromPart(BodyPart.ARMS));
		this.add(jlArms, gbcEquip);

		// Jambes
		gbcEquip.gridy = 4;
		gbcEquip.gridheight = 1;
		gbcEquip.gridx = 0;
		gbcEquip.gridwidth = 4;
		gbcEquip.anchor = GridBagConstraints.CENTER;
		gbcEquip.fill = GridBagConstraints.NONE;
		jlLegs = new JLabel("Jambes : " + this.getEquipFromPart(BodyPart.LEGS));
		this.add(jlLegs, gbcEquip);

		// Main Droite
		gbcEquip.gridy = 5;
		gbcEquip.gridheight = 1;
		gbcEquip.gridx = 0;
		gbcEquip.gridwidth = 4;
		gbcEquip.anchor = GridBagConstraints.CENTER;
		gbcEquip.fill = GridBagConstraints.NONE;
		jlRightHand = new JLabel("Main Droite : " + this.getEquipFromPart(BodyPart.RIGHT_HAND));
		this.add(jlRightHand, gbcEquip);

		// Main Gauche
		gbcEquip.gridy = 6;
		gbcEquip.gridheight = 1;
		gbcEquip.gridx = 0;
		gbcEquip.gridwidth = 4;
		gbcEquip.anchor = GridBagConstraints.CENTER;
		gbcEquip.fill = GridBagConstraints.NONE;
		jlLeftHand = new JLabel("Main Gauche : " + this.getEquipFromPart(BodyPart.LEFT_HAND));
		this.add(jlLeftHand, gbcEquip);

		pj.addPropertyChangeListener(Character.PROPERTY_CURRENT_ATTRIBUTES, new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getSource() instanceof Player) {
					Player pj = (Player) evt.getSource();
					equipment = pj.getInventory().getEquipment();
					jlHead.setText("Tête : " + JTabEquip.this.getEquipFromPart(BodyPart.HEAD));
					jlChest.setText("Torse : " + JTabEquip.this.getEquipFromPart(BodyPart.CHEST));
					jlArms.setText("Bras : " + JTabEquip.this.getEquipFromPart(BodyPart.ARMS));
					jlLegs.setText("Jambes : " + JTabEquip.this.getEquipFromPart(BodyPart.LEGS));
					jlRightHand.setText("Main Droite : " + JTabEquip.this.getEquipFromPart(BodyPart.RIGHT_HAND));
					jlLeftHand.setText("Main Gauche : " + JTabEquip.this.getEquipFromPart(BodyPart.LEFT_HAND));
				}

			}
		});
	}

	public EquipableItem getEquipFromPart(BodyPart part) {
		EquipableItem itemSearch = null;
		for (EquipableItem itemEquip : equipment) {
			if (itemEquip.getPart() == part) {
				itemSearch = itemEquip;
			}
		}
		return itemSearch;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			Image img = ImageIO.read(JTile.class.getClassLoader().getResource("parchemin.png"));
			Image imgBack = ImageIO.read(JTile.class.getClassLoader().getResource("table.png"));
			g.drawImage(imgBack, 0, 0, this.getWidth(), this.getHeight(), this);
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
