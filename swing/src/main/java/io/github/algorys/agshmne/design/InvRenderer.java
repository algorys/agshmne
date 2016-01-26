package io.github.algorys.agshmne.design;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import io.github.algorys.agshmne.items.Item;
import io.github.algorys.agshmne.items.StackableItemDirectFactory;

public class InvRenderer implements ListCellRenderer<Item> {
	private JLabel rendererComponent = new JLabel();
	
	public InvRenderer() {
		rendererComponent.setMinimumSize(new Dimension(290, 15));
		rendererComponent.setPreferredSize(new Dimension(290, 15));
	}
	
	@Override
	public Component getListCellRendererComponent(JList<? extends Item> list, Item value, int index, boolean isSelected, boolean cellHasFocus) {
		if(value == null) {
			rendererComponent.setText("");
		} else {
			rendererComponent.setText(value.toString());
		}

		if (isSelected) {
			rendererComponent.setBackground(list.getSelectionBackground());
			rendererComponent.setForeground(list.getSelectionForeground());
		} else {
			if (value.isSameType(new StackableItemDirectFactory().createApple())) {

				rendererComponent.setBackground(Color.GREEN);
				rendererComponent.setForeground(Color.BLACK);
			} else {
				rendererComponent.setBackground(list.getBackground());
				rendererComponent.setForeground(list.getForeground());
			}
		}

		rendererComponent.setEnabled(list.isEnabled());
		rendererComponent.setFont(list.getFont());
		rendererComponent.setOpaque(true);
		return this.rendererComponent;
	}

}