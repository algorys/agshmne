package io.github.algorys.agshmne.inventory;

import java.awt.Color;
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
import io.github.algorys.agshmne.design.InvRenderer;
import io.github.algorys.agshmne.tile.Tile;
import io.github.algorys.agshmne.tile.TileListModel;

public class GroundInv extends JPanel implements Observer {
	InventoryGroungTest inv;
	JList<InventoryItem> groundItem;
	Character pj;

	public GroundInv(Character pj) {
		this.pj = pj;
		pj.addObserver(this);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(groundItem);
		
		//Tile tile = 
		/*Tile t = new Tile(TileType.Swamp);
		t.addItem(new Apple());
		t.addItem(new Orange());
		t.addItem(new WeakAxe());
		t.addItem(new WeakSword());*/
		
		groundItem = new JList<InventoryItem>(new TileListModel(pj.getRegion().getTileFromPosition(pj.getPosition())));
		// TODO ! Ne fonctionne pas
		groundItem.setCellRenderer(new InvRenderer());
		groundItem.setBackground(Color.BLACK);
		groundItem.setForeground(Color.green); // SetEnabled False désactive les
												// couleurs
		groundItem.setFixedCellWidth(290);
		groundItem.setEnabled(true);

		this.add(groundItem);

		final Inventory inv = new Inventory();
		groundItem.addMouseListener(new MouseAdapter() {
			public void mousePressed(final MouseEvent me) {
				if (me.isPopupTrigger()) {
					final int index = groundItem.locationToIndex(me.getPoint());
					JPopupMenu menu = new JPopupMenu();
					JMenuItem ramasser = new JMenuItem("Ramasser");
					ramasser.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							InventoryItem selectedItem = groundItem.getModel().getElementAt(index);
							JOptionPane.showMessageDialog(GroundInv.this, "" + selectedItem + " ajouté(e) !");
							((TileListModel) groundItem.getModel()).removeElementAt(index);
							inv.addItem(selectedItem);
							System.out.println("Objets " + selectedItem + "Ajouté");
							System.out.println(inv);
						}
					});
					JMenuItem laisser = new JMenuItem("Laisser");
					menu.add(ramasser);
					menu.add(laisser);
					menu.show(groundItem, me.getX(), me.getY());
				}
			}
		});

	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("On passe par la liste groundItem");
		groundItem.setModel(new TileListModel(pj.getRegion().getTileFromPosition(pj.getPosition())));
		//groundItem.setModel(new TileListModel(tile));
	}
}
