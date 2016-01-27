package io.github.algorys.agshmne.game.south;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JEvent extends JPanel {
	JLabel jlDanger = new JLabel("Aucun Danger");
	
	public JEvent(boolean danger) {
		this.setPreferredSize(new Dimension(700, 20));
		this.setBackground(Color.lightGray);
		if(danger) {
			jlDanger.setText("!!! DANGER !!!");
		} else {
			jlDanger.setText("Aucun Danger");
		}
		
		this.add(jlDanger);
	}
	
	public void setJlabelDanger(boolean danger) {
		if(danger) {
			jlDanger.setText("!!! DANGER !!!");
		} else {
			jlDanger.setText("Aucun Danger");
		}
	}
}
