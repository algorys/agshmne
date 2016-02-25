package io.github.algorys.agshmne.character.opponent.beast;

import java.util.ArrayList;
import java.util.List;

import io.github.algorys.agshmne.character.Attribute;
import io.github.algorys.agshmne.tools.Tools;

public class BeastFactory {
	private List<String> lowMonster = new ArrayList<>();
	private final BeastAttributeFactory beastAttributeFactory = new BeastAttributeFactory();
	private final OpponentVitalFactory beastVitalFact = new OpponentVitalFactory();

	public BeastFactory() {
		lowMonster.add("Loup:2");
		lowMonster.add("Araignée:2");
		lowMonster.add("Vermine:1");
		lowMonster.add("Rat Géant:1");
		lowMonster.add("Ours:3");
		lowMonster.add("Serpent:1");
		lowMonster.add("Ver Géant:2");
		lowMonster.add("Basilic:4");
	}

	public Beast createBeast() {
		String line = Tools.random(lowMonster);
		String[] parts = line.split(":");
		int level = Integer.parseInt(parts[1]);
		Attribute attributes = beastAttributeFactory.createAttributes(level);
		return new Beast(parts[0], level, attributes, beastVitalFact.createVital(attributes, level));
	}
}
