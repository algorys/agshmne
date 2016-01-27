package io.github.algorys.agshmne.game;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.map.region.Region;
import io.github.algorys.agshmne.region.JRegion;

@SuppressWarnings("serial")
public class JGameWorld extends JPanel{
	public JGameWorld(Region region, final Character pj){		
		this.add(new JRegion(pj));
		
		this.setBackground(Color.BLACK);

		this.setSize(new Dimension(400,400));
	}
}