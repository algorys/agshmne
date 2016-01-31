package io.github.algorys.agshmne.design;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import io.github.algorys.agshmne.items.IEquipableItem;
import io.github.algorys.agshmne.items.IStackableItem;
import io.github.algorys.agshmne.items.Item;

public class InvRenderer implements ListCellRenderer<Item> {
	private JLabel rendererComponent = new JLabel();

	public InvRenderer() {
		rendererComponent.setMinimumSize(new Dimension(290, 15));
		rendererComponent.setPreferredSize(new Dimension(290, 15));
		rendererComponent.setBackground(Color.darkGray);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Item> list, Item value, int index, boolean isSelected,
			boolean cellHasFocus) {
		rendererComponent.setBackground(Color.black);
		if (value == null) {
			rendererComponent.setText("");
		} else {
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
				rendererComponent.setText(currentItem.toString() + " Qtité : " + currentItem.getCount());
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
		return this.rendererComponent;
	}

}