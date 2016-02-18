package io.github.algorys.agshmne.game.actions.city;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.items.Inventory;

@SuppressWarnings("serial")
public class CitySleepAction extends AbstractAction implements PropertyChangeListener {
	private Player pj;

	public CitySleepAction(Player pj) {
		super("Se reposer");
		this.pj = pj;
		pj.addPropertyChangeListener(this);
		pj.getInventory().addPropertyChangeListener(Inventory.PROPERTY_GOLD, this);
		this.update(pj.getInventory().getGold());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		pj.getTile().getCity().sleep(pj);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		this.update(pj.getInventory().getGold());
	}

	private void update(int gold) {
		if (pj.getTile().isCivilized()) {
			int price = pj.getTile().getCity().getPriceToSleep();
			if (gold < price) {
				this.setEnabled(false);
			} else {
				this.setEnabled(true);
			}
		}
	}

}
