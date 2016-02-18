package io.github.algorys.agshmne.map.city;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.game.actions.city.CityEatAction;
import io.github.algorys.agshmne.map.tile.Tile;

@SuppressWarnings("serial")
public class JCityCenter extends JPanel {
	private JLabel jlTitle;

	public JCityCenter(final Player pj) {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbcCityCenter = new GridBagConstraints();
		gbcCityCenter.insets = new Insets(5, 5, 5, 5);

		// TITRE
		gbcCityCenter.gridy = 0;
		gbcCityCenter.gridheight = 1;
		gbcCityCenter.gridx = 0;
		gbcCityCenter.gridwidth = 4;
		gbcCityCenter.anchor = GridBagConstraints.CENTER;
		gbcCityCenter.fill = GridBagConstraints.NONE;
		jlTitle = new JLabel();
		this.add(jlTitle, gbcCityCenter);

		// Auberge
		gbcCityCenter.gridy = 1;
		gbcCityCenter.gridheight = 1;
		gbcCityCenter.gridx = 0;
		gbcCityCenter.gridwidth = 2;
		gbcCityCenter.anchor = GridBagConstraints.WEST;
		gbcCityCenter.fill = GridBagConstraints.NONE;
		JLabel jlInn = new JLabel("Auberge");
		this.add(jlInn, gbcCityCenter);

		gbcCityCenter.gridy = 1;
		gbcCityCenter.gridheight = 1;
		gbcCityCenter.gridx = 2;
		gbcCityCenter.gridwidth = 2;
		gbcCityCenter.anchor = GridBagConstraints.CENTER;
		gbcCityCenter.fill = GridBagConstraints.NONE;
		JButton jbInn = new JButton("Se reposer");
		jbInn.setEnabled(false);
		this.add(jbInn, gbcCityCenter);

		// Taverne
		gbcCityCenter.gridy = 2;
		gbcCityCenter.gridheight = 1;
		gbcCityCenter.gridx = 0;
		gbcCityCenter.gridwidth = 2;
		gbcCityCenter.anchor = GridBagConstraints.WEST;
		gbcCityCenter.fill = GridBagConstraints.NONE;
		JLabel jlTavern = new JLabel("Taverne");
		this.add(jlTavern, gbcCityCenter);

		gbcCityCenter.gridy = 2;
		gbcCityCenter.gridheight = 1;
		gbcCityCenter.gridx = 2;
		gbcCityCenter.gridwidth = 2;
		gbcCityCenter.anchor = GridBagConstraints.CENTER;
		gbcCityCenter.fill = GridBagConstraints.NONE;
		JButton jbTavern = new JButton("Manger un repas !");
		// jbTavern.setEnabled(false);
		jbTavern.setAction(new CityEatAction(pj));

		this.add(jbTavern, gbcCityCenter);

		pj.addPropertyChangeListener(Player.PROPERTY_TILE, new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getNewValue() instanceof Tile) {
					updateTitle((Tile) evt.getNewValue());
				}
			}
		});
		updateTitle(pj.getTile());
	}

	private void updateTitle(Tile newTile) {
		final City city;
		if (newTile.isCivilized()) {
			city = newTile.getCity();
		} else {
			city = City.NONE;
		}
		jlTitle.setText(city.getName());
	}

}
