package io.github.algorys.agshmne.map;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.map.region.Region;

@SuppressWarnings("serial")
public class JPanMap extends JPanel{
	public JPanMap(Region region, final Player pj){		
		this.add(new JMapRegion(pj));
		
		this.setBackground(Color.BLACK);

		this.setSize(new Dimension(400,400));
	}
}