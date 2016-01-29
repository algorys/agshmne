package io.github.algorys.agshmne.items;

public interface IEquipableItem extends Item {
	public boolean isEquipped();
	
	public BodyPart getPart();
	
	public void equip();

	public void unequip();
	
}
