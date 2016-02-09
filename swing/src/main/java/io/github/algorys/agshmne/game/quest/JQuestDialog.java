package io.github.algorys.agshmne.game.quest;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.events.quest.IQuest;

@SuppressWarnings("serial")
public class JQuestDialog extends JDialog {
	
	public JQuestDialog(JFrame topFrame, IQuest quest, Player pj) {
		super(topFrame, "On vous propose une quête !", true);
		this.setSize(900, 400);
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
		gbcQuest.anchor = GridBagConstraints.CENTER;
		gbcQuest.fill = GridBagConstraints.HORIZONTAL;
		JLabel questName = new JLabel("Objectif(s) : " + quest.getName());
		questName.setForeground(Color.green);
		panEvent.add(questName, gbcQuest);
		
		gbcQuest.gridy = 2;
		gbcQuest.gridheight = 1;
		gbcQuest.gridx = 0;
		gbcQuest.gridwidth = 4;
		gbcQuest.anchor = GridBagConstraints.WEST;
		gbcQuest.fill = GridBagConstraints.NONE;
		JLabel questDescTitle = new JLabel("Description : " + quest.getGoal());
		questDescTitle.setOpaque(false);
		questDescTitle.setForeground(Color.white);
		panEvent.add(questDescTitle, gbcQuest);
		
		gbcQuest.gridy = 3;
		gbcQuest.gridheight = 1;
		gbcQuest.gridx = 0;
		gbcQuest.gridwidth = 4;
		gbcQuest.anchor = GridBagConstraints.WEST;
		gbcQuest.fill = GridBagConstraints.BOTH;
		JLabel questDesc = new JLabel(quest.getGoal());
		questDesc.setOpaque(false);
		questDesc.setForeground(Color.white);
		panEvent.add(questDesc, gbcQuest);
		
		gbcQuest.gridy = 5;
		gbcQuest.gridheight = 1;
		gbcQuest.gridx = 0;
		gbcQuest.gridwidth = 1;
		gbcQuest.anchor = GridBagConstraints.EAST;
		gbcQuest.fill = GridBagConstraints.HORIZONTAL;
		JButton accept = new JButton("Accepter");
		
		accept.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JQuestDialog.this.dispose();
				
			}
		});
		panEvent.add(accept, gbcQuest);
		
		gbcQuest.gridy = 5;
		gbcQuest.gridheight = 1;
		gbcQuest.gridx = 2;
		gbcQuest.gridwidth = 1;
		gbcQuest.anchor = GridBagConstraints.WEST;
		gbcQuest.fill = GridBagConstraints.HORIZONTAL;
		JButton decline = new JButton("Refuser");
		
		decline.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JQuestDialog.this.dispose();
				
			}
		});
		panEvent.add(decline, gbcQuest);
		
		this.add(panEvent);
	}
}
