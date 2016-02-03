package io.github.algorys.agshmne.game.east;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.events.locality.Locality;

@SuppressWarnings("serial")
public class JLocalityDialog extends JDialog {

	public JLocalityDialog(JFrame topFrame, Locality locality, Player pj) {
		super(topFrame, "Vous avez découvert un lieu...", true);
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
		JLabel title = new JLabel("LOCALITÉ");
		title.setForeground(Color.cyan);
		panEvent.add(title, gbcQuest);
		
		gbcQuest.gridy = 1;
		gbcQuest.gridheight = 1;
		gbcQuest.gridx = 0;
		gbcQuest.gridwidth = 4;
		gbcQuest.anchor = GridBagConstraints.CENTER;
		gbcQuest.fill = GridBagConstraints.NONE;
		JLabel name = new JLabel("Lieu : " + locality.getName());
		name.setForeground(Color.white);
		panEvent.add(name, gbcQuest);
		
		gbcQuest.gridy = 2;
		gbcQuest.gridheight = 1;
		gbcQuest.gridx = 0;
		gbcQuest.gridwidth = 4;
		gbcQuest.anchor = GridBagConstraints.CENTER;
		gbcQuest.fill = GridBagConstraints.NONE;
		JTextArea desc = new JTextArea("Description : " + locality.getDesc());
		desc.setOpaque(false);
		desc.setForeground(Color.white);
		panEvent.add(desc, gbcQuest);
		
		this.add(panEvent);
	}
}
