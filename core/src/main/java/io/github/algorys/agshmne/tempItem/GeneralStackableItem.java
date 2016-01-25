package io.github.algorys.agshmne.tempItem;

public class GeneralStackableItem implements StackableItem {
	private int count;
	private String name;
	
	public GeneralStackableItem(String name, int count) {
		this.name = name;
		this.count = count;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getCount() {
		return count;
	}

	@Override
	public boolean isSameType(StackableItem item) {
		return this.name == item.getName();
	}
}
