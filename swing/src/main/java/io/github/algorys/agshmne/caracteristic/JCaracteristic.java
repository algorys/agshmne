package io.github.algorys.agshmne.caracteristic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 * Affichage d'une valeur des caractéristiques dans la fiche de personnage.
 * 
 * Les invariants :
 * <ul>
 * <li>minValue <= value <= maxValue</li>
 * <li>minus.enabled == value > minValue</li>
 * <li>plus.enabled == value < maxValue</li>
 * </ul>
 */
public class JCaracteristic extends JPanel {
	public static final String PROPERTY_VALUE = "value";
	public static final String PROPERTY_MIN_VALUE = "minValue";
	public static final String PROPERTY_MAX_VALUE = "maxValue";
	private int value;
	private int minValue;
	private int maxValue;
	private JButton jbMinus;
	private JButton jbPlus;
	private JLabel jlValue;

	public JCaracteristic() {
		this(1, 1, 20);
	}
	
	public JCaracteristic(int value, int minValue, int maxValue) {
		this.value = value;
		this.minValue = minValue;
		this.maxValue = maxValue;

		jbMinus = new JButton("-");
		jbPlus = new JButton("+");
		jlValue = new JLabel(Integer.toString(value));
		jlValue.setBorder(new BevelBorder(BevelBorder.LOWERED));

		this.add(jbMinus);
		this.add(jlValue);
		this.add(jbPlus);

		jbMinus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JCaracteristic.this.value > JCaracteristic.this.minValue) {
					setValue(JCaracteristic.this.value - 1);
				}
			}
		});
		jbPlus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JCaracteristic.this.value < JCaracteristic.this.maxValue) {
					setValue(JCaracteristic.this.value + 1);
				}
			}
		});

		this.addPropertyChangeListener(PROPERTY_VALUE, new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				updateView();
			}
		});

		this.updateView();
	}

	public int getValue() {
		return value;
	}

	private void updateView() {
		jlValue.setText(Integer.toString(this.value));

		if (this.value == this.minValue) {
			jbMinus.setEnabled(false);
		} else {
			jbMinus.setEnabled(true);
		}

		if (this.value == this.maxValue) {
			jbPlus.setEnabled(false);
		} else {
			jbPlus.setEnabled(true);
		}
	}

	public void setValue(int value) {
		if (value < this.minValue)
			throw new IllegalArgumentException(
					"value ne peut pas être inférieur à minValue(" + minValue + ") : reçu " + value);
		if (value > this.maxValue)
			throw new IllegalArgumentException(
					"value ne peut pas être supérieur à maxValue(" + maxValue + ") : reçu " + value);

		int oldValue = this.value;
		this.value = value;
		this.firePropertyChange(PROPERTY_VALUE, oldValue, value);

		this.updateView();
	}

	public int getMinValue() {
		return minValue;
	}

	public void setMinValue(int minValue) {
		if (minValue <= this.maxValue) {
			int oldMinValue = this.minValue;
			this.minValue = minValue;
			this.firePropertyChange(PROPERTY_MIN_VALUE, oldMinValue, minValue);
			if (this.value < this.minValue) {
				this.setValue(this.minValue);
			}
			this.updateView();
		}
	}

	public int getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(int maxValue) {
		if (maxValue >= this.minValue) {
			int oldMaxValue = this.maxValue;
			this.maxValue = maxValue;
			this.firePropertyChange(PROPERTY_MAX_VALUE, oldMaxValue, maxValue);
			if (this.value > this.maxValue) {
				this.setValue(this.maxValue);
			}
			this.updateView();
		}
	}
}
