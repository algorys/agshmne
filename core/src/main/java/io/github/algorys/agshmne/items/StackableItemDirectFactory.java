package io.github.algorys.agshmne.items;

public class StackableItemDirectFactory {
	// Fruits
	public final static String APPLE = "Apple";
	public final static String ORANGE = "Orange";	
	// Ore
	public final static String COPPER = "Copper";
	public final static String IRON = "Iron";
	public final static String SILVER = "Silver";
	public final static String GOLD = "Gold";
	public final static String MYTHRIL = "Mythril";
	// Wood
	public final static String PINE = "Pine";
	// Misc
	public final static String NAIL = "Nail";
	// Potions
	public final static String MANAPOTION = "Mana Potion";
	
	public Item createApple() {
		return createApple(1);
	}
	public Item createApple(int count) {
		return new GeneralStackableItem(APPLE, count);
	}
	
	public Item createOrange() {
		return createOrange(1);
	}
	public Item createOrange(int count) {
		return new GeneralStackableItem(ORANGE, count);
	}
	
	public Item createCopper() {
		return createCopper(1);
	}
	public Item createCopper(int count) {
		return new GeneralStackableItem(COPPER, count);
	}
	
	public Item createIron() {
		return createIron(1);
	}
	public Item createIron(int count) {
		return new GeneralStackableItem(IRON, count);
	}
	
	public Item createSilver() {
		return createSilver(1);
	}
	public Item createSilver(int count) {
		return new GeneralStackableItem(SILVER, count);
	}
	
	public Item createGold() {
		return createGold(1);
	}
	public Item createGold(int count) {
		return new GeneralStackableItem(GOLD, count);
	}
	
	
	public Item createMythril() {
		return createMytril(1);
	}
	public Item createMytril(int count) {
		return new GeneralStackableItem(MYTHRIL, count);
	}
	
	public Item createPine() {
		return createPine(1);
	}
	public Item createPine(int count) {
		return new GeneralStackableItem(PINE, count);
	}
	
	public Item createNail() {
		return createNail(1);
	}
	public Item createNail(int count) {
		return new GeneralStackableItem(NAIL, count);
	}
	
	public Item createManaPotion() {
		return createManaPotion(1);
	}
	public Item createManaPotion(int count) {
		return new GeneralStackableItem(MANAPOTION, count);
	}
}	
