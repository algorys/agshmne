package io.github.algorys.agshmne.events.quest;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.items.Item;
import io.github.algorys.agshmne.items.equipable.EquipableItemFactory;
import io.github.algorys.agshmne.map.Position;
import io.github.algorys.agshmne.map.tile.Tile;
import io.github.algorys.agshmne.tools.Tools;

public class BringQuest implements IQuest {
	private Position questDestination;
	private Item item;
	private boolean finish = false;
	private String name;

	public BringQuest(Item item, Position destination, Tile tileDestination) {
		this.questDestination = destination;
		this.item = item;
		this.name = "Apporter des " + item.getName() + " dans la Région : " + tileDestination.getDesc();
	}

	public Position getQuestDestination() {
		return questDestination;
	}

	@Override
	public boolean isWin(Player pj) {
		return pj.getGame().getPosition().equals(questDestination) && pj.getInventory().contains(item);
	}

	@Override
	public void reward(Player pj) {
		pj.getInventory().removeItem(item);
		finish = true;
		pj.getInventory().setGold(pj.getInventory().getGold() + Tools.dice(pj.getLevel() * 5));
		pj.getInventory().addItem(new EquipableItemFactory().createRandom());
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
		StringBuffer sb = new StringBuffer();
		sb.append(name);
		sb.append("(");
		sb.append(questDestination.getX() + ",");
		sb.append(questDestination.getY());
		sb.append(")");
		return sb.toString();
	}

	@Override
	public void accept(Player pj) {
		pj.addQuest(this);
		// TODO gérer les objets de quêtes différement des objets normaux.
		pj.getInventory().addItem(item);

	}

}
