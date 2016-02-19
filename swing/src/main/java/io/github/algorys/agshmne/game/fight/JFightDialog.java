package io.github.algorys.agshmne.game.fight;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.opponent.beast.Beast;
import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.events.fight.Fight;

@SuppressWarnings("serial")
public class JFightDialog extends JDialog {

	public JFightDialog(Frame topFrame, final Fight fight) {
		super(topFrame, "Vous êtes attaqué !", true);
		final Player pj = (Player) fight.getLeftOpponent();
		final Beast mob = (Beast) fight.getRightOpponent();

		this.setSize(600, 300);
		this.setLocationRelativeTo(topFrame);

		JPanel panEvent = new JPanel();
		panEvent.setLayout(new GridBagLayout());
		panEvent.setBackground(Color.black);
		GridBagConstraints gbcFight = new GridBagConstraints();
		gbcFight.insets = new Insets(5, 5, 5, 5);

		gbcFight.gridy = 0;
		gbcFight.gridheight = 1;
		gbcFight.gridx = 0;
		gbcFight.gridwidth = 4;
		gbcFight.anchor = GridBagConstraints.CENTER;
		gbcFight.fill = GridBagConstraints.NONE;
		JLabel title = new JLabel("COMBAT");
		title.setForeground(Color.red);
		panEvent.add(title, gbcFight);

		// PLAYER
		gbcFight.gridy = 1;
		gbcFight.gridheight = 1;
		gbcFight.gridx = 1;
		gbcFight.gridwidth = 1;
		gbcFight.anchor = GridBagConstraints.WEST;
		gbcFight.fill = GridBagConstraints.NONE;
		panEvent.add(new JCharacter(pj), gbcFight);

		// MONSTER
		gbcFight.gridy = 1;
		gbcFight.gridheight = 1;
		gbcFight.gridx = 2;
		gbcFight.gridwidth = 1;
		gbcFight.anchor = GridBagConstraints.EAST;
		gbcFight.fill = GridBagConstraints.NONE;
		panEvent.add(new JCharacter(mob), gbcFight);

		final JButton jbAttaq = new JButton("Attaquer");
		gbcFight.gridy = 2;
		gbcFight.gridheight = 1;
		gbcFight.gridx = 2;
		gbcFight.gridwidth = 1;
		gbcFight.anchor = GridBagConstraints.EAST;
		gbcFight.fill = GridBagConstraints.NONE;
		panEvent.add(jbAttaq, gbcFight);

		final JButton jbDefense = new JButton("Défense");
		gbcFight.gridy = 2;
		gbcFight.gridheight = 1;
		gbcFight.gridx = 1;
		gbcFight.gridwidth = 1;
		gbcFight.anchor = GridBagConstraints.EAST;
		gbcFight.fill = GridBagConstraints.NONE;
		panEvent.add(jbDefense, gbcFight);

		final JButton jbQuit = new JButton("Combat en cours...");
		jbQuit.setEnabled(false);
		gbcFight.gridy = 9;
		gbcFight.gridheight = 1;
		gbcFight.gridx = 1;
		gbcFight.gridwidth = 2;
		gbcFight.anchor = GridBagConstraints.CENTER;
		gbcFight.fill = GridBagConstraints.NONE;
		panEvent.add(jbQuit, gbcFight);
		jbQuit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFightDialog.this.dispose();
			}
		});

		jbAttaq.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fight.newRound();
				if (fight.isFinish()) {
					jbQuit.setText("Quitter le combat");
					jbQuit.setEnabled(true);
					jbAttaq.setEnabled(false);
					jbDefense.setEnabled(false);
				}
			}
		});

		gbcFight.gridy = 0;
		gbcFight.gridheight = 1;
		gbcFight.gridx = 0;
		gbcFight.gridwidth = 1;
		gbcFight.weightx = 50;
		panEvent.add(new JLabel(), gbcFight);

		gbcFight.gridy = 0;
		gbcFight.gridheight = 1;
		gbcFight.gridx = 3;
		gbcFight.gridwidth = 1;
		gbcFight.weightx = 50;
		panEvent.add(new JLabel(), gbcFight);

		this.add(panEvent);
	}
}
