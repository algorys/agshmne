package io.github.algorys.agshmne.map.tile;

import io.github.algorys.agshmne.tools.Tools;

public class NamePlaceFactory {
	
	public String createRandomName() {
		String[] namePlace = {
			" des Nuits Noires",
			" de Sombre-Nuit",
			" des Ombres",
			" d'Agshmne",
			" de l'Ogre",
			" de Padhiver"
		};
	return Tools.random(namePlace);
	}
}
