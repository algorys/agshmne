package agshmne;

public class Tile {
	public enum Tiles {
		Ville,
		Roche,
		Terre,
		Bois,
		Eau,
		Desert
	}
	
	private Tiles typeCase = Tiles.values()[1];
	
	
	public Tiles getType(){
		return typeCase;
	}
	
	
}
