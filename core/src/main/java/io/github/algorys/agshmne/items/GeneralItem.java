package io.github.algorys.agshmne.items;

public class GeneralItem implements Item {
	private String name;
	private int price;

	public GeneralItem(String name, int price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return (String) this.name;
	}
	
	@Override
	public boolean isSameType(Item other) {
		return other != null && other.getName().equals(this.name);
	}
	@Override
	public int getPrice() {
		return price;
	}
}
