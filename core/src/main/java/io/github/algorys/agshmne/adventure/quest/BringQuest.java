package io.github.algorys.agshmne.adventure.quest;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.items.Inventory;
import io.github.algorys.agshmne.items.Item;
import io.github.algorys.agshmne.items.equipable.EquipableItem;
import io.github.algorys.agshmne.items.equipable.EquipableItemFactory;
import io.github.algorys.agshmne.map.Position;
import io.github.algorys.agshmne.map.tile.Tile;
import io.github.algorys.agshmne.message.IMessageReceiver;
import io.github.algorys.agshmne.message.Message;
import io.github.algorys.agshmne.message.MsgType;
import io.github.algorys.agshmne.tools.Tools;

public class BringQuest implements IQuest {
	private Tile destination;
	private Item item;
	private boolean finish = false;
	private String name;
	private IMessageReceiver messageReceiver;

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
		int gold = 5 + Tools.dice(pj.getLevel() * 5);
		this.sendMessage(new Message(MsgType.SUCCESS, "Vous gagnez " + gold + " pièces d'or."));
		inventory.setGold(inventory.getGold() + gold);
		EquipableItem equipItem = new EquipableItemFactory().createRandom();
		this.sendMessage(new Message(MsgType.SUCCESS, "Vous recevez " + equipItem.getName() + " en récompense."));
		inventory.addItem(equipItem);
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
		this.sendMessage(new Message(MsgType.INFO, "On vous a donné " + item.getName() + " pour votre quête."));
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
		this.messageReceiver = msgRcvr;
	}

	private void sendMessage(Message msg) {
		if (this.messageReceiver != null) {
			messageReceiver.sendMessage(msg);
		}
	}
}
