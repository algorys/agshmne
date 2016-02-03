package io.github.algorys.agshmne.sample.adventure;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.events.locality.Locality;

public class LocalitySample {

	public static void main(String[] args) {
		String locality = "Une fontaine représentant un ange déversant des flots sur un corps inanimé.";
		Player pj = new Player(null);
		Locality underTest = new Locality("Fontaine", "PDV10", locality);
		pj.initVital();
		pj.getVital().setVie(10);
		System.out.println("Nom : " + underTest.getName());
		System.out.println("Desc : " + underTest.getDesc());
		System.out.println("Vie PJ : " + pj.getVital().getVie());
		underTest.interact(pj);
		System.out.println("Vie PJ : " + pj.getVital().getVie());
	}

}
