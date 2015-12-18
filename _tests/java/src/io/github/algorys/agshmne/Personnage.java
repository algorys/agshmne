package io.github.algorys.agshmne;

import java.util.HashMap;
import java.util.Map;

/*
 * Définit le Personnage
 */
public class Personnage {
	private Map<String, Integer> vital = new HashMap<>();
	private int x = 0;
	private int y = 0; 
	private Position position = new Position(x,y);

	public Personnage(){	
		vital.put("vie", 0);
		vital.put("mana", 0);
	}
	
	public Integer getVie(){	
		return vital.get("vie");
	}
	
	public Integer getMana(){	
		return vital.get("vie");
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
}
