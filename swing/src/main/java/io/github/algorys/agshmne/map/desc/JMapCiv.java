package io.github.algorys.agshmne.map.desc;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.player.Player;

@SuppressWarnings("serial")
public class JMapCiv extends JPanel{
	JLabel jlCiv = new JLabel("Aucune civilisation connue...");
	boolean civilized;
	
	public JMapCiv(Player pj){
		this.setPreferredSize(new Dimension(700, 20));
		this.setBackground(Color.black);
		jlCiv.setForeground(Color.green);
		if(pj.getTile().isCivilized()){
			this.jlCiv.setText("Civilisé");
		} else {
			this.jlCiv.setText("Aucune civilisation connue...");
		}
		this.add(jlCiv);
	}

	public void setCivilized(boolean isCivilized) {
		if(isCivilized){
			this.jlCiv.setText("Civilisé");
		} else {
			this.jlCiv.setText("Aucune civilisation connue...");
		}
	}
}

