package io.github.algorys.agshmne.adventure.locality;

import java.util.ArrayList;
import java.util.List;

import io.github.algorys.agshmne.Game;
import io.github.algorys.agshmne.adventure.IAdventureFactory;
import io.github.algorys.agshmne.effect.EffectFactory;
import io.github.algorys.agshmne.tools.Tools;

public class LocalityFactory implements IAdventureFactory {
	private List<String> locality;
	private EffectFactory effectFactory = new EffectFactory();
	
	public LocalityFactory() {
		locality = new ArrayList<>();
		locality.add("Fontaine:LIFE10:"+
				"Une fontaine représentant un ange déversant des flots sur un corps inanimé. Boire l'eau ?:Affecte votre vie !");
		locality.add("Temple:MANA5:"
				+ "Vous apercevez un temple au loin. De grandes têtes de Tigres de Serleth surplombent l'entrée ! S'y reposer ?:Affecte votre Mana.");
		locality.add("Portes:LIFE5:"
				+ "D'anciennes portes semblent garder un souvenir d'une ancienne bataille... Passer les portes ?:Affecte votre vie !");
		locality.add("Verger:LIFE10:"
				+ "Un verger luxurieux qui semblent vous acceuillir à bras ouvert. Manger les fruits du verger ?:Affecte votre vie !");
		locality.add("Grand Arbre:MANA10:"
				+ "Cet arbre majestueux semble tellement ancien... et tellement grand ! Toucher l'arbre ?:Affecte votre Mana !");
		locality.add("Stèle:CFOU1:"
				+ "Une imposante stèle contenant des gravures anciennes se dresse devant vous. Pousser la stèle ?:Affecte votre compétence \"Fouiller\"");
	}

	
	@Override
	public Locality createAdventure(Game game) {
		String[] strToParse = Tools.random(locality).split(":");
		return new Locality(strToParse[0], effectFactory.fromString(strToParse[1]), strToParse[2], strToParse[3]);
	}
}
