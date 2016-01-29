package io.github.algorys.agshmne.items;

public class EquipableItem extends GeneralItem implements IEquipableItem {
	private BodyPart part;
	private boolean equipped;
	private int modifier;

	public EquipableItem(String name, BodyPart part, int modifier) {
		super(name);
		this.part = part;
		this.modifier = modifier;
	}

	public void equip() {
		this.equipped = true;
	}

	@Override
	public void unequip() {
		this.equipped = false;
	}

	@Override
	public boolean isEquipped() {
		return equipped;
	}

	@Override
	public BodyPart getPart() {
		return part;
	}

	@Override
	public int getModifier() {
		return this.modifier;
	}

}
