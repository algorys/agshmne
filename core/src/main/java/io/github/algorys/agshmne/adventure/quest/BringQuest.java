package io.github.algorys.agshmne.adventure.quest;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.items.Inventory;
import io.github.algorys.agshmne.items.Item;
import io.github.algorys.agshmne.items.equipable.EquipableItemFactory;
import io.github.algorys.agshmne.map.Position;
import io.github.algorys.agshmne.map.tile.Tile;
import io.github.algorys.agshmne.message.IMessageReceiver;
import io.github.algorys.agshmne.tools.Tools;

public class BringQuest implements IQuest {
	private Tile destination;
	private Item item;
	private boolean finish = false;
	private String name;

	public BringQuest(Item item, Tile destination) {
		this.destination = destination;
		this.item = item;
		this.name = "Apporter des " + item.getName();
	}

	@Override
	public boolean isWin(Player pj) {
		return pj.getTile().equals(destination) && pj.getInventory().contains(item);
	}

	@Override
	public void reward(Player pj) {
		Inventory inventory = pj.getInventory();
		inventory.removeItem(item);
		finish = true;
		inventory.setGold(inventory.getGold() + Tools.dice(pj.getLevel() * 5));
		inventory.addItem(new EquipableItemFactory().createRandom());
		// TODO prévoir une récompense.
	}

	@Override
	public boolean isFinish() {
		return finish;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getGoal() {
		return getName();
	}

	@Override
	public void accept(Player pj) {
		pj.addQuest(this);
		// TODO gérer les objets de quêtes différement des objets normaux.
		pj.getInventory().addItem(item);

	}

	public Position getQuestDestination() {
		return this.destination.getPosition();
	}

	@Override
	public Tile getDestination() {
		return this.destination;
	}

	@Override
	public void setMessageReceiver(IMessageReceiver msgRcvr) {
		// TODO Auto-generated method stub
	}
}
