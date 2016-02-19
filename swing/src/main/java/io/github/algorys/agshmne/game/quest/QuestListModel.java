package io.github.algorys.agshmne.game.quest;

import java.util.List;

import javax.swing.AbstractListModel;

import io.github.algorys.agshmne.adventure.quest.IQuest;

@SuppressWarnings("serial")
public class QuestListModel extends AbstractListModel<IQuest> {
	final private List<IQuest> quests;
	
	public QuestListModel(List<IQuest> quests) {
		this.quests = quests;
	}
	@Override
	public int getSize() {
		return quests.size();
	}
	@Override
	public IQuest getElementAt(int index) {
		return quests.get(index);
	}
	public void removeElementAt(int index) {
		quests.remove(quests.get(index));
		this.fireIntervalRemoved(this, index, index );
	}
}
