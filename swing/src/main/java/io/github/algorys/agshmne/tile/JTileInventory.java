package io.github.algorys.agshmne.tile;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import io.github.algorys.agshmne.PopupTriggerAdapter;
import io.github.algorys.agshmne.character.Attribute;
import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.items.Item;
import io.github.algorys.agshmne.items.equipable.IEquipableItem;
import io.github.algorys.agshmne.map.tile.Tile;
import io.github.algorys.agshmne.renderer.InvRenderer;

@SuppressWarnings("serial")
public class JTileInventory extends JPanel {
	private JList<Item> groundItem;
	private Tile currentTile;
	private PropertyChangeListener tileListener = new PropertyChangeListener() {
		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			updateGroundItemModel();
		}
	};

	public JTileInventory(final Player pj) {
		pj.addPropertyChangeListener(Player.PROPERTY_TILE, new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getNewValue() instanceof Tile) {
					setTile((Tile) evt.getNewValue());
				}
			}
		});

		groundItem = new JList<Item>(new TileListModel(pj.getTile()));
		groundItem.setCellRenderer(new InvRenderer());
		groundItem.setBackground(Color.BLACK);
		groundItem.setForeground(Color.green);
		groundItem.setVisibleRowCount(10);
		groundItem.setPreferredSize(new Dimension(300, 300));
		groundItem.setMinimumSize(new Dimension(300, 300));
		groundItem.setEnabled(true);
		this.currentTile = pj.getTile();
		this.currentTile.addPropertyChangeListener(tileListener);

		this.add(groundItem);

		groundItem.addMouseListener(new PopupTriggerAdapter() {
			@Override
			public void popupTrigger(MouseEvent me) {
				final int index = groundItem.locationToIndex(me.getPoint());
				JPopupMenu menu = new JPopupMenu();
				JMenuItem ramasser = new JMenuItem("Ramasser");
				ramasser.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Item selectedItem = groundItem.getModel().getElementAt(index);
						// JOptionPane.showMessageDialog(JTileInventory.this, ""
						// + selectedItem + " ajouté(e) !");
						((TileListModel) groundItem.getModel()).removeElementAt(index);
						pj.getInventory().addItem(selectedItem);
						groundItem.invalidate();
						groundItem.repaint();
					}
				});
				JMenuItem info = new JMenuItem("Examiner");
				info.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Item selectedItem = groundItem.getModel().getElementAt(index);
						if (selectedItem instanceof IEquipableItem) {
							IEquipableItem equip = (IEquipableItem) selectedItem;
							String bonus = getStringAttribute(equip.getAttribute());
							JOptionPane.showMessageDialog(JTileInventory.this,
									"<html><body>Nom " + equip.getName() + "<br>Bonus : " + bonus + "</body></html>");
						} else {
							JOptionPane.showMessageDialog(JTileInventory.this,
									"<html><body>Nom " + selectedItem.getName());
						}
					}
				});
				menu.add(info);
				JMenuItem laisser = new JMenuItem("Laisser");
				menu.add(ramasser);
				menu.add(laisser);
				menu.show(groundItem, me.getX(), me.getY());
			}
		});
		this.setFocusable(false);

	}

	public void setTile(Tile newTile) {
		if (this.currentTile != null) {
			currentTile.removePropertyChangeListener(tileListener);
		}
		this.currentTile = newTile;
		updateGroundItemModel();

		this.currentTile.addPropertyChangeListener(tileListener);
	}

	private void updateGroundItemModel() {
		groundItem.setModel(new TileListModel(this.currentTile));
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
