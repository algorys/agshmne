package io.github.algorys.agshmne.window;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class JSocialPanel extends JPanel {
	private JTextField jtfName;

	public JSocialPanel() {
		super();
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbcSocial = new GridBagConstraints();
		gbcSocial.insets = new Insets(5, 5, 5, 5);

		gbcSocial.gridy = 0;
		gbcSocial.gridheight = 1;
		gbcSocial.gridx = 0;
		gbcSocial.gridwidth = 2;
		gbcSocial.anchor = GridBagConstraints.CENTER;
		gbcSocial.fill = GridBagConstraints.NONE;

		this.add(new JLabel("FICHE PERSONNAGE JOUEUR"), gbcSocial);

		gbcSocial.gridy = 1;
		gbcSocial.gridheight = 1;
		gbcSocial.gridx = 0;
		gbcSocial.gridwidth = 1;
		gbcSocial.anchor = GridBagConstraints.EAST;
		gbcSocial.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Nom"), gbcSocial);

		gbcSocial.gridy = 1;
		gbcSocial.gridheight = 1;
		gbcSocial.gridx = 1;
		gbcSocial.gridwidth = 1;
		gbcSocial.anchor = GridBagConstraints.WEST;
		gbcSocial.fill = GridBagConstraints.HORIZONTAL;
		jtfName = new JTextField();
		this.add(jtfName, gbcSocial);

		gbcSocial.gridy = 2;
		gbcSocial.gridheight = 1;
		gbcSocial.gridx = 0;
		gbcSocial.gridwidth = 1;
		gbcSocial.anchor = GridBagConstraints.EAST;
		gbcSocial.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Background"), gbcSocial);

		gbcSocial.gridy = 2;
		gbcSocial.gridheight = 1;
		gbcSocial.gridx = 1;
		gbcSocial.gridwidth = 1;
		gbcSocial.anchor = GridBagConstraints.WEST;
		gbcSocial.fill = GridBagConstraints.NONE;
		JTextArea jtaBackground = new JTextArea(5, 50);
		jtaBackground.setBorder(new BevelBorder(BevelBorder.LOWERED));
		this.add(jtaBackground, gbcSocial);
	}

	public String getMyName() {
		return jtfName.getText();
	}
}