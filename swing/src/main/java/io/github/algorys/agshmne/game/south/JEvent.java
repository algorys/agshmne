package io.github.algorys.agshmne.game.south;

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
import javax.swing.SwingUtilities;

import io.github.algorys.agshmne.character.opponent.beast.Beast;
import io.github.algorys.agshmne.character.opponent.beast.BeastFactory;
import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.fight.Fight;

@SuppressWarnings("serial")
public class JEvent extends JPanel {
	JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
	Player pj;

	public JEvent(Player pj) {
		this.pj = pj;
	}

	public void updateEvent(boolean danger) {
		if (danger) {
			Beast wolf = new BeastFactory().createBeast();
			final Fight fight = new Fight(pj, wolf);

			JDialog jDialogEvent = new JDialog(topFrame, "Vous êtes attaqué !", true);
			jDialogEvent.setSize(600, 300);
			jDialogEvent.setLocationRelativeTo(topFrame);

			JPanel panEvent = new JPanel();
			panEvent.setLayout(new GridBagLayout());
			GridBagConstraints gbcEvent = new GridBagConstraints();
			gbcEvent.insets = new Insets(5, 5, 5, 5);

			gbcEvent.gridy = 0;
			gbcEvent.gridheight = 1;
			gbcEvent.gridx = 0;
			gbcEvent.gridwidth = 4;
			gbcEvent.anchor = GridBagConstraints.CENTER;
			gbcEvent.fill = GridBagConstraints.NONE;
			panEvent.add(new JLabel("COMBAT"), gbcEvent);

			// PLAYER
			gbcEvent.gridy = 1;
			gbcEvent.gridheight = 1;
			gbcEvent.gridx = 0;
			gbcEvent.gridwidth = 2;
			gbcEvent.anchor = GridBagConstraints.WEST;
			gbcEvent.fill = GridBagConstraints.NONE;
			panEvent.add(new JCharacter(pj), gbcEvent);

			// MONSTER
			gbcEvent.gridy = 1;
			gbcEvent.gridheight = 1;
			gbcEvent.gridx = 2;
			gbcEvent.gridwidth = 2;
			gbcEvent.anchor = GridBagConstraints.EAST;
			gbcEvent.fill = GridBagConstraints.NONE;
			panEvent.add(new JCharacter(wolf), gbcEvent);

			JButton jbAttaq = new JButton("Attaquer");
			gbcEvent.gridy = 5;
			gbcEvent.gridheight = 1;
			gbcEvent.gridx = 2;
			gbcEvent.gridwidth = 2;
			gbcEvent.anchor = GridBagConstraints.EAST;
			gbcEvent.fill = GridBagConstraints.NONE;
			panEvent.add(jbAttaq, gbcEvent);

			final JLabel outputAttaq = new JLabel("Init combat...");

			jbAttaq.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					fight.newRound();
					fight.pjAttack();
					fight.mobAttack();
					outputAttaq.setText("Vous attaquez !");
				}
			});

			gbcEvent.gridy = 7;
			gbcEvent.gridheight = 1;
			gbcEvent.gridx = 1;
			gbcEvent.gridwidth = 4;
			gbcEvent.anchor = GridBagConstraints.CENTER;
			gbcEvent.fill = GridBagConstraints.NONE;
			panEvent.add(outputAttaq, gbcEvent);

			jDialogEvent.add(panEvent);
			jDialogEvent.setVisible(true);

		}
	}
}
