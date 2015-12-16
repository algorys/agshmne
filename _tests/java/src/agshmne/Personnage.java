package agshmne;

import java.util.HashMap;
import java.util.Map;

/*
 * Définit le Personnage
 */
public class Personnage {
	private Map<String, Integer> vital = new HashMap<>();
	private int position;

	public Personnage(){	
		vital.put("vie", 0);
		vital.put("mana", 0);
		position = 0;
		
	}
	
	public Integer getVie(){	
		return vital.get("vie");
	}
	
	
}
