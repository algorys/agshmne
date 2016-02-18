package io.github.algorys.agshmne.renderer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import io.github.algorys.agshmne.items.Item;
import io.github.algorys.agshmne.items.equipable.IEquipableItem;
import io.github.algorys.agshmne.items.stackable.IStackableItem;

public class InvRenderer implements ListCellRenderer<Item> {
	private JLabel rendererComponent = new JLabel();

	@Override
	public Component getListCellRendererComponent(JList<? extends Item> list, Item value, int index, boolean isSelected,
			boolean cellHasFocus) {
		if (value == null) {
			rendererComponent.setText("");
		} else {
			rendererComponent.setText(value.toString());
			if (value instanceof IEquipableItem) {
				IEquipableItem currentItem = (IEquipableItem) value;
				if (currentItem.isEquipped()) {
					rendererComponent.setText(currentItem.getName() + " [Equipé]");
				}
				if (currentItem.getPuissance() < 4) {
					rendererComponent.setForeground(Color.white);
				} else if (currentItem.getPuissance() <= 9) {
					rendererComponent.setForeground(new Color(0, 128, 255));
				} else if (currentItem.getPuissance() <= 14) {
					rendererComponent.setForeground(Color.green);
				} else {
					rendererComponent.setForeground(Color.yellow);
				}
			} else if(value instanceof IStackableItem) {
				IStackableItem currentItem = (IStackableItem) value;
				rendererComponent.setForeground(new Color(255, 255, 153));
				rendererComponent.setText(currentItem.getName() + " (Qtité : " + currentItem.getCount() + ")");
			} else {
				rendererComponent.setForeground(Color.lightGray);
			}
		}

		if (isSelected) {
			rendererComponent.setBackground(list.getSelectionBackground());
			rendererComponent.setForeground(list.getSelectionForeground());
		} else {
			rendererComponent.setBackground(Color.black);
		}

		rendererComponent.setEnabled(list.isEnabled());
		rendererComponent.setFont(list.getFont());
		rendererComponent.setOpaque(true);
		return this.rendererComponent;
	}

}