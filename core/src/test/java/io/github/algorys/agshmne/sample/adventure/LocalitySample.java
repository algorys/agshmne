package io.github.algorys.agshmne.sample.adventure;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.events.locality.Locality;
import io.github.algorys.agshmne.map.region.RandomRegionFactory;
import io.github.algorys.agshmne.map.region.Region;

public class LocalitySample {

	public static void main(String[] args) {
		String locality = "Fontaine:PDV10:"+
				"Une fontaine représentant un ange déversant des flots sur un corps inanimé.";
		Region region = new RandomRegionFactory().create();
		Locality underTest = new Locality(locality, new Player(region));
		
		System.out.println("Nom : " + underTest.getName());
		System.out.println("Desc : " + underTest.getDesc());
	}

}
