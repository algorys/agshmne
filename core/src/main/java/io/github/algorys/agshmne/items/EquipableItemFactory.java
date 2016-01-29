package io.github.algorys.agshmne.items;

import java.util.HashMap;
import java.util.Map;

public class EquipableItemFactory {
	private Map<BodyPart, String> factories = new HashMap<>();

	public EquipableItemFactory() {
		// TODO Générer une base d'objets en tableaux [[BodyPart, "Name:modifier]] et les passer ensuite en Factory
	}

	public EquipableItem createEquipableItem(BodyPart part, String nameModif) {
		String[] values = nameModif.split(":");
		String name = values[0];
		int modifier = Integer.parseInt(values[1]);
		return new EquipableItem(name, part, modifier);
	}
}
