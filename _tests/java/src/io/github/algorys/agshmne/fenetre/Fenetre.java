package io.github.algorys.agshmne.fenetre;

import javax.swing.JFrame;

import io.github.algorys.agshmne.world.World;

public class Fenetre extends JFrame {
	private World world;
	public Fenetre(World world){
		this.world = world;
		this.setTitle("Agshmne running...");
		this.setSize(800, 800);
		this.setLocationRelativeTo(null);		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(new JRegion(world.getDefaultRegion()));
	}
	
}
