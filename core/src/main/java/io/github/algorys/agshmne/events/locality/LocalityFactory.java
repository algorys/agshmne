package io.github.algorys.agshmne.events.locality;

import java.util.ArrayList;
import java.util.List;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.effect.EffectFactory;
import io.github.algorys.agshmne.events.IAdventureFactory;
import io.github.algorys.agshmne.tools.Tools;

public class LocalityFactory implements IAdventureFactory {
	private List<String> locality;
	private EffectFactory effectFactory = new EffectFactory();
	
	public LocalityFactory() {
		locality = new ArrayList<>();
		locality.add("Fontaine:LIFE10:"+
				"Une fontaine représentant un ange déversant des flots sur un corps inanimé.");
		locality.add("Temple:MANA5:"
				+ "Vous apercevez un temple au loin. De grandes têtes de Tigres de Serleth surplombent l'entrée !");
		locality.add("Portes:LIFE5:"
				+ "D'anciennes portes semblent garder un souvenir d'une ancienne bataille...");
		locality.add("Verger:LIFE10:"
				+ "Un verger luxurieux qui semblent vous acceuillir à bras ouvert.");
		locality.add("Grand Arbre:MANA10:"
				+ "Cet arbre majestueux semble tellement ancien... et tellement grand !");
		locality.add("Stèle:CFOU1:"
				+ "Une imposante stèle contenant des gravures anciennes se dresse devant vous.");
	}

	
	@Override
	public Locality createAdventure(Player pj) {
		String[] strToParse = Tools.random(locality).split(":");
		return new Locality(strToParse[0], effectFactory.fromString(strToParse[1]), strToParse[2]);
	}
}
