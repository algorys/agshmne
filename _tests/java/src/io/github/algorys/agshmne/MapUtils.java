package io.github.algorys.agshmne;

import io.github.algorys.agshmne.region.Region;

public class MapUtils {
	private Region region;

	public MapUtils(Region region) {
		super();
		this.region = region;
	}

	public Tile tileFromPersonnage(Personnage p) {
		return region.getTileFromPosition(p.getPosition());
	}
	
	public void showStatus(Personnage p) {
		System.out.println("Le personnage se trouve en position : (" + p.getPosition().getX() + " , "
				+ p.getPosition().getY() + ")");
		System.out.println("Vous etes sur une case : " + this.tileFromPersonnage(p));
	}
}