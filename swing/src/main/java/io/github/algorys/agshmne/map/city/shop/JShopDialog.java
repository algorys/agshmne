package io.github.algorys.agshmne.map.city.shop;

import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.design.ShopRenderer;
import io.github.algorys.agshmne.game.character.inventory.InventoryListModel;
import io.github.algorys.agshmne.items.Item;
import io.github.algorys.agshmne.items.stackable.IStackableItem;

@SuppressWarnings("serial")
public class JShopDialog extends JPanel {

	public JShopDialog(final Shop shop, final Player pj) {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbcShop = new GridBagConstraints();
		gbcShop.insets = new Insets(5, 5, 5, 5);
		final JLabel gold = new JLabel("Or restant : " + pj.getInventory().getGold());

		// TITRE
		gbcShop.gridy = 0;
		gbcShop.gridheight = 1;
		gbcShop.gridx = 0;
		gbcShop.gridwidth = 4;
		gbcShop.anchor = GridBagConstraints.CENTER;
		gbcShop.fill = GridBagConstraints.NONE;
		JLabel jpPerso = new JLabel("### MAGASIN ###");
		jpPerso.setBorder(BorderFactory.createLineBorder(Color.cyan));
		this.add(jpPerso, gbcShop);

		// Nom Vendeur
		gbcShop.gridy = 1;
		gbcShop.gridheight = 1;
		gbcShop.gridx = 0;
		gbcShop.gridwidth = 2;
		gbcShop.anchor = GridBagConstraints.CENTER;
		gbcShop.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Commerçant : Robert"), gbcShop);
		// Label Prix
		gbcShop.gridy = 1;
		gbcShop.gridheight = 1;
		gbcShop.gridx = 1;
		gbcShop.gridwidth = 1;
		gbcShop.anchor = GridBagConstraints.EAST;
		gbcShop.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Prix"), gbcShop);
		// JList SHOP
		gbcShop.gridy = 2;
		gbcShop.gridheight = 1;
		gbcShop.gridx = 0;
		gbcShop.gridwidth = 2;
		gbcShop.anchor = GridBagConstraints.EAST;
		gbcShop.fill = GridBagConstraints.NONE;
		final JList<Item> shopItem = new JList<Item>(new InventoryListModel(shop.getInventory()));
		shopItem.setCellRenderer(new ShopRenderer());
		shopItem.setBackground(Color.BLACK);
		shopItem.setForeground(Color.green);
		shopItem.setVisibleRowCount(10);
		shopItem.setPreferredSize(new Dimension(400, 300));
		shopItem.setEnabled(true);
		this.add(shopItem, gbcShop);

		shopItem.addMouseListener(new MouseAdapter() {
			public void mousePressed(final MouseEvent me) {
				if (me.isPopupTrigger()) {
					final int index = shopItem.locationToIndex(me.getPoint());
					JPopupMenu menu = new JPopupMenu();
					JMenuItem buy = new JMenuItem("Acheter");
					buy.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Item selectedItem = shopItem.getModel().getElementAt(index);
							if (selectedItem instanceof IStackableItem) {
								IStackableItem stackableItem = (IStackableItem) selectedItem;
								JDialog jdCount = new JDialog(SwingUtilities.getWindowAncestor(JShopDialog.this),
										"Combien de " + stackableItem.getName() + " voulez vous acheter ?",
										ModalityType.DOCUMENT_MODAL);
								jdCount.setSize(300, 150);
								JStackChoice choice = new JStackChoice(stackableItem);
								jdCount.add(choice);
								jdCount.setVisible(true);
								if(choice.getNbToSell() > 0) {
									shop.sellItem(pj, stackableItem, choice.getNbToSell());
									gold.setText("Or restant : " + pj.getInventory().getGold());
									shopItem.invalidate();
									shopItem.repaint();
								}
							} else {
								JOptionPane.showMessageDialog(JShopDialog.this, "" + selectedItem + " acheté(e) !");
								((InventoryListModel) shopItem.getModel()).removeElementAt(index);
								shop.sellItem(pj, selectedItem);
								gold.setText("Or restant : " + pj.getInventory().getGold());
								shopItem.invalidate();
								shopItem.repaint();
							}
						}
					});
					JMenuItem laisser = new JMenuItem("Ne rien faire.");
					menu.add(buy);
					menu.add(laisser);
					menu.show(shopItem, me.getX(), me.getY());
				}
			}
		});

		// Nom Pj
		gbcShop.gridy = 1;
		gbcShop.gridheight = 1;
		gbcShop.gridx = 2;
		gbcShop.gridwidth = 2;
		gbcShop.anchor = GridBagConstraints.CENTER;
		gbcShop.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Acheteur : " + pj.getName()), gbcShop);
		// Label Prix
		gbcShop.gridy = 1;
		gbcShop.gridheight = 1;
		gbcShop.gridx = 3;
		gbcShop.gridwidth = 1;
		gbcShop.anchor = GridBagConstraints.EAST;
		gbcShop.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Prix"), gbcShop);
		// JList SHOP
		gbcShop.gridy = 2;
		gbcShop.gridheight = 1;
		gbcShop.gridx = 2;
		gbcShop.gridwidth = 2;
		gbcShop.anchor = GridBagConstraints.WEST;
		gbcShop.fill = GridBagConstraints.NONE;
		final JList<Item> pjItem = new JList<Item>(new InventoryListModel(pj.getInventory()));
		pjItem.setCellRenderer(new ShopRenderer());
		pjItem.setBackground(Color.BLACK);
		pjItem.setForeground(Color.green);
		pjItem.setVisibleRowCount(10);
		pjItem.setPreferredSize(new Dimension(400, 300));
		pjItem.setEnabled(true);
		this.add(pjItem, gbcShop);

		pjItem.addMouseListener(new MouseAdapter() {
			public void mousePressed(final MouseEvent me) {
				if (me.isPopupTrigger()) {
					final int index = pjItem.locationToIndex(me.getPoint());
					JPopupMenu menu = new JPopupMenu();
					JMenuItem sell = new JMenuItem("Vendre");
					sell.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Item selectedItem = pjItem.getModel().getElementAt(index);
							if (selectedItem instanceof IStackableItem) {
								IStackableItem stackableItem = (IStackableItem) selectedItem;
								JDialog jdCount = new JDialog(SwingUtilities.getWindowAncestor(JShopDialog.this),
										"Combien de " + stackableItem.getName() + " voulez vous vendre ?",
										ModalityType.DOCUMENT_MODAL);
								jdCount.setSize(300, 150);
								JStackChoice choice = new JStackChoice(stackableItem);
								jdCount.add(choice);
								jdCount.setVisible(true);
								if(choice.getNbToSell() > 0) {
									shop.buyItem(pj, stackableItem, choice.getNbToSell());
									gold.setText("Or restant : " + pj.getInventory().getGold());
									pjItem.invalidate();
									pjItem.repaint();
								}
							} else {
								JOptionPane.showMessageDialog(JShopDialog.this, "" + selectedItem + " vendu(e) !");
								((InventoryListModel) pjItem.getModel()).removeElementAt(index);
								shop.buyItem(pj, selectedItem);
								gold.setText("Or restant : " + pj.getInventory().getGold());
								pjItem.invalidate();
								pjItem.repaint();
							}
						}
					});
					JMenuItem laisser = new JMenuItem("Ne rien faire.");
					menu.add(sell);
					menu.add(laisser);
					menu.show(pjItem, me.getX(), me.getY());
				}
			}
		});

		// Argent du Joueur
		gbcShop.gridy = 3;
		gbcShop.gridheight = 1;
		gbcShop.gridx = 0;
		gbcShop.gridwidth = 4;
		gbcShop.anchor = GridBagConstraints.CENTER;
		gbcShop.fill = GridBagConstraints.NONE;
		this.add(gold, gbcShop);
	}
}
