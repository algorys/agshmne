package io.github.algorys.agshmne.design;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import io.github.algorys.agshmne.items.Item;
import io.github.algorys.agshmne.items.equipable.IEquipableItem;
import io.github.algorys.agshmne.items.stackable.IStackableItem;

public class ShopRenderer implements ListCellRenderer<Item> {
	private JPanel jpRenderer = new JPanel(new BorderLayout());
	private JLabel rendererComponent = new JLabel();
	private JLabel jlPrice = new JLabel("XXX");

	public ShopRenderer() {
		jpRenderer.setMinimumSize(new Dimension(290, 15));
		jpRenderer.setPreferredSize(new Dimension(290, 15));
		jlPrice.setBackground(Color.black);
		jlPrice.setForeground(new Color(255, 247, 121));
		jlPrice.setHorizontalAlignment(JLabel.CENTER);
		jlPrice.setPreferredSize(new Dimension(30, 15));
		jpRenderer.setBackground(Color.BLACK);
		jpRenderer.add(rendererComponent, BorderLayout.CENTER);
		jpRenderer.add(jlPrice, BorderLayout.EAST);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Item> list, Item value, int index, boolean isSelected,
			boolean cellHasFocus) {
		rendererComponent.setBackground(Color.black);
		if (value == null) {
			rendererComponent.setText("");
		} else {
			jlPrice.setText("" + value.getPrice());
			rendererComponent.setText(value.toString());
			if (value instanceof IEquipableItem) {
				IEquipableItem currentItem = (IEquipableItem) value;
				if (currentItem.isEquipped()) {
					rendererComponent.setText(currentItem.toString() + " [Equipé]");
				}
				if (currentItem.getPuissance() < 4) {
					rendererComponent.setForeground(Color.white);
				}
				if (currentItem.getPuissance() > 4) {
					rendererComponent.setForeground(Color.blue);
				}
				if (currentItem.getPuissance() > 9) {
					rendererComponent.setForeground(Color.green);
				}
				if (currentItem.getPuissance() > 14) {
					rendererComponent.setForeground(Color.yellow);
				}
			} else if(value instanceof IStackableItem) {
				IStackableItem currentItem = (IStackableItem) value;
				rendererComponent.setForeground(new Color(255, 255, 204));
				rendererComponent.setText(currentItem.toString() + " (Qtité : " + currentItem.getCount() + ")");
			} else {
				rendererComponent.setForeground(Color.lightGray);
			}
		}

		if (isSelected) {
			rendererComponent.setBackground(list.getSelectionBackground());
			rendererComponent.setForeground(list.getSelectionForeground());
		}

		rendererComponent.setEnabled(list.isEnabled());
		rendererComponent.setFont(list.getFont());
		rendererComponent.setOpaque(true);
		return this.jpRenderer;
	}
}
