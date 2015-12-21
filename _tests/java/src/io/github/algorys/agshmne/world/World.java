package io.github.algorys.agshmne.world;

import io.github.algorys.agshmne.Personnage;
import io.github.algorys.agshmne.region.Region;

public class World {
	private Region[][] regions;
	
	World(Region[][] regions) {
		this.regions = regions;
	}
	
	public Region getRegion(Region origin, Personnage direction) {
		// TODO retrouver les coordonnées de la région <code>origin</origin> pour donner la bonne région de retour, ou envoyer une erreur pour mauvaises entrées
		return null;
	}
	
	public Region getDefaultRegion() {
		return regions[1][1];
	}
}
