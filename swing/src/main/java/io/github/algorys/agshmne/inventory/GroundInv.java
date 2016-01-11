package io.github.algorys.agshmne.inventory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import io.github.algorys.agshmne.items.closeWeapon.WeakAxe;
import io.github.algorys.agshmne.items.closeWeapon.WeakSword;
import io.github.algorys.agshmne.items.fruits.Apple;
import io.github.algorys.agshmne.items.fruits.Orange;
import io.github.algorys.agshmne.tile.Tile;
import io.github.algorys.agshmne.tile.TileListModel;
import io.github.algorys.agshmne.tile.TileType;

public class GroundInv extends JPanel implements ListSelectionListener {
	InventoryGroungTest inv;
	JList<InventoryItem> groundItem;
	JLabel etiquette = new JLabel("");
	
	
	public GroundInv() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(groundItem);
		Tile t = new Tile(TileType.Swamp);
		t.addItem(new Apple());
		t.addItem(new Orange());
		t.addItem(new WeakAxe());
		t.addItem(new WeakSword());
		groundItem = new JList<InventoryItem>(new TileListModel(t));
		groundItem.setEnabled(false);
		
		groundItem.addListSelectionListener(this);
		this.add(groundItem);
		
		final Inventory inv = new Inventory();
		groundItem.addMouseListener(new MouseAdapter() {
	        public void mousePressed(final MouseEvent me) {
	            if (me.isPopupTrigger()) {
	            	final int index = groundItem.locationToIndex(me.getPoint());
	                JPopupMenu menu = new JPopupMenu();
	                JMenuItem item = new JMenuItem("Ajouter Truc");
	                item.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
							InventoryItem selectedItem = groundItem.getModel().getElementAt(index);
							JOptionPane.showMessageDialog(GroundInv.this, ""
	                                + selectedItem + " ajouté!");
							((TileListModel)groundItem.getModel()).removeElementAt(index);
							inv.addItem(selectedItem);
							System.out.println("Objets " + selectedItem + "Ajouté");
							System.out.println(inv);
	                    }
	                });
	                menu.add(item);
	                menu.show(groundItem, me.getX(),me.getY());
	            }
	        }
	    });
		
		
	}


	@Override
	public void valueChanged(ListSelectionEvent e) {
		etiquette.setText(groundItem.getSelectedValue().getName());
		
		
	}
}
