package io.github.algorys.agshmne.personnage;

import io.github.algorys.agshmne.deplacement.Position;
import io.github.algorys.agshmne.region.Region;

/*
 * Définit le Personnage
 */
public class Personnage {
	private Position position = new Position(0, 0);
	private Region region;
	

	public Personnage(Region region) {
		this.region = region;
	}

	public Position getPosition() {
		return position;
	}

	public Region getRegion() {
		return this.region;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
}

