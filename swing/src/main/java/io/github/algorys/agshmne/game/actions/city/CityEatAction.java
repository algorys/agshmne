package io.github.algorys.agshmne.game.actions.city;

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
		pj.getTile().getCity().eat(pj);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		this.update(pj.getInventory().getGold());
	}

	private void update(int gold) {
		if (pj.getTile().isCivilized()) {
			int price = pj.getTile().getCity().getPriceToEat();
			if (gold < price || pj.getVital().getHunger() == 0) {
				this.setEnabled(false);
			} else {
				this.setEnabled(true);
			}
		}
	}

}
