package io.github.algorys.agshmne.tile;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.design.InvRenderer;
import io.github.algorys.agshmne.items.Item;
import io.github.algorys.agshmne.map.tile.Tile;

@SuppressWarnings("serial")
public class GroundInv extends JPanel implements PropertyChangeListener {
	private JList<Item> groundItem;
	private Tile currentTile;
	private Player pj;

	public GroundInv(Player pj) {
		this.pj = pj;
		pj.addPropertyChangeListener(Player.PROPERTY_POSITION, this);

		groundItem = new JList<Item>(new TileListModel(pj.getTile()));
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
							Item selectedItem = groundItem.getModel().getElementAt(index);
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
	public void propertyChange(PropertyChangeEvent evt) {
		if (this.currentTile != null) {
			currentTile.removePropertyChangeListener(this);
		}
		this.currentTile = pj.getTile();
		groundItem.setModel(new TileListModel(this.currentTile));

		this.currentTile.addPropertyChangeListener(this);
	}
}
