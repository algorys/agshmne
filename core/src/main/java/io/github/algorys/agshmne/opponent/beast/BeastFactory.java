package io.github.algorys.agshmne.opponent.beast;

import java.util.ArrayList;
import java.util.List;

import io.github.algorys.agshmne.tools.Tools;

public class BeastFactory {
	private List<String> lowMonster = new ArrayList<>();
	
	public BeastFactory() {
		lowMonster.add("Wolf:3");
		lowMonster.add("Spider:2");
		lowMonster.add("Vermin:1");
		lowMonster.add("Jelly:1");
		lowMonster.add("Goblins:3");		
	}
	
	public Beast createBeast() {
		String line = lowMonster.get(Tools.dice(lowMonster.size()));
		String[] parts = line.split(":");
		return new Beast(parts[0], Integer.parseInt(parts[1]));
	}
}
