package io.github.algorys.agshmne.character;

public interface Character {
	public static final String PROPERTY_NAME = "name";
	public static final String PROPERTY_LEVEL = "level";
	public static final String PROPERTY_CURRENT_ATTRIBUTES = "currentAttributes";
	public static final String PROPERTY_VITAL = "vital";

	public String getName();

	public int getLevel();

	public Attribute getCurrentAttributes();

	public Vital getVital();

}
