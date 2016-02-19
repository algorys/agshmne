package io.github.algorys.agshmne.sample.adventure;

import io.github.algorys.agshmne.adventure.locality.Locality;
import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.effect.LifeEffect;

public class LocalitySample {

	public static void main(String[] args) {
		String locality = "Une fontaine représentant un ange déversant des flots sur un corps inanimé.";
		Player pj = new Player(null, null);
		Locality underTest = new Locality("Fontaine", new LifeEffect(10), locality, "Affecte votre vie !");
		pj.initVital();
		pj.getVital().setLife(10);
		System.out.println("Nom : " + underTest.getName());
		System.out.println("Desc : " + underTest.getDesc());
		System.out.println("Vie PJ : " + pj.getVital().getLife());
		underTest.interact(pj);
		System.out.println("Vie PJ : " + pj.getVital().getLife());
	}

}
