package io.github.algorys.agshmne.map.city;

public class City {
	//private CityType cityType;
	private int level;

	public City(int level) {
		//this.cityType = type;
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public CityType getType() {
		if(level < 2) {
			return CityType.Hamlet;
		} else if (level < 4)  {
			return CityType.Town;
		} else if (level < 7)  {
			return CityType.City;
		} else {
			return CityType.Citadel;
		}
	}

}
