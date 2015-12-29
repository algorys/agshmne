package io.github.algorys.agshmne.window;

import javax.swing.JFrame;

import io.github.algorys.agshmne.world.World;

public class JMap extends JFrame {
	
	private World world;

	public JMap(World world){
		this.world = world;
		this.setTitle("Agshmne running...");
		this.setSize(800, 800);
		this.setLocationRelativeTo(null);		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(new JRegion(world.getDefaultRegion()));
	}
	
}
