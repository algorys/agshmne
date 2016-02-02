package io.github.algorys.agshmne.game.south;

import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.player.Player;

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
//		TODO
//		boolean danger = pj.getTile().isDanger();
//		if (danger) {
//			Beast wolf = new BeastFactory().createBeast();
//			final Fight fight = new Fight(pj, wolf);
//			JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
//			JFightDialog fightDialog = new JFightDialog(topFrame, fight);
//			fightDialog.setVisible(true);
//		}
	}
}
