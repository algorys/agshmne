package io.github.algorys.agshmne.tempItem;

public class GeneralItem implements Item {
	private String name;
	
	public GeneralItem(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

}