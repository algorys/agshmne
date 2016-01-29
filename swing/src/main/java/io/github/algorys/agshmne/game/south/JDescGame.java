package io.github.algorys.agshmne.game.south;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
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
public class JDescGame extends JPanel {
	private JTitleHistory titleHistory;
	private JCivilized civilized;

	public JDescGame(Player pj) {
		this.setPreferredSize(new Dimension(710, 100));
		BoxLayout blSouth = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(blSouth);

		// Description Région
		titleHistory = new JTitleHistory(pj);
		titleHistory.setTitle("Region : " + pj.getTile().getDesc());

		// Région Civilisée
		this.civilized = new JCivilized(pj);
		this.civilized.setCivilized(pj.getTile().isCivilized());

		// TODO Danger aux alentour (Rouge)
		this.updateEvent(pj);

		// TODO Actions Personnage**this.add(titleHistory);

		this.add(titleHistory);
		this.add(civilized);

		pj.addPropertyChangeListener(Player.PROPERTY_POSITION, new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getSource() instanceof Player) {
					Player pj = (Player) evt.getSource();
					titleHistory.setTitle("Region : " + pj.getTile().getDesc());
					civilized.setCivilized(pj.getTile().isCivilized());
					updateEvent(pj);
				}
			}
		});
	}

	public void updateEvent(Player pj) {
		boolean danger = pj.getTile().isDanger();
		if (danger) {
			Beast wolf = new BeastFactory().createBeast();
			final Fight fight = new Fight(pj, wolf);
			initJFight(pj, wolf, fight);
		}
	}

	private void initJFight(Player pj, Beast wolf, final Fight fight) {
		JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
		final JDialog jDialogEvent = new JDialog(topFrame, "Vous êtes attaqué !", true);
		jDialogEvent.setSize(600, 300);
		jDialogEvent.setLocationRelativeTo(topFrame);

		JPanel panEvent = new JPanel();
		panEvent.setLayout(new GridBagLayout());
		panEvent.setBackground(Color.black);
		GridBagConstraints gbcEvent = new GridBagConstraints();
		gbcEvent.insets = new Insets(5, 5, 5, 5);

		gbcEvent.gridy = 0;
		gbcEvent.gridheight = 1;
		gbcEvent.gridx = 0;
		gbcEvent.gridwidth = 4;
		gbcEvent.anchor = GridBagConstraints.CENTER;
		gbcEvent.fill = GridBagConstraints.NONE;
		JLabel title = new JLabel("COMBAT");
		title.setForeground(Color.red);
		panEvent.add(title, gbcEvent);

		// PLAYER
		gbcEvent.gridy = 1;
		gbcEvent.gridheight = 1;
		gbcEvent.gridx = 1;
		gbcEvent.gridwidth = 1;
		gbcEvent.anchor = GridBagConstraints.WEST;
		gbcEvent.fill = GridBagConstraints.NONE;
		panEvent.add(new JCharacter(pj), gbcEvent);

		// MONSTER
		gbcEvent.gridy = 1;
		gbcEvent.gridheight = 1;
		gbcEvent.gridx = 2;
		gbcEvent.gridwidth = 1;
		gbcEvent.anchor = GridBagConstraints.EAST;
		gbcEvent.fill = GridBagConstraints.NONE;
		panEvent.add(new JCharacter(wolf), gbcEvent);

		final JButton jbAttaq = new JButton("Attaquer");
		gbcEvent.gridy = 5;
		gbcEvent.gridheight = 1;
		gbcEvent.gridx = 2;
		gbcEvent.gridwidth = 1;
		gbcEvent.anchor = GridBagConstraints.EAST;
		gbcEvent.fill = GridBagConstraints.NONE;
		panEvent.add(jbAttaq, gbcEvent);

		final JButton jbDefense = new JButton("Défense");
		gbcEvent.gridy = 5;
		gbcEvent.gridheight = 1;
		gbcEvent.gridx = 1;
		gbcEvent.gridwidth = 1;
		gbcEvent.anchor = GridBagConstraints.EAST;
		gbcEvent.fill = GridBagConstraints.NONE;
		panEvent.add(jbDefense, gbcEvent);

		gbcEvent.gridy = 7;
		gbcEvent.gridheight = 1;
		gbcEvent.gridx = 0;
		gbcEvent.gridwidth = 4;
		gbcEvent.anchor = GridBagConstraints.CENTER;
		gbcEvent.fill = GridBagConstraints.NONE;
		final JLabel outputAttaq = new JLabel("Init combat...");
		outputAttaq.setForeground(Color.magenta);
		panEvent.add(outputAttaq, gbcEvent);

		gbcEvent.gridy = 8;
		gbcEvent.gridheight = 1;
		gbcEvent.gridx = 0;
		gbcEvent.gridwidth = 4;
		gbcEvent.anchor = GridBagConstraints.CENTER;
		gbcEvent.fill = GridBagConstraints.NONE;
		final JLabel jlDamage = new JLabel("---");
		jlDamage.setForeground(Color.cyan);
		panEvent.add(jlDamage, gbcEvent);

		final JButton jbQuit = new JButton("Continuer le combat...");
		jbQuit.setEnabled(false);
		gbcEvent.gridy = 9;
		gbcEvent.gridheight = 1;
		gbcEvent.gridx = 1;
		gbcEvent.gridwidth = 2;
		gbcEvent.anchor = GridBagConstraints.CENTER;
		gbcEvent.fill = GridBagConstraints.NONE;
		panEvent.add(jbQuit, gbcEvent);
		jbQuit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jDialogEvent.dispose();
			}
		});

		jbAttaq.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Combat
				fight.newRound();
				fight.pjAttack();
				fight.mobAttack();
				// Descriptions
				String stringDamage = fight.stringAttack();
				outputAttaq.setText(stringDamage);
				String degats = fight.stringDamage();
				jlDamage.setText(degats);
				// Fini ?
				if (fight.isFinish()) {
					jbQuit.setText("Quitter le combat");
					jbQuit.setEnabled(true);

					jbAttaq.setEnabled(false);
					jbDefense.setEnabled(false);
				}
			}
		});

		gbcEvent.gridy = 0;
		gbcEvent.gridheight = 1;
		gbcEvent.gridx = 0;
		gbcEvent.gridwidth = 1;
		gbcEvent.weightx = 50;
		panEvent.add(new JLabel(), gbcEvent);

		gbcEvent.gridy = 0;
		gbcEvent.gridheight = 1;
		gbcEvent.gridx = 3;
		gbcEvent.gridwidth = 1;
		gbcEvent.weightx = 50;
		panEvent.add(new JLabel(), gbcEvent);

		jDialogEvent.add(panEvent);
		jDialogEvent.setVisible(true);
	}
}
