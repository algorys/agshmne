package io.github.algorys.agshmne.map.city.shop;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import io.github.algorys.agshmne.items.stackable.IStackableItem;

@SuppressWarnings("serial")
public class JStackChoice extends JPanel {
	private JSlider slide;
	private int nbToSell;

	public JStackChoice(IStackableItem item, int max) {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbcChoice = new GridBagConstraints();
		gbcChoice.insets = new Insets(5, 5, 5, 5);

		// Titre
		gbcChoice.gridy = 0;
		gbcChoice.gridheight = 1;
		gbcChoice.gridx = 0;
		gbcChoice.gridwidth = 4;
		gbcChoice.anchor = GridBagConstraints.CENTER;
		gbcChoice.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Faites votre choix :"), gbcChoice);

		slide = new JSlider();
		slide.setMaximum(max);
		slide.setMinimum(1);
		slide.setPaintTicks(true);
		slide.setPaintLabels(true);
		slide.setMinorTickSpacing(1);
		final JLabel labelCount = new JLabel("Quantité : " + slide.getValue());

		// LabelCount
		gbcChoice.gridy = 1;
		gbcChoice.gridheight = 1;
		gbcChoice.gridx = 0;
		gbcChoice.gridwidth = 4;
		gbcChoice.anchor = GridBagConstraints.CENTER;
		gbcChoice.fill = GridBagConstraints.NONE;
		this.add(labelCount, gbcChoice);

		slide.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				labelCount.setText("Quantité : " + ((JSlider) event.getSource()).getValue());
			}
		});

		gbcChoice.gridy = 3;
		gbcChoice.gridheight = 1;
		gbcChoice.gridx = 0;
		gbcChoice.gridwidth = 4;
		gbcChoice.anchor = GridBagConstraints.CENTER;
		gbcChoice.fill = GridBagConstraints.NONE;
		this.add(slide, gbcChoice);

		// Bouton Valider
		gbcChoice.gridy = 4;
		gbcChoice.gridheight = 1;
		gbcChoice.gridx = 0;
		gbcChoice.gridwidth = 2;
		gbcChoice.anchor = GridBagConstraints.CENTER;
		gbcChoice.fill = GridBagConstraints.NONE;
		JButton validate = new JButton("Valider");
		validate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nbToSell = slide.getValue();
				SwingUtilities.windowForComponent(JStackChoice.this).dispose();
			}
		});
		this.add(validate, gbcChoice);

		// Bouton Annuler
		gbcChoice.gridy = 4;
		gbcChoice.gridheight = 1;
		gbcChoice.gridx = 2;
		gbcChoice.gridwidth = 2;
		gbcChoice.anchor = GridBagConstraints.CENTER;
		gbcChoice.fill = GridBagConstraints.NONE;
		JButton cancel = new JButton("Annuler");
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.windowForComponent(JStackChoice.this).dispose();

			}
		});
		this.add(cancel, gbcChoice);
	}

	public int getNbToSell() {
		return nbToSell;
	}
}
