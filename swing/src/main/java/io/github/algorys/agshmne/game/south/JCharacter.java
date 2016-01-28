package io.github.algorys.agshmne.game.south;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.character.Vital;

@SuppressWarnings("serial")
public class JCharacter extends JPanel {

	public JCharacter(Character character) {
		super(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		this.add(new JLabel(character.getName()), gbc);

		gbc.gridwidth = 1;

		gbc.gridy = 1;
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.WEST;
		this.add(new JLabel("Vie :"), gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.EAST;
		final JLabel jlVie = new JLabel("" + character.getVital().getVie());
		this.add(jlVie, gbc);
		character.getVital().addPropertyChangeListener(Vital.PROPERTY_VIE, new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				jlVie.setText(evt.getNewValue().toString());
			}
		});

		gbc.gridy = 2;
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.WEST;
		this.add(new JLabel("Mana :"), gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.EAST;
		this.add(new JLabel("" + character.getVital().getMana()), gbc);

		gbc.gridy = 3;
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.WEST;
		this.add(new JLabel("Attaque :"), gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.EAST;
		this.add(new JLabel("" + character.getCurrentAttributes().getDEX()), gbc);
	}

}
