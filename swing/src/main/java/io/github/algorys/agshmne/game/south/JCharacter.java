package io.github.algorys.agshmne.game.south;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.character.Vital;

@SuppressWarnings("serial")
public class JCharacter extends JPanel {

	public JCharacter(Character character) {
		super(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		this.setBackground(Color.black);
		
		this.setBorder(new LineBorder(Color.blue, 3, true));
		this.setOpaque(false);

		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		JLabel jlName = new JLabel(character.getName());
		jlName.setForeground(Color.cyan);
		this.add(jlName, gbc);

		gbc.gridwidth = 1;

		gbc.gridy = 1;
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.WEST;
		JLabel strVie = new JLabel("Vie :");
		strVie.setForeground(Color.white);
		this.add(strVie, gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.EAST;
		final JLabel jlVie = new JLabel("" + character.getVital().getVie());
		jlVie.setForeground(Color.green);
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
		JLabel strMana = new JLabel("Mana :");
		strMana.setForeground(Color.white);
		this.add(strMana, gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.EAST;
		JLabel jlMana = new JLabel("" + character.getVital().getMana());
		jlMana.setForeground(new Color(51,153,255));
		this.add(jlMana, gbc);

		gbc.gridy = 3;
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.WEST;
		JLabel strAttack = new JLabel("Attaque :");
		strAttack.setForeground(Color.white);
		this.add(strAttack, gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.EAST;
		JLabel jlAttack = new JLabel("" + character.getCurrentAttributes().getDEX());
		jlAttack.setForeground(Color.red);
		this.add(jlAttack, gbc);
	}

}
