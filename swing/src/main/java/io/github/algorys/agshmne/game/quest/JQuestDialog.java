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
import javax.swing.JPanel;

import io.github.algorys.agshmne.adventure.quest.IQuest;
import io.github.algorys.agshmne.character.player.Player;

@SuppressWarnings("serial")
public class JQuestDialog extends JDialog {
	
	public JQuestDialog(JFrame topFrame, final IQuest quest, final Player pj) {
		super(topFrame, "On vous propose une quête !", true);
		this.setSize(900, 400);
		this.setLocationRelativeTo(topFrame);
		
		JPanel panEvent = new JPanel();
		panEvent.setLayout(new GridBagLayout());
		panEvent.setBackground(Color.black);
		GridBagConstraints gbcQuest = new GridBagConstraints();
		gbcQuest.insets = new Insets(5, 5, 5, 5);

		gbcQuest.gridy = 0;
		gbcQuest.gridheight = 5;
		gbcQuest.gridx = 0;
		gbcQuest.gridwidth = 4;
		gbcQuest.anchor = GridBagConstraints.CENTER;
		gbcQuest.fill = GridBagConstraints.HORIZONTAL;
		panEvent.add(new JQuest(quest), gbcQuest);
		
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
				quest.accept(pj);
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
