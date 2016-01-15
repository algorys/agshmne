package io.github.algorys.agshmne.inventory;

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

import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.design.InvRenderer;
import io.github.algorys.agshmne.tile.Tile;
import io.github.algorys.agshmne.tile.TileListModel;

public class GroundInv extends JPanel implements Observer {
	private JList<InventoryItem> groundItem;
	private Tile currentTile;
	private Character pj;

	public GroundInv(Character pj) {
		this.pj = pj;
		pj.addObserver(this);
				
		groundItem = new JList<InventoryItem>(new TileListModel(pj.getRegion().getTileFromPosition(pj.getPosition())));
		groundItem.setCellRenderer(new InvRenderer());
		groundItem.setBackground(Color.BLACK);
		groundItem.setForeground(Color.green);
		groundItem.setVisibleRowCount(10);
		groundItem.setPreferredSize(new Dimension(400, 300));
		groundItem.setEnabled(true);

		this.add(groundItem);

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
							GroundInv.this.pj.getInventory().addItem(selectedItem);
							System.out.println("Objets " + selectedItem + "Ajouté");
							System.out.println(GroundInv.this.pj.getInventory());
						}
					});
					JMenuItem laisser = new JMenuItem("Laisser");
					menu.add(ramasser);
					menu.add(laisser);
					menu.show(groundItem, me.getX(), me.getY());
				}
			}
		});
		this.setFocusable(false);

	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("On passe par la liste groundItem");
		if(this.currentTile != null) {
			currentTile.deleteObserver(this);
		}
		this.currentTile = pj.getRegion().getTileFromPosition(pj.getPosition());
		groundItem.setModel(new TileListModel(this.currentTile));
		
		this.currentTile.addObserver(this);
	}
}
