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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.events.quest.IQuest;

@SuppressWarnings("serial")
public class JQuestResume extends JDialog {

	public JQuestResume(JFrame topFrame, final IQuest quest, final Player pj) {
		super(topFrame, quest.getName(), true);
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
		gbcQuest.fill = GridBagConstraints.HORIZONTAL;
		panEvent.add(new JQuest(quest), gbcQuest);

		gbcQuest.gridy = 5;
		gbcQuest.gridheight = 1;
		gbcQuest.gridx = 0;
		gbcQuest.gridwidth = 1;
		gbcQuest.anchor = GridBagConstraints.EAST;
		gbcQuest.fill = GridBagConstraints.HORIZONTAL;
		JButton finish = new JButton("Finir la quête");

		finish.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (quest.isWin(pj)) {
					quest.reward(pj);
					if (quest.isFinish()) {
						pj.getQuest().remove(quest);
					}
					JQuestResume.this.dispose();
				 } else {
					 JOptionPane.showMessageDialog(JQuestResume.this,
							 "Cette quête n'est pas encore finie ou vous n'êtes pas au bon endroit !");
				 }

			}
		});
		panEvent.add(finish, gbcQuest);

		gbcQuest.gridy = 5;
		gbcQuest.gridheight = 1;
		gbcQuest.gridx = 2;
		gbcQuest.gridwidth = 1;
		gbcQuest.anchor = GridBagConstraints.WEST;
		gbcQuest.fill = GridBagConstraints.HORIZONTAL;
		JButton decline = new JButton("Annuler");

		decline.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JQuestResume.this.dispose();

			}
		});
		panEvent.add(decline, gbcQuest);

		this.add(panEvent);
	}

}
