package agshmne;

public class Agshmne {

	public static void main(String[] args) {
		//Personnage pj = new Personnage();
		
		//System.out.println("Le personnage a : " + pj.getVie()+ "PdVs et " + pj.getMana() + " en mana !");
		//Outils d = new Outils();
		//d.Dice(6);
		int d = Outils.dice(6);
		System.out.println("Vous lancéz un dé : " + d);

	}

}
