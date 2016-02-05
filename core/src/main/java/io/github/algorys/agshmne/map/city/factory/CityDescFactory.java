package io.github.algorys.agshmne.map.city.factory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.algorys.agshmne.map.city.CityType;
import io.github.algorys.agshmne.tools.Tools;

public class CityDescFactory {
	private Map<CityType, List<String>> names = new HashMap<>();

	public CityDescFactory() {
		List<String> hamlet = Arrays.asList("Hameau", "Bourg", "Lieu-dit");
		List<String> town = Arrays.asList("Village", "Bourg", "Bourgade");
		List<String> city = Arrays.asList("Ville", "Cité", "Bastide", "Fort");
		List<String> citadel = Arrays.asList("Citadelle", "Forteresse", "Acropole", "Château");
		
		names.put(CityType.Hamlet, hamlet);
		names.put(CityType.Town, town);
		names.put(CityType.City, city);
		names.put(CityType.Citadel, citadel);
	}
	
	public String randomDesc(CityType type) {

		List<String> possibleName = names.get(type);
		final String title;
		if (possibleName == null) {
			title = "No CityType found";
		} else {
			title = Tools.random(possibleName);
		}
		String name = namePlace();
		return title + name;
	}
	
	private String namePlace() {
		String[] namePlace = {
				" des Nuits Noires",
				" de Sombre-Nuit",
				" des Ombres",
				" d'Agshmne",
				" de l'Ogre"
		};
		return Tools.random(namePlace);
	}
}
