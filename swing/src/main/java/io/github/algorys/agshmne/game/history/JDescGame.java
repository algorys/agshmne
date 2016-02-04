package io.github.algorys.agshmne.game.history;

import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.map.JMapTitle;
import io.github.algorys.agshmne.map.city.JCivilized;

@SuppressWarnings("serial")
public class JDescGame extends JPanel {
	private JMapTitle titleHistory;
	private JCivilized civilized;

	public JDescGame(Player pj) {
		this.setPreferredSize(new Dimension(710, 100));
		BoxLayout blSouth = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(blSouth);

		// Description Région
		titleHistory = new JMapTitle(pj);
		titleHistory.setTitle("Region : " + pj.getTile().getDesc());

		// Région Civilisée
		this.civilized = new JCivilized(pj);
		this.civilized.setCivilized(pj.getTile().isCivilized());

		this.add(titleHistory);
		this.add(civilized);

		pj.addPropertyChangeListener(Player.PROPERTY_POSITION, new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getSource() instanceof Player) {
					Player pj = (Player) evt.getSource();
					titleHistory.setTitle("Region : " + pj.getTile().getDesc());
					civilized.setCivilized(pj.getTile().isCivilized());
				}
			}
		});
	}
}
