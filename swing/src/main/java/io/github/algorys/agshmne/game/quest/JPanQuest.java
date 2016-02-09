package io.github.algorys.agshmne.game.quest;

import javax.swing.JList;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.events.quest.IQuest;

@SuppressWarnings("serial")
public class JPanQuest extends JPanel {
	
	public JPanQuest(Player pj) {
		// TODO faire listmodel pour quest
		JList<IQuest> quests = new JList<IQuest>();
	}
}
