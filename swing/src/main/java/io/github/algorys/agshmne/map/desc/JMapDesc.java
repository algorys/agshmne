package io.github.algorys.agshmne.map.desc;

import java.awt.Color;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import io.github.algorys.agshmne.Game;
import io.github.algorys.agshmne.character.player.Player;

@SuppressWarnings("serial")
public class JMapDesc extends JPanel {
	private JMapTitle titleHistory;
	private JMapCiv civilized;
	private JMapXY xy;

	public JMapDesc(Game game) {
		Player pj = game.getPlayer();
		this.setPreferredSize(new Dimension(700, 100));
		BoxLayout blSouth = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setBackground(Color.black);
		this.setLayout(blSouth);

		// Description Région
		titleHistory = new JMapTitle(pj);
		titleHistory.setTitle("Region : " + pj.getTile().getDesc());
		
		// Position
		this.xy = new JMapXY(game);
		this.xy.setDescPosition(game);

		// Région Civilisée
		this.civilized = new JMapCiv(pj);
		this.civilized.setCivilized(pj.getTile().isCivilized());

		this.add(titleHistory);
		this.add(xy);
		this.add(civilized);

		game.addPropertyChangeListener(Game.PROPERTY_POSITION, new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getSource() instanceof Game) {
					Game game = (Game)evt.getSource();
					titleHistory.setTitle("Region : " + game.getPlayer().getTile().getDesc());
					civilized.setCivilized(game.getPlayer().getTile().isCivilized());
					xy.setDescPosition(game);
				}
			}
		});
	}
}
