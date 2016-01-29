package io.github.algorys.agshmne.items;

public class EquipableItem extends GeneralItem implements IEquipableItem {
	private BodyPart part;
	private boolean equipped;
	
	public EquipableItem(String name, BodyPart part) {
		super(name);
		this.part = part;
	}
	
	public void equip(){
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

}
