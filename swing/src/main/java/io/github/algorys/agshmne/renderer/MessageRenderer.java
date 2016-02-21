package io.github.algorys.agshmne.renderer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import io.github.algorys.agshmne.message.Message;
import io.github.algorys.agshmne.message.MsgType;

public class MessageRenderer implements ListCellRenderer<Message> {
	private JLabel rendererComponent = new JLabel();

	@Override
	public Component getListCellRendererComponent(JList<? extends Message> list, Message value, int index,
			boolean isSelected, boolean cellHasFocus) {
		if (value == null) {
			rendererComponent.setText("");
		} else {
			rendererComponent.setText(value.getMessage().toString());
			if(value.getType() == MsgType.CRITICAL) {
				rendererComponent.setForeground(Color.red);
			} else if (value.getType() == MsgType.WARNING) {
				rendererComponent.setForeground(Color.yellow);
			} else if (value.getType() == MsgType.SUCCESS) {
				rendererComponent.setForeground(Color.green);
			} else if (value.getType() == MsgType.INFO) {
				rendererComponent.setForeground(Color.cyan);
			} else if (value.getType() == MsgType.HISTORY) {
				rendererComponent.setForeground(Color.magenta);
			} else if (value.getType() == MsgType.NONE) {
				rendererComponent.setForeground(Color.white);
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
