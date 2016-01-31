package io.github.algorys.agshmne.game.center;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import io.github.algorys.agshmne.items.BodyPart;
import io.github.algorys.agshmne.items.EquipableItem;
import io.github.algorys.agshmne.tile.JTile;

@SuppressWarnings("serial")
public class JTabEquip extends JPanel {
	List<EquipableItem> list;

	public JTabEquip(List<EquipableItem> list) {
		this.list = list;

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
		this.add(new JLabel("Tête : " + this.getEquipFromPart(BodyPart.HEAD)), gbcEquip);

		// Torse
		gbcEquip.gridy = 2;
		gbcEquip.gridheight = 1;
		gbcEquip.gridx = 0;
		gbcEquip.gridwidth = 4;
		gbcEquip.anchor = GridBagConstraints.CENTER;
		gbcEquip.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Torse : " + this.getEquipFromPart(BodyPart.CHEST)), gbcEquip);

		// Bras
		gbcEquip.gridy = 3;
		gbcEquip.gridheight = 1;
		gbcEquip.gridx = 0;
		gbcEquip.gridwidth = 4;
		gbcEquip.anchor = GridBagConstraints.CENTER;
		gbcEquip.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Bras : " + this.getEquipFromPart(BodyPart.ARMS)), gbcEquip);

		// Jambes
		gbcEquip.gridy = 4;
		gbcEquip.gridheight = 1;
		gbcEquip.gridx = 0;
		gbcEquip.gridwidth = 4;
		gbcEquip.anchor = GridBagConstraints.CENTER;
		gbcEquip.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Jambes : " + this.getEquipFromPart(BodyPart.LEGS)), gbcEquip);

		// Main Droite
		gbcEquip.gridy = 5;
		gbcEquip.gridheight = 1;
		gbcEquip.gridx = 0;
		gbcEquip.gridwidth = 4;
		gbcEquip.anchor = GridBagConstraints.CENTER;
		gbcEquip.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Main Droite : " + this.getEquipFromPart(BodyPart.RIGHT_HAND)), gbcEquip);

		// Main Gauche
		gbcEquip.gridy = 6;
		gbcEquip.gridheight = 1;
		gbcEquip.gridx = 0;
		gbcEquip.gridwidth = 4;
		gbcEquip.anchor = GridBagConstraints.CENTER;
		gbcEquip.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Main Gauche : " + this.getEquipFromPart(BodyPart.LEFT_HAND)), gbcEquip);

	}

	private EquipableItem getEquipFromPart(BodyPart part) {
		EquipableItem itemSearch = null;
		for (EquipableItem itemEquip : list) {
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
