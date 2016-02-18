package io.github.algorys.agshmne.renderer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import io.github.algorys.agshmne.items.Item;

public class ShopRenderer implements ListCellRenderer<Item> {
	private JPanel jpRenderer = new JPanel(new BorderLayout());
	private JLabel jlPrice = new JLabel("XXX");
	private ListCellRenderer<Item> other;

	public ShopRenderer(ListCellRenderer<Item> other) {
		this.other = other;
		jlPrice.setBackground(Color.black);
		jlPrice.setForeground(new Color(255, 247, 121));
		jlPrice.setHorizontalAlignment(JLabel.CENTER);
		jlPrice.setPreferredSize(new Dimension(40, 15));
		jpRenderer.setBackground(Color.BLACK);
		jpRenderer.add(jlPrice, BorderLayout.EAST);
		jlPrice.setOpaque(true);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Item> list, Item value, int index, boolean isSelected,
			boolean cellHasFocus) {
		Component otherComponent = other.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		jpRenderer.add(otherComponent, BorderLayout.CENTER);
		if (value == null) {
			jlPrice.setText("");
		} else {
			jlPrice.setText("" + value.getPrice());
		}
		jlPrice.setForeground(otherComponent.getForeground());
		jlPrice.setBackground(otherComponent.getBackground());
		return this.jpRenderer;
	}
}
