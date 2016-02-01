package io.github.algorys.agshmne.game.center;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.design.InvRenderer;
import io.github.algorys.agshmne.items.Inventory;
import io.github.algorys.agshmne.items.Item;
import io.github.algorys.agshmne.items.equipable.IEquipableItem;

@SuppressWarnings("serial")
public class JTabInv extends JPanel {
	private Inventory inv;
	private Player pj;
	private JList<Item> invItems;

	public JTabInv(Player pj) {
		this.pj = pj;
		this.inv = pj.getInventory();
		// Jlist items
		invItems = new JList<Item>(new InventoryListModel(pj.getInventory()));
		invItems.setCellRenderer(new InvRenderer());
		invItems.setBackground(Color.BLACK);
		invItems.setForeground(Color.green);
		invItems.setFixedCellWidth(290);
		invItems.setFixedCellHeight(15);
		invItems.setVisibleRowCount(10);
		invItems.setPreferredSize(new Dimension(400, 300));
		invItems.setEnabled(true);

		this.add(invItems);

		invItems.addMouseListener(new MouseAdapter() {
			public void mousePressed(final MouseEvent me) {
				if (me.isPopupTrigger()) {
					final int index = invItems.locationToIndex(me.getPoint());
					JPopupMenu menu = new JPopupMenu();

					JMenuItem deposer = new JMenuItem("Déposer");
					deposer.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Item selectedItem = invItems.getModel().getElementAt(index);
							if(selectedItem instanceof IEquipableItem) {
								IEquipableItem itemToGround = (IEquipableItem) selectedItem;
								if(itemToGround.isEquipped()){
									JOptionPane.showMessageDialog(JTabInv.this,
											"Vous devez d'abord déséquipper " + itemToGround);
								} else {
									inv.removeItem(selectedItem);
									JTabInv.this.pj.getTile().addItem(selectedItem);
								}
							} else {
								inv.removeItem(selectedItem);
								JTabInv.this.pj.getTile().addItem(selectedItem);
							}
						}
					});
					menu.add(deposer);

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
										JTabInv.this.pj.unequip(itemToUnequip);
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
										JTabInv.this.pj.equip(itemToEquip);
										invItems.invalidate();
										invItems.repaint();
									}
								}
							});
						}
						menu.add(equip);
					}

					menu.show(invItems, me.getX(), me.getY());
				}
			}
		});

	}

}
