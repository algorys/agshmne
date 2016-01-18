package io.github.algorys.agshmne.city;

public class City {
	private CityType cityType;
	private int level;

	public City(CityType type, int level) {
		this.cityType = type;
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public CityType getType() {
		return cityType;
	}

}
