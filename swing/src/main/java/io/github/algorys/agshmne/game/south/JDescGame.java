package io.github.algorys.agshmne.game.south;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	public JDescGame(Player pj){
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
	}
	
	public void updateLabels(Player pj) {
		titleHistory.setTitle("Region : " + pj.getTile().getDesc());
		civilized.setCivilized(pj.getTile().isCivilized());
		this.updateEvent(pj);
	}
	
	public void updateEvent(Player pj) {
		boolean danger = pj.getTile().isDanger();
		if (danger) {
			Beast wolf = new BeastFactory().createBeast();
			final Fight fight = new Fight(pj, wolf);
			initJFight(pj, wolf, fight);
		}
	}

	private void initJFight(final Player pj, final Beast wolf, final Fight fight) {
		JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
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
		
		gbcEvent.gridy = 7;
		gbcEvent.gridheight = 1;
		gbcEvent.gridx = 1;
		gbcEvent.gridwidth = 4;
		gbcEvent.anchor = GridBagConstraints.CENTER;
		gbcEvent.fill = GridBagConstraints.NONE;
		final JLabel outputAttaq = new JLabel("Init combat...");
		panEvent.add(outputAttaq, gbcEvent);
		
		gbcEvent.gridy = 8;
		gbcEvent.gridheight = 1;
		gbcEvent.gridx = 1;
		gbcEvent.gridwidth = 4;
		gbcEvent.anchor = GridBagConstraints.CENTER;
		gbcEvent.fill = GridBagConstraints.NONE;
		final JLabel jlDamage = new JLabel("---");
		panEvent.add(jlDamage, gbcEvent);

		jbAttaq.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fight.newRound();
				fight.pjAttack();
				fight.mobAttack();
				String stringDamage = fight.stringAttack();
				outputAttaq.setText(stringDamage);
				String degats = fight.stringDamage();
				jlDamage.setText(degats);
			}
		});

		jDialogEvent.add(panEvent);
		jDialogEvent.setVisible(true);
	}
}
