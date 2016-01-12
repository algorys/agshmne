package design;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import io.github.algorys.agshmne.inventory.InventoryItem;
import io.github.algorys.agshmne.items.fruits.Apple;

public class InvRenderer implements ListCellRenderer<InventoryItem> {
	private JLabel rendererComponent = new JLabel();
	
	@Override
	public Component getListCellRendererComponent(JList<? extends InventoryItem> list, InventoryItem value, int index, boolean isSelected,
			boolean cellHasFocus) {
		rendererComponent.setText(value.toString());

		if (isSelected) {
			rendererComponent.setBackground(list.getSelectionBackground());
			rendererComponent.setForeground(list.getSelectionForeground());
		} else {
			if (value instanceof Apple) {

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