package io.github.algorys.agshmne.opponent.beast;

import io.github.algorys.agshmne.caracteristic.CharacterAttribute;
import io.github.algorys.agshmne.opponent.Opponent;

public class Beast implements Opponent {
	private String name;
	private int level;
	private CharacterAttribute carac;
	
	public Beast(String name, int level) {
		this.name = name;
		this.level = level;
		this.carac = new BeastAttributeFactory().createAttributes(level);
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
	public CharacterAttribute getAttributes() {
		return carac;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nom : " + this.getName());
		sb.append("\n");
		sb.append("Level : " + this.getLevel());
		sb.append("\n");
		sb.append("For = " + this.getAttributes().getFOR());
		sb.append("\n");
		sb.append("Dex = " + this.getAttributes().getDEX());
		sb.append("\n");
		sb.append("Con = " + this.getAttributes().getCON());
		sb.append("\n");
		sb.append("Int = " + this.getAttributes().getINT());
		sb.append("\n");
		sb.append("Cha = " + this.getAttributes().getCHA());

		return sb.toString();
	}

}
