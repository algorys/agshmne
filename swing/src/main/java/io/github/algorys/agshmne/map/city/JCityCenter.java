package io.github.algorys.agshmne.map.city;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.player.Player;

@SuppressWarnings("serial")
public class JCityCenter extends JPanel implements PropertyChangeListener {
	private City city;
	private Player pj;
	private JLabel jpTitle;
	
	public JCityCenter(Player pj) {
		this.pj = pj;
		pj.addPropertyChangeListener(Player.PROPERTY_POSITION, this);
		if(pj.getTile().isCivilized()) {
			city = pj.getTile().getCity();
		} else {
			city = new City(0);
		}
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
		jpTitle = new JLabel(city.getName());
		this.add(jpTitle, gbcCityCenter);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(pj.getTile().isCivilized()) {
			city = pj.getTile().getCity();
		} else {
			city = new City(0);
		}
		jpTitle.setText(city.getName());
		
	}
}
