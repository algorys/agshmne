package io.github.algorys.agshmne.game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.design.InvRenderer;
import io.github.algorys.agshmne.inventory.Inventory;
import io.github.algorys.agshmne.inventory.InventoryItem;
import io.github.algorys.agshmne.inventory.InventoryListModel;
import io.github.algorys.agshmne.tile.Tile;

public class JTabInv extends JPanel {
	private Inventory inv;
	private Character pj;
	private JList<InventoryItem> invItems;
	
	public JTabInv(Character pj) {
		this.pj = pj;
		this.inv = pj.getInventory();
		// Jlist items
		invItems = new JList<InventoryItem>(new InventoryListModel(pj.getInventory()));
		invItems.setCellRenderer(new InvRenderer());
		invItems.setBackground(Color.BLACK);
		invItems.setForeground(Color.green);
		invItems.setFixedCellWidth(290);
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
							InventoryItem selectedItem = invItems.getModel().getElementAt(index);
							JOptionPane.showMessageDialog(JTabInv.this, "" + selectedItem + " retiré(e) !");
							((InventoryListModel) invItems.getModel()).removeElementAt(index);
							inv.removeItem((InventoryItem) selectedItem);;
							System.out.println("Objets " + selectedItem + "Ajouté");
							System.out.println(inv);
							Tile tile = JTabInv.this.pj.getRegion().getTileFromPosition(JTabInv.this.pj.getPosition());
							tile.addItem(selectedItem);
							System.out.println("Objets courants : " + tile.getItems());
							
						}
					});
					JMenuItem utiliser = new JMenuItem("Utiliser");
					menu.add(deposer);
					menu.add(utiliser);
					menu.show(invItems, me.getX(), me.getY());
				}
			}
		});

	}
	
}
