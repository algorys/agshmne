package io.github.algorys.agshmne.map.city.shop;

import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import io.github.algorys.agshmne.PopupTriggerAdapter;
import io.github.algorys.agshmne.character.Attribute;
import io.github.algorys.agshmne.design.InvRenderer;
import io.github.algorys.agshmne.design.ShopRenderer;
import io.github.algorys.agshmne.game.character.inventory.InventoryListModel;
import io.github.algorys.agshmne.items.Inventory;
import io.github.algorys.agshmne.items.Item;
import io.github.algorys.agshmne.items.equipable.IEquipableItem;
import io.github.algorys.agshmne.items.stackable.IStackableItem;

@SuppressWarnings("serial")
public class JShop extends JPanel {
	private Shop shop = Shop.NONE;
	private JList<Item> shopItem;

	public JShop(Shop initialShop, final Inventory playerInventory, String playerName) {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbcShop = new GridBagConstraints();
		gbcShop.insets = new Insets(5, 5, 5, 5);

		// TITRE
		gbcShop.gridy = 0;
		gbcShop.gridheight = 1;
		gbcShop.gridx = 0;
		gbcShop.gridwidth = 4;
		gbcShop.anchor = GridBagConstraints.CENTER;
		gbcShop.fill = GridBagConstraints.NONE;
		JLabel jlTitle = new JLabel("### MAGASIN ###");
		jlTitle.setBorder(BorderFactory.createLineBorder(Color.cyan));
		this.add(jlTitle, gbcShop);

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
		gbcShop.fill = GridBagConstraints.BOTH;
		gbcShop.weightx = 1;
		gbcShop.weighty = 1;

		shopItem = new JList<Item>(new InventoryListModel(shop.getInventory()));
		shopItem.setCellRenderer(new ShopRenderer(new InvRenderer()));
		shopItem.setBackground(Color.BLACK);
		shopItem.setForeground(Color.green);
		shopItem.setVisibleRowCount(10);
		shopItem.setEnabled(true);
		JScrollPane shopScroll = new JScrollPane(shopItem);
		this.add(shopScroll, gbcShop);

		// Nom Pj
		gbcShop.gridy = 1;
		gbcShop.gridheight = 1;
		gbcShop.gridx = 2;
		gbcShop.gridwidth = 2;
		gbcShop.anchor = GridBagConstraints.CENTER;
		gbcShop.fill = GridBagConstraints.NONE;
		gbcShop.weightx = 0;
		gbcShop.weighty = 0;
		this.add(new JLabel("Acheteur : " + playerName), gbcShop);

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
		gbcShop.anchor = GridBagConstraints.EAST;
		gbcShop.fill = GridBagConstraints.BOTH;
		gbcShop.weightx = 1;
		gbcShop.weighty = 1;
		final JList<Item> pjItem = new JList<Item>(new InventoryListModel(playerInventory));
		pjItem.setCellRenderer(new ShopRenderer(new InvRenderer()));
		pjItem.setBackground(Color.BLACK);
		pjItem.setForeground(Color.green);
		pjItem.setVisibleRowCount(10);
		pjItem.setEnabled(true);
		this.add(new JScrollPane(pjItem), gbcShop);

		// Argent du Joueur
		gbcShop.gridy = 3;
		gbcShop.gridheight = 1;
		gbcShop.gridx = 0;
		gbcShop.gridwidth = 2;
		gbcShop.anchor = GridBagConstraints.CENTER;
		gbcShop.fill = GridBagConstraints.BOTH;
		gbcShop.weightx = 0;
		gbcShop.weighty = 0;
		final JLabel gold = new JLabel("Or restant : " + playerInventory.getGold());
		gold.setPreferredSize(new Dimension(400, 50));
		gold.setBackground(Color.black);
		gold.setForeground(Color.yellow);
		gold.setOpaque(true);
		this.add(gold, gbcShop);

		playerInventory.addPropertyChangeListener(Inventory.PROPERTY_GOLD, new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getNewValue() instanceof Integer) {
					Integer newValue = (Integer) evt.getNewValue();
					gold.setText("Or restant : " + newValue);
				}

			}
		});

		// Détail objet
		gbcShop.gridy = 3;
		gbcShop.gridheight = 1;
		gbcShop.gridx = 2;
		gbcShop.gridwidth = 2;
		gbcShop.anchor = GridBagConstraints.CENTER;
		gbcShop.fill = GridBagConstraints.HORIZONTAL;
		final JLabel output = new JLabel("Aucun objet sélectionné");
		output.setPreferredSize(new Dimension(400, 50));
		output.setBackground(Color.black);
		output.setForeground(Color.green);
		output.setOpaque(true);
		this.add(output, gbcShop);

		ListSelectionListener selectionListener = new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getSource() instanceof JList) {
					@SuppressWarnings("unchecked")
					JList<Item> currentList = (JList<Item>) e.getSource();
					if (!e.getValueIsAdjusting()) {
						if (currentList.getSelectedValue() instanceof IEquipableItem) {
							IEquipableItem equipItem = (IEquipableItem) currentList.getSelectedValue();
							String attribute = getStringAttribute(equipItem.getAttribute());
							output.setText("<html><body>Nom : " + equipItem.getName() + "<br>Bonus : " + attribute
									+ "<br>Puissance : " + equipItem.getPuissance() + "</body></html>");
						} else if (currentList.getSelectedValue() instanceof Item) {
							Item item = (Item) currentList.getSelectedValue();
							output.setText("Nom : " + item.getName());
						} else {
							output.setText("Aucun objet sélectionné");
						}
					}
				}
			}
		};
		shopItem.addListSelectionListener(selectionListener);
		pjItem.addListSelectionListener(selectionListener);

		pjItem.addMouseListener(new PopupTriggerAdapter() {
			@Override
			public void popupTrigger(MouseEvent me) {
				final int index = pjItem.locationToIndex(me.getPoint());
				JPopupMenu menu = new JPopupMenu();
				JMenuItem sell = new JMenuItem("Vendre");
				sell.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Item selectedItem = pjItem.getModel().getElementAt(index);

						if (selectedItem instanceof IStackableItem) {
							IStackableItem stackableItem = (IStackableItem) selectedItem;
							JDialog jdCount = new JDialog(SwingUtilities.getWindowAncestor(JShop.this),
									"Combien de " + stackableItem.getName() + " voulez vous vendre ?",
									ModalityType.DOCUMENT_MODAL);
							jdCount.setSize(300, 150);
							int maxToSell = stackableItem.getCount();
							JStackChoice choice = new JStackChoice(stackableItem, maxToSell);
							jdCount.add(choice);
							jdCount.setVisible(true);
							if (choice.getNbToSell() > 0) {
								shop.buyItem(playerInventory, stackableItem, choice.getNbToSell());
								pjItem.invalidate();
								pjItem.repaint();
							}
						} else if (selectedItem instanceof IEquipableItem
								&& ((IEquipableItem) selectedItem).isEquipped()) {
							JOptionPane.showMessageDialog(JShop.this, "Vous devez d'abord déséquipper " + selectedItem);
						} else {
							// JOptionPane.showMessageDialog(JShop.this, "" +
							// selectedItem + " vendu(e) !");
							((InventoryListModel) pjItem.getModel()).removeElementAt(index);
							shop.buyItem(playerInventory, selectedItem);
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
		});
		shopItem.addMouseListener(new PopupTriggerAdapter() {
			@Override
			public void popupTrigger(MouseEvent me) {
				final int index = shopItem.locationToIndex(me.getPoint());
				JPopupMenu menu = new JPopupMenu();
				final JMenuItem buy = new JMenuItem("Acheter");
				buy.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Item selectedItem = shopItem.getModel().getElementAt(index);
						if (selectedItem.getPrice() > playerInventory.getGold()) {
							JOptionPane.showMessageDialog(JShop.this, "Vous n'avez pas assez d'argent !");
						} else {
							if (selectedItem instanceof IStackableItem) {
								IStackableItem stackableItem = (IStackableItem) selectedItem;
								JDialog jdCount = new JDialog(SwingUtilities.getWindowAncestor(JShop.this),
										"Combien de " + stackableItem.getName() + " voulez vous acheter ?",
										ModalityType.DOCUMENT_MODAL);
								jdCount.setSize(300, 150);
								int maxToBuy = playerInventory.getGold() / stackableItem.getPrice();
								System.out.println("Maxx = " + maxToBuy);
								JStackChoice choice = new JStackChoice(stackableItem, maxToBuy);
								jdCount.add(choice);
								jdCount.setVisible(true);
								if (choice.getNbToSell() > 0) {
									shop.sellItem(playerInventory, stackableItem, choice.getNbToSell());
									shopItem.invalidate();
									shopItem.repaint();
								}
							} else {
								// JOptionPane.showMessageDialog(JShop.this, ""
								// + selectedItem + " acheté(e) !");
								((InventoryListModel) shopItem.getModel()).removeElementAt(index);
								shop.sellItem(playerInventory, selectedItem);
								shopItem.invalidate();
								shopItem.repaint();
							}
						}
					}
				});
				JMenuItem laisser = new JMenuItem("Ne rien faire.");
				menu.add(buy);
				menu.add(laisser);
				menu.show(shopItem, me.getX(), me.getY());
			}
		});

		setShop(initialShop);
	}

	public void setShop(Shop shop) {
		this.shop = shop;
		shopItem.setModel(new InventoryListModel(shop.getInventory()));
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
