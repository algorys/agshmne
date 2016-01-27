package io.github.algorys.agshmne.caracteristic;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.map.region.Region;;

public class CaracteristicSample {

	public static void main(String[] args) {
		Region region = new Region();
		Player pj = new Player(region);
		
		pj.getAttributes().setFOR(10);
		
		System.out.println("Personnage a FOR : " + pj.getAttributes().getFOR());
		System.out.println("Personnage a CON : " + pj.getAttributes().getCON());

	}

}
