package io.github.algorys.agshmne.JCaractest;

import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;

import io.github.algorys.agshmne.caracteristic.JCaracteristic;

public class JCaracteristicTest {

	public static void main(String[] args) {
		JFrame jf = new JFrame("Test JCaracteristic");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jf.getContentPane().add(new JCaracteristic());

		jf.setSize(jf.getPreferredSize());
		jf.setVisible(true);

		JFrame jfPlusieurs = new JFrame("Test JCaracteristic2");
		jfPlusieurs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jfPlusieurs.getContentPane().setLayout(new GridLayout(0, 1));

		final int MAX_FOR_ONE = 20;
		final JCaracteristic jcTotal = new JCaracteristic(MAX_FOR_ONE + 2, 2, 40);
		final int total = 10;
		final JCaracteristic jcPremier = new JCaracteristic(1, 1, MAX_FOR_ONE);
		final JCaracteristic jcDeuxieme = new JCaracteristic(1, 1, MAX_FOR_ONE);

		PropertyChangeListener pcl = new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				int spentPoints = jcPremier.getValue() + jcDeuxieme.getValue();
				int remainingPoints = total - spentPoints;
				jcPremier.setMaxValue(Math.min(remainingPoints + jcPremier.getValue(), MAX_FOR_ONE));
				jcDeuxieme.setMaxValue(Math.min(remainingPoints + jcDeuxieme.getValue(), MAX_FOR_ONE));
				// Test condition
//				jcPremier.setMaxValue(jcDeuxieme.getValue()+3);
//				jcDeuxieme.setMaxValue(jcPremier.getValue()+3);
//				jcPremier.setMinValue(jcDeuxieme.getValue()-3);
//				jcDeuxieme.setMinValue(jcPremier.getValue()-3);
			}
		};

		jcTotal.addPropertyChangeListener(JCaracteristic.PROPERTY_VALUE, pcl);
		jcPremier.addPropertyChangeListener(JCaracteristic.PROPERTY_VALUE, pcl);
		jcDeuxieme.addPropertyChangeListener(JCaracteristic.PROPERTY_VALUE, pcl);

		jfPlusieurs.getContentPane().add(jcTotal);
		jfPlusieurs.getContentPane().add(jcPremier);
		jfPlusieurs.getContentPane().add(jcDeuxieme);

		jfPlusieurs.setSize(jfPlusieurs.getPreferredSize());
		jfPlusieurs.setVisible(true);
	}

}
