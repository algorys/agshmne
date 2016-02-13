package io.github.algorys.agshmne.game.character.inventory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import io.github.algorys.agshmne.PopupTriggerAdapter;
import io.github.algorys.agshmne.character.Attribute;
import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.design.InvRenderer;
import io.github.algorys.agshmne.items.Inventory;
import io.github.algorys.agshmne.items.Item;
import io.github.algorys.agshmne.items.equipable.IEquipableItem;

@SuppressWarnings("serial")
public class JPanInventory extends JPanel {
	private Inventory inv;
	private Player pj;
	private JList<Item> invItems;

	public JPanInventory(Player pj) {
		this.pj = pj;
		this.inv = pj.getInventory();
		// Jlist items
		invItems = new JList<Item>(new InventoryListModel(pj.getInventory()));
		invItems.setCellRenderer(new InvRenderer());
		invItems.setBackground(Color.BLACK);
		invItems.setForeground(Color.green);
		invItems.setFixedCellWidth(290);
		invItems.setFixedCellHeight(30);
		invItems.setVisibleRowCount(20);
		invItems.setPreferredSize(new Dimension(600, 600));
		invItems.setEnabled(true);

		this.add(invItems);

		invItems.addMouseListener(new PopupTriggerAdapter() {
			@Override
			public void popupTrigger(MouseEvent me) {
				final int index = invItems.locationToIndex(me.getPoint());
				JPopupMenu menu = new JPopupMenu();
				JMenuItem info = new JMenuItem("Examiner");
				info.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Item selectedItem = invItems.getModel().getElementAt(index);
						if (selectedItem instanceof IEquipableItem) {
							IEquipableItem equip = (IEquipableItem) selectedItem;
							String bonus = getStringAttribute(equip.getAttribute());
							JOptionPane.showMessageDialog(JPanInventory.this,
									"<html><body>Nom " + equip.getName() + "<br>Bonus : " + bonus + "</body></html>");
						} else {
							JOptionPane.showMessageDialog(JPanInventory.this,
									"<html><body>Nom " + selectedItem.getName());
						}
					}
				});
				menu.add(info);

				if (invItems.getModel().getElementAt(index) instanceof IEquipableItem) {
					IEquipableItem current = (IEquipableItem) invItems.getModel().getElementAt(index);
					final JMenuItem equip;
					if (current.isEquipped()) {
						equip = new JMenuItem("Enlever");
						equip.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								Item selectedItem = invItems.getModel().getElementAt(index);
								if (selectedItem instanceof IEquipableItem) {
									IEquipableItem itemToUnequip = (IEquipableItem) selectedItem;
									JPanInventory.this.pj.unequip(itemToUnequip);
									invItems.invalidate();
									invItems.repaint();
								}
							}
						});
					} else {
						equip = new JMenuItem("Équiper");
						equip.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								Item selectedItem = invItems.getModel().getElementAt(index);
								if (selectedItem instanceof IEquipableItem) {
									IEquipableItem itemToEquip = (IEquipableItem) selectedItem;
									JPanInventory.this.pj.equip(itemToEquip);
									invItems.invalidate();
									invItems.repaint();
								}
							}
						});
					}
					menu.add(equip);
				}

				JMenuItem deposer = new JMenuItem("Déposer");
				deposer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Item selectedItem = invItems.getModel().getElementAt(index);
						if (selectedItem instanceof IEquipableItem) {
							IEquipableItem itemToGround = (IEquipableItem) selectedItem;
							if (itemToGround.isEquipped()) {
								JOptionPane.showMessageDialog(JPanInventory.this,
										"Vous devez d'abord déséquipper " + itemToGround);
							} else {
								inv.removeItem(selectedItem);
								JPanInventory.this.pj.getTile().addItem(selectedItem);
							}
						} else {
							inv.removeItem(selectedItem);
							JPanInventory.this.pj.getTile().addItem(selectedItem);
						}
					}
				});
				menu.add(deposer);

				menu.show(invItems, me.getX(), me.getY());

			}
		});

	}

	public String getStringAttribute(Attribute equip) {
		int FOR = equip.getFOR();
		int DEX = equip.getDEX();
		int CON = equip.getCON();
		int INT = equip.getINT();
		int CHA = equip.getCHA();
		StringBuffer sb = new StringBuffer();
		sb.append(" (");
		if (FOR != 0) {
			sb.append(" For : ");
			sb.append(FOR);
		}
		if (DEX != 0) {
			sb.append(" Dex : ");
			sb.append(DEX);
		}
		if (CON != 0) {
			sb.append(" Con : ");
			sb.append(CON);
		}
		if (INT != 0) {
			sb.append(" Int : ");
			sb.append(INT);
		}
		if (CHA != 0) {
			sb.append(" Cha : ");
			sb.append(CHA);
		}
		sb.append(" )");
		return sb.toString();

	}

}
