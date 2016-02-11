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

@SuppressWarnings("serial")
public class JCityCenter extends JPanel implements PropertyChangeListener {
	private City city;
	private Player pj;
	private JLabel jlTitle;
	
	public JCityCenter(Player pj) {
		this.pj = pj;
		pj.addPropertyChangeListener(Player.PROPERTY_POSITION, this);
		if(pj.getTile().isCivilized()) {
			city = pj.getTile().getCity();
		} else {
			city = City.NONE;
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
		jlTitle = new JLabel(city.getName());
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
		JButton jbTavern = new JButton("Boire un coup !");
		jbTavern.setEnabled(false);
		this.add(jbTavern, gbcCityCenter);
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(pj.getTile().isCivilized()) {
			city = pj.getTile().getCity();
		} else {
			city = City.NONE;
		}
		jlTitle.setText(city.getName());
		
	}
}
