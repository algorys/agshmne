package io.github.algorys.agshmne.items;

public class ItemDirectFactory {
	// Armes
	public final static String AXE = "Axe";
	public final static String SWORD = "Sword";
	public final static String WAND = "Wand";
	public final static String BOW = "Bow";
	// Armures
	public final static String CLOAK = "Cloak";
	public final static String DRESS = "Dress";
	// Quest
	public final static String LETTERS = "Letters";
	
	public Item createAxe() {
		return new GeneralItem(AXE);
	}
	
	public Item createSword() {
		return new GeneralItem(SWORD);
	}
	
	public Item createWand() {
		return new GeneralItem(WAND);
	}
	
	public Item createBow() {
		return new GeneralItem(BOW);
	}
	
	public Item createCloak() {
		return new GeneralItem(CLOAK);
	}
	
	public Item createDress() {
		return new GeneralItem(DRESS);
	}
	
	public Item createLetters() {
		return new GeneralItem(LETTERS);
	}
	
}
