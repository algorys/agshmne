package io.github.algorys.agshmne.game.mainpanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import io.github.algorys.agshmne.Game;
import io.github.algorys.agshmne.game.actions.ActionCharacter;
import io.github.algorys.agshmne.tile.JTileInventory;

@SuppressWarnings("serial")
public class JPanRight extends JPanel {
	public JPanRight(Game game) {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		gbc.gridy = 0;
		this.add(new JLabel("Objets au sol : "), gbc);
		gbc.gridy = 1;
		this.add(new JTileInventory(game.getPlayer()), gbc);

		gbc.gridy = 2;
		this.add(new JLabel("Actions générales"), gbc);
		gbc.gridy = 3;
		this.add(new ActionCharacter(game), gbc);
	}
}
