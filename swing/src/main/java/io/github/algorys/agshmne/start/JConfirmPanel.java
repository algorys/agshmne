package io.github.algorys.agshmne.start;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import io.github.algorys.agshmne.character.Character;

public class JConfirmPanel extends JPanel {
	
	public JConfirmPanel(JSocialPanel jpSocial, JCaracPanel carac, JCompPanel jpComp, JInvPanel jpInv) {
		super();
		
		// GidBag Layout
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbcConfirm = new GridBagConstraints();
		// Ajuste la taille du GridBag
		gbcConfirm.insets = new Insets(5, 5, 5, 5);

		// TITRE
		gbcConfirm.gridy = 0;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.CENTER;
		gbcConfirm.fill = GridBagConstraints.NONE;
		this.add(new JLabel("CONFIRMATION"), gbcConfirm);
		
		// CARAC
		gbcConfirm.gridy = 1;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.CENTER;
		gbcConfirm.fill = GridBagConstraints.NONE;
		this.add(new JLabel("- Caractéristiques -"), gbcConfirm);
		
		// CARACTERISTIQUES
		// FOR
		gbcConfirm.gridy = 2;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JTextField jtForce = new JTextField("Force : " + carac.getFOR());
		jtForce.setEditable(false);
		this.add(jtForce, gbcConfirm);

		
		// DEX
		gbcConfirm.gridy = 3;
		gbcConfirm.gridheight = 1;
		gbcConfirm.gridx = 0;
		gbcConfirm.gridwidth = 1;
		gbcConfirm.anchor = GridBagConstraints.WEST;
		gbcConfirm.fill = GridBagConstraints.NONE;
		JTextField jtDexterite = new JTextField("Dextérité : " + carac.getDEX());
		jtDexterite.setEditable(false);
		this.add(jtDexterite, gbcConfirm);
		
	}

}
