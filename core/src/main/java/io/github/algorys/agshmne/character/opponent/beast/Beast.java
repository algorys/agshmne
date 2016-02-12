package io.github.algorys.agshmne.character.opponent.beast;

import io.github.algorys.agshmne.character.Attribute;
import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.character.Vital;

public class Beast implements Character {
	private String name;
	private int level;
	private Attribute carac;
	private Vital vital;
	
	public Beast(String name, int level, Attribute carac, Vital vital) {
		this.name = name;
		this.level = level;
		this.carac = carac;
		this.vital = vital;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getLevel() {
		return level;
	}

	@Override
	public Attribute getCurrentAttributes() {
		return carac;
	}
	
	@Override
	public Vital getVital() {
		return vital;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nom : " + this.getName());
		sb.append("\n");
		sb.append("Level : " + this.getLevel());
		sb.append("\n");
		sb.append("Vie = " + this.getVital().getLife());
		sb.append("\n");
		sb.append("Mana = " + this.getVital().getMana());
		sb.append("\n");
		sb.append("For = " + this.getCurrentAttributes().getFOR());
		sb.append("\n");
		sb.append("Dex = " + this.getCurrentAttributes().getDEX());
		sb.append("\n");
		sb.append("Con = " + this.getCurrentAttributes().getCON());
		return sb.toString();
	}
}
