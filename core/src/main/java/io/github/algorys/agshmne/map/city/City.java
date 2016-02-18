package io.github.algorys.agshmne.map.city;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.map.city.shop.Shop;
import io.github.algorys.agshmne.tools.Tools;

public class City {
	public static City NONE = new City("Pas de ville", 0);

	static {
		NONE.shop = Shop.NONE;
	}

	private String name;
	private int level;
	private Shop shop;
	private int priceToEat;
	private int priceToSleep;

	public City(String name, int level) {
		this.level = level;
		this.shop = new Shop(level);
		this.priceToEat = generatePriceToEat();
		this.priceToSleep = generatePriceToSleep();
		this.name = name;
	}

	private int generatePriceToEat() {
		int price = Tools.dice(2) + this.level;
		return price;
	}

	private int generatePriceToSleep() {
		int price = 5 + this.level;
		return price;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public CityType getType() {
		return City.getTypeFromLevel(this.level);
	}

	public static CityType getTypeFromLevel(int level) {
		if (level < 2) {
			return CityType.Hamlet;
		} else if (level < 4) {
			return CityType.Town;
		} else if (level < 7) {
			return CityType.City;
		} else {
			return CityType.Citadel;
		}
	}

	public String getName() {
		return name;
	}

	public Shop getShop() {
		return shop;
	}

	public int getPriceToEat() {
		return priceToEat;
	}

	public int getPriceToSleep() {
		return priceToSleep;
	}

	public void eat(Player pj) {
		int newHunger = pj.getVital().getHunger() - this.level;
		pj.getVital().setHunger(newHunger);
		int newGold = pj.getInventory().getGold() - this.priceToEat;
		pj.getInventory().setGold(newGold);
	}

	public void sleep(Player pj) {
		int newFatigue = pj.getVital().getFatigue() - (this.level * 4);
		pj.getVital().setFatigue(newFatigue);
		int newGold = pj.getInventory().getGold() - this.priceToSleep;
		pj.getInventory().setGold(newGold);
	}

}
