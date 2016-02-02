package io.github.algorys.agshmne.events.locality;

import java.util.ArrayList;
import java.util.List;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.events.IAdventureFactory;
import io.github.algorys.agshmne.tools.Tools;

public class LocalityFactory implements IAdventureFactory {
	List<String> locality;
	
	public LocalityFactory() {
		locality = new ArrayList<>();
		locality.add("Fontaine:PDV10:"+
				"Une fontaine représentant un ange déversant des flots sur un corps inanimé.");
		locality.add("Temple:MAN5:"
				+ "Vous apercevez un temple au loin. De grandes têtes de Tigres de Serleth surplombent l'entrée !");
		locality.add("Portes:PDV5:"
				+ "D'anciennes portes semblent garder un souvenir d'une ancienne bataille...");
		locality.add("Verger:PDV10:"
				+ "Un verger luxurieux qui semblent vous acceuillir à bras ouvert.");
		locality.add("Grand Arbre:MAN10:"
				+ "Cet arbre majestueux semble tellement ancien... et tellement grand !");
		locality.add("Stèle:COM1:"
				+ "Une imposante stèle contenant des gravures anciennes se dresse devant vous.");
	}

	
	@Override
	public Locality createAdventure(Player pj) {
		return new Locality(Tools.random(locality), pj);
	}
}
