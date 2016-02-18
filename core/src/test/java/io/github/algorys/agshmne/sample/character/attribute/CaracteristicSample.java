package io.github.algorys.agshmne.sample.character.attribute;

import io.github.algorys.agshmne.character.player.Player;;

public class CaracteristicSample {

	public static void main(String[] args) {
		Player pj = new Player(null, null);

		pj.getAttributes().setFOR(10);

		System.out.println("Personnage a FOR : " + pj.getAttributes().getFOR());
		System.out.println("Personnage a CON : " + pj.getAttributes().getCON());

	}

}
