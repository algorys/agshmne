package io.github.algorys.agshmne.renderer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class OutputRenderer implements ListCellRenderer<String> {
	private JLabel rendererComponent = new JLabel();

	@Override
	public Component getListCellRendererComponent(JList<? extends String> list, String value, int index,
			boolean isSelected, boolean cellHasFocus) {
		if (value == null) {
			rendererComponent.setText("");
		} else {
			rendererComponent.setText(value.toString());
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
