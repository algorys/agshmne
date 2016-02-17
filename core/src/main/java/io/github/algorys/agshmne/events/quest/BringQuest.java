package io.github.algorys.agshmne.events.quest;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.items.Item;
import io.github.algorys.agshmne.items.equipable.EquipableItemFactory;
import io.github.algorys.agshmne.map.Position;
import io.github.algorys.agshmne.tools.RandomCoordinated;
import io.github.algorys.agshmne.tools.Tools;

public class BringQuest implements IQuest {
	private Position questDestination;
	private Item item;
	private boolean finish = false;
	private String name;

	public BringQuest(Player pj, Item item) {
		this.questDestination = this.defineDestination(pj.getGame().getPosition());
		this.item = item;
		this.name = "Apporter des " + item.getName() + " dans la Région : "
				+ pj.getGame().getRegion().getTileFromPosition(questDestination).getDesc();
	}

	private Position defineDestination(Position position) {
		int maxX = position.getX() + 10;
		int minX = position.getX() - 10;
		int maxY = position.getY() + 10;
		int minY = position.getY() - 10;
		RandomCoordinated newY = new RandomCoordinated(maxY, minY);
		RandomCoordinated newX = new RandomCoordinated(maxX, minX);
		Position questDestination = new Position(newX.getCoordinated(), newY.getCoordinated());
		return questDestination;
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
