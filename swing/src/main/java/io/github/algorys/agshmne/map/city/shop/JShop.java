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
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import io.github.algorys.agshmne.character.Attribute;
import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.design.InvRenderer;
import io.github.algorys.agshmne.design.ShopRenderer;
import io.github.algorys.agshmne.game.character.inventory.InventoryListModel;
import io.github.algorys.agshmne.items.Item;
import io.github.algorys.agshmne.items.equipable.IEquipableItem;
import io.github.algorys.agshmne.items.stackable.IStackableItem;

@SuppressWarnings("serial")
public class JShop extends JPanel {

	public JShop(final Shop shop, final Player pj) {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbcShop = new GridBagConstraints();
		gbcShop.insets = new Insets(5, 5, 5, 5);
		final JLabel gold = new JLabel("Or restant : " + pj.getInventory().getGold());
		// Margin text
		Border paddingBorder = BorderFactory.createEmptyBorder(10,10,10,10);
		gold.setBorder(BorderFactory.createCompoundBorder(null,paddingBorder));
		gold.setPreferredSize(new Dimension(400, 50));
		gold.setBackground(Color.black);
		gold.setForeground(Color.yellow);
		gold.setOpaque(true);
		final JLabel output = new JLabel("Aucun objet sélectionné");
		output.setBorder(BorderFactory.createCompoundBorder(null,paddingBorder));
		output.setPreferredSize(new Dimension(400, 50));
		output.setBackground(Color.black);
		output.setForeground(Color.green);
		output.setOpaque(true);

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
		ShopRenderer shopItemRenderer = new ShopRenderer(new InvRenderer());
		shopItem.setCellRenderer(shopItemRenderer);
		shopItem.setBackground(Color.BLACK);
		shopItem.setForeground(Color.green);
		shopItem.setVisibleRowCount(10);
		shopItem.setEnabled(true);
		JScrollPane scrollShop = new JScrollPane(shopItem);
		scrollShop.setPreferredSize(new Dimension(400, 300));
		this.add(scrollShop, gbcShop);
		shopItem.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(e.getValueIsAdjusting()){
					if(shopItem.getSelectedValue() instanceof IEquipableItem) {
						IEquipableItem equipItem = (IEquipableItem) shopItem.getSelectedValue();
						String attribute = getStringAttribute(equipItem.getAttribute());
						output.setText("<html><body>Nom : " + equipItem.getName() + 
								"<br>Bonus : " + attribute +
								"<br>Puissance : "+equipItem.getPuissance()+"</body></html>");
					} else {
						output.setText("Détails objet : " + shopItem.getSelectedValue().getName());
					}
				}
				
			}
		});
		shopItem.addMouseListener(new MouseAdapter() {
			public void mousePressed(final MouseEvent me) {
				if (me.isPopupTrigger()) {
					final int index = shopItem.locationToIndex(me.getPoint());
					JPopupMenu menu = new JPopupMenu();
					final JMenuItem buy = new JMenuItem("Acheter");
					buy.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Item selectedItem = shopItem.getModel().getElementAt(index);
							if (selectedItem.getPrice() > pj.getInventory().getGold()) {
								JOptionPane.showMessageDialog(JShop.this, "Vous n'avez pas assez d'argent !");
							} else {
								if (selectedItem instanceof IStackableItem) {
									IStackableItem stackableItem = (IStackableItem) selectedItem;
									JDialog jdCount = new JDialog(SwingUtilities.getWindowAncestor(JShop.this),
											"Combien de " + stackableItem.getName() + " voulez vous acheter ?",
											ModalityType.DOCUMENT_MODAL);
									jdCount.setSize(300, 150);
									int maxToBuy = pj.getInventory().getGold() / stackableItem.getPrice();
									System.out.println("Maxx = " + maxToBuy);
									JStackChoice choice = new JStackChoice(stackableItem, maxToBuy);
									jdCount.add(choice);
									jdCount.setVisible(true);
									if (choice.getNbToSell() > 0) {
										shop.sellItem(pj, stackableItem, choice.getNbToSell());
										gold.setText("Or restant : " + pj.getInventory().getGold());
										shopItem.invalidate();
										shopItem.repaint();
									}
								} else {
									JOptionPane.showMessageDialog(JShop.this, "" + selectedItem + " acheté(e) !");
									((InventoryListModel) shopItem.getModel()).removeElementAt(index);
									shop.sellItem(pj, selectedItem);
									gold.setText("Or restant : " + pj.getInventory().getGold());
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
			}
		});

		pj.addPropertyChangeListener(Player.PROPERTY_POSITION, new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if(pj.getTile().isCivilized()) {
					shopItem.setModel(new InventoryListModel(pj.getTile().getCity().getShop().getInventory()));
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
		pjItem.setCellRenderer(shopItemRenderer);
		pjItem.setBackground(Color.BLACK);
		pjItem.setForeground(Color.green);
		pjItem.setVisibleRowCount(10);
		pjItem.setEnabled(true);
		JScrollPane scrollPj = new JScrollPane(pjItem);
		scrollPj.setPreferredSize(new Dimension(400, 300));
		this.add(scrollPj, gbcShop);

		pjItem.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(e.getValueIsAdjusting()){
					if(pjItem.getSelectedValue() instanceof IEquipableItem) {
						IEquipableItem equipItem = (IEquipableItem) pjItem.getSelectedValue();
						String attribute = getStringAttribute(equipItem.getAttribute());
						output.setText("<html><body>Nom : " + equipItem.getName() + 
								"<br>Bonus : " + attribute +
								"<br>Puissance : "+equipItem.getPuissance()+"</body></html>");
					} else {
						output.setText("Nom : " + pjItem.getSelectedValue().getName());
					}
				}
			}
		});

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
								JDialog jdCount = new JDialog(SwingUtilities.getWindowAncestor(JShop.this),
										"Combien de " + stackableItem.getName() + " voulez vous vendre ?",
										ModalityType.DOCUMENT_MODAL);
								jdCount.setSize(300, 150);
								int maxToSell = stackableItem.getCount();
								JStackChoice choice = new JStackChoice(stackableItem, maxToSell);
								jdCount.add(choice);
								jdCount.setVisible(true);
								if (choice.getNbToSell() > 0) {
									shop.buyItem(pj, stackableItem, choice.getNbToSell());
									gold.setText("Or restant : " + pj.getInventory().getGold());
									pjItem.invalidate();
									pjItem.repaint();
								}
							} else if(selectedItem instanceof IEquipableItem) {
								IEquipableItem itemEquip = (IEquipableItem) selectedItem;
								if(itemEquip.isEquipped()){
									JOptionPane.showMessageDialog(JShop.this,
											"Vous devez d'abord déséquipper " + itemEquip);
								} else {
									JOptionPane.showMessageDialog(JShop.this, "" + selectedItem + " vendu(e) !");
									((InventoryListModel) pjItem.getModel()).removeElementAt(index);
									shop.buyItem(pj, selectedItem);
									gold.setText("Or restant : " + pj.getInventory().getGold());
									pjItem.invalidate();
									pjItem.repaint();
								}
							} else {
								JOptionPane.showMessageDialog(JShop.this, "" + selectedItem + " vendu(e) !");
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
		gbcShop.gridwidth = 2;
		gbcShop.anchor = GridBagConstraints.CENTER;
		gbcShop.fill = GridBagConstraints.NONE;
		this.add(gold, gbcShop);
		
		// Détail objet
		gbcShop.gridy = 3;
		gbcShop.gridheight = 1;
		gbcShop.gridx = 2;
		gbcShop.gridwidth = 2;
		gbcShop.anchor = GridBagConstraints.CENTER;
		gbcShop.fill = GridBagConstraints.NONE;
		this.add(output, gbcShop);
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
