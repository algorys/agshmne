package io.github.algorys.agshmne.tools;

import io.github.algorys.agshmne.character.Player;
import io.github.algorys.agshmne.map.region.Region;
import io.github.algorys.agshmne.map.tile.Tile;

public class MapUtils {
	private Region region;

	public MapUtils(Region region) {
		super();
		this.region = region;
	}

	public Tile tileFromPersonnage(Player p) {
		return region.getTileFromPosition(p.getPosition());
	}
	
	public void showStatus(Player p) {
		System.out.println("Le personnage se trouve en position : (" + p.getPosition().getX() + " , "
				+ p.getPosition().getY() + ")");
		System.out.println("Vous etes sur une case : " + this.tileFromPersonnage(p));
	}
}