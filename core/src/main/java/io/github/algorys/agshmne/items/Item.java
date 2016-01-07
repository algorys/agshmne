package io.github.algorys.agshmne.objets;

public class Item {
	private String name;
	private int nb;
	
	public Item(String name, int nb) {
		this.name = name;
		this.nb = nb;
	}

	public String getName() {
		return name;
	}

	public int getNb() {
		return nb;
	}

	public void setNb(int nb) {
		this.nb = nb;
	}
}
