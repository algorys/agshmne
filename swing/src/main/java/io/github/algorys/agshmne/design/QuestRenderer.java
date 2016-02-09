package io.github.algorys.agshmne.design;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import io.github.algorys.agshmne.events.quest.IQuest;

public class QuestRenderer implements ListCellRenderer<IQuest> {
	private JLabel rendererComponent = new JLabel();

	@Override
	public Component getListCellRendererComponent(JList<? extends IQuest> list, IQuest value, int index,
			boolean isSelected, boolean cellHasFocus) {
		if (value == null) {
			rendererComponent.setText("");
		} else {
			rendererComponent.setText(value.getName() + value.getGoal());
			if(value.isFinish()) {
				rendererComponent.setForeground(Color.green);
			} else {
				rendererComponent.setForeground(Color.cyan);
			}
		}
		return this.rendererComponent;
	}

}
