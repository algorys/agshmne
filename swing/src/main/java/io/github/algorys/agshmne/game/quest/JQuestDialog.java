package io.github.algorys.agshmne.game.quest;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.events.quest.IQuest;

@SuppressWarnings("serial")
public class JQuestDialog extends JDialog {
	
	public JQuestDialog(JFrame topFrame, IQuest quest, Player pj) {
		super(topFrame, "On vous propose une quête !", true);
		this.setSize(600, 300);
		this.setLocationRelativeTo(topFrame);
		
		JPanel panEvent = new JPanel();
		panEvent.setLayout(new GridBagLayout());
		panEvent.setBackground(Color.black);
		GridBagConstraints gbcQuest = new GridBagConstraints();
		gbcQuest.insets = new Insets(5, 5, 5, 5);

		gbcQuest.gridy = 0;
		gbcQuest.gridheight = 1;
		gbcQuest.gridx = 0;
		gbcQuest.gridwidth = 4;
		gbcQuest.anchor = GridBagConstraints.CENTER;
		gbcQuest.fill = GridBagConstraints.NONE;
		JLabel title = new JLabel("QUÊTE");
		title.setForeground(Color.cyan);
		panEvent.add(title, gbcQuest);
		
		gbcQuest.gridy = 1;
		gbcQuest.gridheight = 1;
		gbcQuest.gridx = 0;
		gbcQuest.gridwidth = 4;
		gbcQuest.anchor = GridBagConstraints.WEST;
		gbcQuest.fill = GridBagConstraints.NONE;
		JLabel questName = new JLabel("Objectif(s) : " + quest.getName());
		questName.setForeground(Color.green);
		panEvent.add(questName, gbcQuest);
		
		gbcQuest.gridy = 2;
		gbcQuest.gridheight = 1;
		gbcQuest.gridx = 0;
		gbcQuest.gridwidth = 4;
		gbcQuest.anchor = GridBagConstraints.WEST;
		gbcQuest.fill = GridBagConstraints.NONE;
		JTextArea questDesc = new JTextArea("Description : " + quest.getGoal());
		questDesc.setOpaque(false);
		questDesc.setForeground(Color.white);
		panEvent.add(questDesc, gbcQuest);
		
		gbcQuest.gridy = 3;
		gbcQuest.gridheight = 1;
		gbcQuest.gridx = 1;
		gbcQuest.gridwidth = 1;
		gbcQuest.anchor = GridBagConstraints.CENTER;
		gbcQuest.fill = GridBagConstraints.NONE;
		JButton accept = new JButton("Accepter");
		panEvent.add(accept, gbcQuest);
		
		gbcQuest.gridy = 3;
		gbcQuest.gridheight = 1;
		gbcQuest.gridx = 2;
		gbcQuest.gridwidth = 1;
		gbcQuest.fill = GridBagConstraints.NONE;
		JButton decline = new JButton("Refuser");
		panEvent.add(decline, gbcQuest);
		
		this.add(panEvent);
	}
}
