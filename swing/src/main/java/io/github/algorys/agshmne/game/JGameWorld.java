package io.github.algorys.agshmne.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import io.github.algorys.agshmne.deplacement.Position;
import io.github.algorys.agshmne.personnage.Personnage;
import io.github.algorys.agshmne.region.JRegion;
import io.github.algorys.agshmne.region.Region;

public class JGameWorld extends JPanel{

	private Region region = new Region();
	private final Personnage pj;
	
	public JGameWorld(Region region, final Personnage pj){		
		this.pj = pj;
		this.region = region;
		
		this.add(new JRegion(pj));
		
		this.setBackground(Color.BLACK);

		this.setSize(new Dimension(400,400));
		//this.setVisible(true);
	}
}