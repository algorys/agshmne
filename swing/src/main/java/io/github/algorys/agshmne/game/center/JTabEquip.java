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

import io.github.algorys.agshmne.character.Attribute;
import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.items.equipable.BodyPart;
import io.github.algorys.agshmne.items.equipable.EquipableItem;
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
	JLabel jlRing;
	JLabel jlNeck;

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
		String strHead = getStringAttribute(JTabEquip.this.getEquipFromPart(BodyPart.HEAD).getAttribute());
		jlHead = new JLabel("Tête : " + this.getEquipFromPart(BodyPart.HEAD) + strHead);
		this.add(jlHead, gbcEquip);

		// Torse
		gbcEquip.gridy = 2;
		gbcEquip.gridheight = 1;
		gbcEquip.gridx = 0;
		gbcEquip.gridwidth = 4;
		gbcEquip.anchor = GridBagConstraints.CENTER;
		gbcEquip.fill = GridBagConstraints.NONE;
		String strChest = getStringAttribute(JTabEquip.this.getEquipFromPart(BodyPart.CHEST).getAttribute());
		jlChest = new JLabel("Torse : " + this.getEquipFromPart(BodyPart.CHEST) + strChest);
		this.add(jlChest, gbcEquip);

		// Bras
		gbcEquip.gridy = 3;
		gbcEquip.gridheight = 1;
		gbcEquip.gridx = 0;
		gbcEquip.gridwidth = 4;
		gbcEquip.anchor = GridBagConstraints.CENTER;
		gbcEquip.fill = GridBagConstraints.NONE;
		String strArms = getStringAttribute(JTabEquip.this.getEquipFromPart(BodyPart.ARMS).getAttribute());
		jlArms = new JLabel("Bras : " + this.getEquipFromPart(BodyPart.ARMS) + strArms);
		this.add(jlArms, gbcEquip);

		// Jambes
		gbcEquip.gridy = 4;
		gbcEquip.gridheight = 1;
		gbcEquip.gridx = 0;
		gbcEquip.gridwidth = 4;
		gbcEquip.anchor = GridBagConstraints.CENTER;
		gbcEquip.fill = GridBagConstraints.NONE;
		String strLegs = getStringAttribute(JTabEquip.this.getEquipFromPart(BodyPart.LEGS).getAttribute());
		jlLegs = new JLabel("Jambes : " + this.getEquipFromPart(BodyPart.LEGS) + strLegs);
		this.add(jlLegs, gbcEquip);

		// Main Droite
		gbcEquip.gridy = 5;
		gbcEquip.gridheight = 1;
		gbcEquip.gridx = 0;
		gbcEquip.gridwidth = 4;
		gbcEquip.anchor = GridBagConstraints.CENTER;
		gbcEquip.fill = GridBagConstraints.NONE;
		String strRightHand = getStringAttribute(JTabEquip.this.getEquipFromPart(BodyPart.RIGHT_HAND).getAttribute());
		jlRightHand = new JLabel("Main Droite : " + this.getEquipFromPart(BodyPart.RIGHT_HAND) + strRightHand);
		this.add(jlRightHand, gbcEquip);

		// Main Gauche
		gbcEquip.gridy = 6;
		gbcEquip.gridheight = 1;
		gbcEquip.gridx = 0;
		gbcEquip.gridwidth = 4;
		gbcEquip.anchor = GridBagConstraints.CENTER;
		gbcEquip.fill = GridBagConstraints.NONE;
		String strLeftHand = getStringAttribute(JTabEquip.this.getEquipFromPart(BodyPart.LEFT_HAND).getAttribute());
		jlLeftHand = new JLabel("Main Gauche : " + this.getEquipFromPart(BodyPart.LEFT_HAND) + strLeftHand);
		this.add(jlLeftHand, gbcEquip);

		// Anneau
		gbcEquip.gridy = 7;
		gbcEquip.gridheight = 1;
		gbcEquip.gridx = 0;
		gbcEquip.gridwidth = 4;
		gbcEquip.anchor = GridBagConstraints.CENTER;
		gbcEquip.fill = GridBagConstraints.NONE;
		String strRing = getStringAttribute(JTabEquip.this.getEquipFromPart(BodyPart.RING).getAttribute());
		jlRing = new JLabel("Anneau : " + this.getEquipFromPart(BodyPart.RING) + strRing);
		this.add(jlRing, gbcEquip);

		// Cou
		gbcEquip.gridy = 8;
		gbcEquip.gridheight = 1;
		gbcEquip.gridx = 0;
		gbcEquip.gridwidth = 4;
		gbcEquip.anchor = GridBagConstraints.CENTER;
		gbcEquip.fill = GridBagConstraints.NONE;
		String strNeck = getStringAttribute(JTabEquip.this.getEquipFromPart(BodyPart.NECKLACE).getAttribute());
		jlNeck = new JLabel("Cou : " + this.getEquipFromPart(BodyPart.NECKLACE) + strNeck);
		this.add(jlNeck, gbcEquip);

		pj.addPropertyChangeListener(Character.PROPERTY_CURRENT_ATTRIBUTES, new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getSource() instanceof Player) {
					Player pj = (Player) evt.getSource();
					equipment = pj.getInventory().getEquipment();

					String strHead = getStringAttribute(JTabEquip.this.getEquipFromPart(BodyPart.HEAD).getAttribute());
					jlHead.setText("Tête : " + JTabEquip.this.getEquipFromPart(BodyPart.HEAD) + strHead);
					String strChest = getStringAttribute(
							JTabEquip.this.getEquipFromPart(BodyPart.CHEST).getAttribute());
					jlChest.setText("Torse : " + JTabEquip.this.getEquipFromPart(BodyPart.CHEST) + strChest);
					String strArms = getStringAttribute(JTabEquip.this.getEquipFromPart(BodyPart.ARMS).getAttribute());
					jlArms.setText("Bras : " + JTabEquip.this.getEquipFromPart(BodyPart.ARMS) + strArms);
					String strLegs = getStringAttribute(JTabEquip.this.getEquipFromPart(BodyPart.LEGS).getAttribute());
					jlLegs.setText("Jambes : " + JTabEquip.this.getEquipFromPart(BodyPart.LEGS) + strLegs);
					String strRightHand = getStringAttribute(
							JTabEquip.this.getEquipFromPart(BodyPart.RIGHT_HAND).getAttribute());
					jlRightHand.setText(
							"Main Droite : " + JTabEquip.this.getEquipFromPart(BodyPart.RIGHT_HAND) + strRightHand);
					String strLeftHand = getStringAttribute(
							JTabEquip.this.getEquipFromPart(BodyPart.LEFT_HAND).getAttribute());
					jlLeftHand.setText(
							"Main Gauche : " + JTabEquip.this.getEquipFromPart(BodyPart.LEFT_HAND) + strLeftHand);
					String strRing = getStringAttribute(JTabEquip.this.getEquipFromPart(BodyPart.RING).getAttribute());
					jlRing.setText("Anneau : " + JTabEquip.this.getEquipFromPart(BodyPart.RING) + strRing);
					String strNeck = getStringAttribute(
							JTabEquip.this.getEquipFromPart(BodyPart.NECKLACE).getAttribute());
					jlNeck.setText("Cou : " + JTabEquip.this.getEquipFromPart(BodyPart.NECKLACE) + strNeck);
				}

			}
		});
	}

	public String getStringAttribute(Attribute equip) {
		int FOR = equip.getFOR();
		int DEX = equip.getDEX();
		int CON = equip.getCON();
		int INT = equip.getINT();
		int CHA = equip.getCHA();
		String strAttrib = "";
		if (FOR != 0) {
			strAttrib += " For : " + FOR + " ";
		}
		if (DEX != 0) {
			strAttrib += " Dex : " + DEX + " ";
		}
		if (CON != 0) {
			strAttrib += " Con : " + CON + " ";
		}
		if (INT != 0) {
			strAttrib += " Int : " + INT + " ";
		}
		if (CHA != 0) {
			strAttrib += " Cha : " + CHA + " ";
		}
		String finalString = " (" + strAttrib + ")";
		return finalString;

	}

	public EquipableItem getEquipFromPart(BodyPart part) {
		EquipableItem itemSearch = new EquipableItem("Rien", null);
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
