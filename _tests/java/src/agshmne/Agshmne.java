package agshmne;

public class Agshmne {

	public static void main(String[] args) {
		/*
		 * TEST PERSO
		 */
		//Personnage pj = new Personnage();
		//System.out.println("Le personnage a : " + pj.getVie()+ "PdVs et " + pj.getMana() + " en mana !");
		/*
		 * TEST OUTILS
		 */
		int d = Outils.dice(6);
		System.out.println("Vous lancéz un dé : " + d);
		/*
		 * TEST MAP
		 */
		Tile tile = new Tile();
		
		System.out.println("Vous etes sur une case : " + tile.getType());
	}

}
