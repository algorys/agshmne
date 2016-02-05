package io.github.algorys.agshmne.map.city;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JCity extends JPanel {

	public JCity() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbcCharacter = new GridBagConstraints();
		// Ajuste la taille du GridBag
		gbcCharacter.insets = new Insets(5, 5, 5, 5);
	}
}

