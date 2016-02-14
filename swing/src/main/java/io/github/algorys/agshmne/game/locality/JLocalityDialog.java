package io.github.algorys.agshmne.game.locality;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JTextArea;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.events.locality.Locality;

@SuppressWarnings("serial")
public class JLocalityDialog extends JDialog {

	public JLocalityDialog(JFrame topFrame, final Locality locality, final Player pj) {
		super(topFrame, "Vous avez découvert un lieu...", true);
		this.setSize(600, 300);
		this.setLocationRelativeTo(topFrame);
		final JLabel effect = new JLabel("");
		effect.setForeground(Color.cyan);

		JPanel panEvent = new JPanel();
		panEvent.setLayout(new GridBagLayout());
		panEvent.setPreferredSize(new Dimension(550, 280));
		panEvent.setBackground(Color.black);
		GridBagConstraints gbcQuest = new GridBagConstraints();
		gbcQuest.insets = new Insets(5, 5, 5, 5);

		gbcQuest.gridy = 0;
		gbcQuest.gridheight = 1;
		gbcQuest.gridx = 0;
		gbcQuest.gridwidth = 4;
		gbcQuest.anchor = GridBagConstraints.CENTER;
		gbcQuest.fill = GridBagConstraints.NONE;
		JLabel title = new JLabel("Lieu-dit");
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
		JLabel descTitle = new JLabel("Description :");
		descTitle.setForeground(Color.yellow);
		panEvent.add(descTitle, gbcQuest);
		
		gbcQuest.gridy = 3;
		gbcQuest.gridheight = 1;
		gbcQuest.gridx = 0;
		gbcQuest.gridwidth = 4;
		gbcQuest.anchor = GridBagConstraints.WEST;
		gbcQuest.fill = GridBagConstraints.NONE;
		JTextArea desc = new JTextArea(locality.getDesc());
		desc.setFont(new Font("Serif", Font.ITALIC, 16));
		desc.setLineWrap(true);
		desc.setWrapStyleWord(true);
		desc.setMinimumSize(new Dimension(500, 300));
		desc.setOpaque(false);
		desc.setForeground(Color.white);
		panEvent.add(desc, gbcQuest);

		gbcQuest.gridy = 4;
		gbcQuest.gridheight = 1;
		gbcQuest.gridx = 0;
		gbcQuest.gridwidth = 2;
		gbcQuest.anchor = GridBagConstraints.WEST;
		gbcQuest.fill = GridBagConstraints.NONE;
		final JButton yes = new JButton("Oui");
		
		yes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				locality.interact(pj);
				effect.setText("Effet : " + locality.getDescEffect());
				JLocalityDialog.this.dispose();
			}
		});
		panEvent.add(yes, gbcQuest);
		
		gbcQuest.gridy = 4;
		gbcQuest.gridheight = 1;
		gbcQuest.gridx = 2;
		gbcQuest.gridwidth = 2;
		gbcQuest.anchor = GridBagConstraints.EAST;
		gbcQuest.fill = GridBagConstraints.NONE;
		final JButton no = new JButton("Partir");
		
		no.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JLocalityDialog.this.dispose();
			}
		});
		panEvent.add(no, gbcQuest);
		
		gbcQuest.gridy = 5;
		gbcQuest.gridheight = 1;
		gbcQuest.gridx = 0;
		gbcQuest.gridwidth = 4;
		gbcQuest.anchor = GridBagConstraints.CENTER;
		gbcQuest.fill = GridBagConstraints.NONE;
		panEvent.add(effect, gbcQuest);
		
		this.add(panEvent);
	}
}
