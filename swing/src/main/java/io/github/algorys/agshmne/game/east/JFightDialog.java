package io.github.algorys.agshmne.game.east;

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
import io.github.algorys.agshmne.game.south.JCharacter;

@SuppressWarnings("serial")
public class JFightDialog extends JDialog{
	
	public JFightDialog(Frame topFrame, final Fight fight) {
		super(topFrame, "Vous êtes attaqué !", true);
		final Player pj = (Player) fight.getLeftOpponent();
		final Beast mob = (Beast) fight.getRightOpponent();
				
		this.setSize(600, 300);
		this.setLocationRelativeTo(topFrame);

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
		panEvent.add(new JCharacter(mob), gbcEvent);

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
				JFightDialog.this.dispose();
			}
		});

		jbAttaq.addActionListener(new ActionListener() {
			public String stringAttack(int pjDamage, int mobDamage) {
				String styleAttack;
				if (pjDamage == mobDamage) {
					styleAttack = "Match nul !";
				} else if (pjDamage >= mobDamage) {
					styleAttack = pj.getName() + " mène une belle attaque...";
				} else {
					styleAttack = mob.getName() + " vous en met plein la tronche !!!";
				}
				return styleAttack;
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// Combat
				fight.newRound();
				int pjAttack = fight.pjAttack();
				int mobAttack = fight.mobAttack();
				// Descriptions
				String stringDamage = this.stringAttack(pjAttack, mobAttack);
				outputAttaq.setText(stringDamage);
				String degats = "Dégats : " + pj.getName() + " [" + pjAttack + "],  " + mob.getName() + " ["
						+ mobAttack + "]";
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

		this.add(panEvent);
	}
}
