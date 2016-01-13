package io.github.algorys.agshmne.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.inventory.Inventory;
import io.github.algorys.agshmne.inventory.InventoryItem;
import io.github.algorys.agshmne.inventory.InventoryListModel;

public class JTabInv extends JPanel implements Observer {
	private Inventory inv;
	private Character pj;
	JList<InventoryItem> invItems;
	
	public JTabInv(Character pj) {
		this.pj = pj;
		this.inv = pj.getInventory();
		inv.addObserver(this);
		
		// Jlist items
		invItems = new JList<InventoryItem>(new InventoryListModel(pj.getInventory()));
		//invItems.setCellRenderer(new InvRenderer());
		invItems.setBackground(Color.BLACK);
		invItems.setForeground(Color.green);
		invItems.setVisibleRowCount(10);
		//invItems.setFixedCellHeight(15);
		invItems.setFixedCellWidth(290);
		invItems.setPreferredSize(new Dimension(400, 15));
		invItems.setEnabled(true);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().add(invItems);

		this.add(invItems);

		invItems.addMouseListener(new MouseAdapter() {
			public void mousePressed(final MouseEvent me) {
				if (me.isPopupTrigger()) {
					final int index = invItems.locationToIndex(me.getPoint());
					JPopupMenu menu = new JPopupMenu();
					JMenuItem ramasser = new JMenuItem("Ramasser");
					ramasser.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							InventoryItem selectedItem = invItems.getModel().getElementAt(index);
							JOptionPane.showMessageDialog(JTabInv.this, "" + selectedItem + " ajouté(e) !");
							((InventoryListModel) invItems.getModel()).removeElementAt(index);
							inv.addItem(selectedItem);
							System.out.println("Objets " + selectedItem + "Ajouté");
							System.out.println(inv);
						}
					});
					JMenuItem laisser = new JMenuItem("Laisser");
					menu.add(ramasser);
					menu.add(laisser);
					menu.show(invItems, me.getX(), me.getY());
				}
			}
		});

	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("On passe par l'inventaire");
		invItems.setModel(new InventoryListModel(pj.getInventory()));
	}
		
	
}
