package agshmne;

public class Apple implements InventoryItem {

	@Override
	public String getName() {
		return "Pomme";
	}

	@Override
	public int getWeight() {
		return 1;
	}

}
