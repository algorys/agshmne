package io.github.algorys.agshmne;

public class Agshmne {
	public static void main(String[] args) {
		/*
		 * TEST PERSO
		 */
		Personnage pj = new Personnage();
		// System.out.println("Le personnage a : " + pj.getVie()+ "PdVs et " +
		// pj.getMana() + " en mana !");

		/*
		 * TEST OUTILS
		 */
		int d = Outils.dice(6);
		System.out.println("Vous lancez un dé : " + d);

		Region map = new Region();
		MapUtils mapUtils = new MapUtils(map);

		System.out.println("Votre carte : " + map);
		System.out.println("Vous etes sur une case : " + TileType.Ville);

		mapUtils.showStatus(pj);
		pj.setPosition(new Position(1, 2));
		mapUtils.showStatus(pj);
	}
}
