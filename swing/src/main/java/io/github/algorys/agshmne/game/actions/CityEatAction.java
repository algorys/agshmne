package io.github.algorys.agshmne.game.actions;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.items.Inventory;

@SuppressWarnings("serial")
public class CityEatAction extends AbstractAction implements PropertyChangeListener {
	private Player pj;

	public CityEatAction(Player pj) {
		super("Manger un repas");
		this.pj = pj;
		pj.addPropertyChangeListener(this);
		pj.getInventory().addPropertyChangeListener(Inventory.PROPERTY_GOLD, this);
		this.update(pj.getInventory().getGold());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int newHunger = pj.getVital().getHunger() - pj.getTile().getCity().getLevel();
		pj.getVital().setHunger(newHunger);
		int newGold = pj.getInventory().getGold() - (pj.getTile().getCity().getLevel() * 2);
		pj.getInventory().setGold(newGold);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		this.update(pj.getInventory().getGold());
	}

	private void update(int gold) {
		if (pj.getTile().isCivilized()) {
			int price = pj.getTile().getCity().getLevel() * 2;
			if (gold < price) {
				this.setEnabled(false);
			} else {
				this.setEnabled(true);
			}
		}
	}

}
