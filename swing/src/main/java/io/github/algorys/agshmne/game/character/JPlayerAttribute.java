package io.github.algorys.agshmne.game.character;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.Attribute;

@SuppressWarnings("serial")
public class JPlayerAttribute extends JPanel {
	private JLabel jlForCurrent;
	private JLabel jlDexCurrent;
	private JLabel jlConCurrent;
	private JLabel jlIntCurrent;
	private JLabel jlChaCurrent;

	public JPlayerAttribute(Attribute attributes, Attribute currentAttributes) {
		super(new GridBagLayout());
		this.setOpaque(false);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.weightx = 1;

		// FOR
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
		JLabel jlForBase = new JLabel("FOR : ");
		jlForBase.setForeground(Color.white);
		this.add(jlForBase, gbc);

		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		jlForBase = new JLabel("" + attributes.getFOR());
		jlForBase.setForeground(Color.white);
		this.add(jlForBase, gbc);

		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridx = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
		jlForCurrent = new JLabel("(" + currentAttributes.getFOR() + ")");
		jlForCurrent.setForeground(Color.GREEN);
		this.add(jlForCurrent, gbc);

		// DEX
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
		JLabel jlDexTitle = new JLabel("DEX : ");
		jlDexTitle.setForeground(Color.white);
		this.add(jlDexTitle, gbc);

		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		JLabel jlDexBase = new JLabel("" + attributes.getDEX());
		jlDexBase.setForeground(Color.white);
		this.add(jlDexBase, gbc);

		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridx = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
		jlDexCurrent = new JLabel("(" + currentAttributes.getDEX() + ")");
		jlDexCurrent.setForeground(Color.GREEN);
		this.add(jlDexCurrent, gbc);

		// CON
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
		JLabel jlConTitle = new JLabel("CON : ");
		jlConTitle.setForeground(Color.white);
		this.add(jlConTitle, gbc);

		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		JLabel jlConBase = new JLabel("" + attributes.getCON());
		jlConBase.setForeground(Color.white);
		this.add(jlConBase, gbc);

		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridx = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
		jlConCurrent = new JLabel("(" + currentAttributes.getCON() + ")");
		jlConCurrent.setForeground(Color.GREEN);
		this.add(jlConCurrent, gbc);

		// INT
		gbc.gridy = 3;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
		JLabel jlIntTitle = new JLabel("INT : ");
		jlIntTitle.setForeground(Color.white);
		this.add(jlIntTitle, gbc);

		gbc.gridy = 3;
		gbc.gridheight = 1;
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		JLabel jlIntBase = new JLabel("" + attributes.getINT());
		jlIntBase.setForeground(Color.white);
		this.add(jlIntBase, gbc);

		gbc.gridy = 3;
		gbc.gridheight = 1;
		gbc.gridx = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
		jlIntCurrent = new JLabel("(" + currentAttributes.getINT() + ")");
		jlIntCurrent.setForeground(Color.GREEN);
		this.add(jlIntCurrent, gbc);

		// CHA
		gbc.gridy = 4;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
		JLabel jlChaTitle = new JLabel("CHA : ");
		jlChaTitle.setForeground(Color.white);
		this.add(jlChaTitle, gbc);

		gbc.gridy = 4;
		gbc.gridheight = 1;
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		JLabel jlChaBase = new JLabel("" + attributes.getCHA());
		jlChaBase.setForeground(Color.white);
		this.add(jlChaBase, gbc);

		gbc.gridy = 4;
		gbc.gridheight = 1;
		gbc.gridx = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
		jlChaCurrent = new JLabel("(" + currentAttributes.getCHA() + ")");
		jlChaCurrent.setForeground(Color.GREEN);
		this.add(jlChaCurrent, gbc);
	}
	
	public void updateCurrentAttributes(Attribute currentAttributes) {
		jlForCurrent.setText("(" + currentAttributes.getFOR() + ")");
		jlDexCurrent.setText("(" + currentAttributes.getDEX() + ")");
		jlConCurrent.setText("(" + currentAttributes.getCON() + ")");
		jlIntCurrent.setText("(" + currentAttributes.getINT() + ")");
		jlChaCurrent.setText("(" + currentAttributes.getCHA() + ")");
	}
}
