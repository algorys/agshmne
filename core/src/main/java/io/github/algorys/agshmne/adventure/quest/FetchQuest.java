package io.github.algorys.agshmne.adventure.quest;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.items.Inventory;
import io.github.algorys.agshmne.items.Item;
import io.github.algorys.agshmne.map.Position;
import io.github.algorys.agshmne.map.tile.Tile;
import io.github.algorys.agshmne.message.IMessageReceiver;
import io.github.algorys.agshmne.message.Message;
import io.github.algorys.agshmne.message.MsgType;
import io.github.algorys.agshmne.tools.Tools;

public class FetchQuest implements IQuest {
	private Tile tile;
	private Item item;
	private int count;
	private boolean finish = false;
	private IMessageReceiver messageReceiver;

	public FetchQuest(Item item, int count, Tile tile) {
		this.count = count;
		this.item = item;
		this.tile = tile;
	}

	@Override
	public boolean isWin(Player pj) {
		return (pj.getInventory().count(item) >= count && pj.getTile().equals(tile));
	}

	@Override
	public void reward(Player pj) {
		Inventory inventory = pj.getInventory();
		for (int i = 0; i < count; i++) {
			inventory.removeItem(item);
		}
		finish = true;
		int gold = 10 + Tools.dice(pj.getLevel() * 5);
		inventory.setGold(inventory.getGold() + gold);
		this.sendMessage(new Message(MsgType.SUCCESS, "Vous gagnez " + gold + " pièces d'or."));
		// TODO Améliorer le système de récompense.
	}

	@Override
	public String getName() {
		return "Trouver des " + item.getName();
	}

	@Override
	public String getGoal() {
		StringBuffer sb = new StringBuffer();
		sb.append("Une personne a besoin qu'on lui livre au moins ");
		sb.append(count + " ");
		sb.append(item.getName());
		return sb.toString();
	}

	public Position getQuestPosition() {
		return tile.getPosition();
	}

	@Override
	public boolean isFinish() {
		return finish;
	}

	@Override
	public void accept(Player pj) {
		pj.addQuest(this);
	}
	
	@Override
	public Tile getDestination() {
		return this.tile;
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
