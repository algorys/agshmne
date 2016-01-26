package io.github.algorys.agshmne.action;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractAction;

import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.items.StackableItemDirectFactory;

final class SkillCutAction extends AbstractAction implements Observer {
	private final Character pj;

	public SkillCutAction(Character pj) {
		super("Couper du bois");
		this.pj = pj;
		pj.addObserver(this);
		this.update(pj, null);
	}

	@Override
	public void actionPerformed(ActionEvent wood) {
		System.out.println("Bois coupé !");
		pj.getInventory().addItem(new StackableItemDirectFactory().createPine());
	}

	@Override
	public void update(Observable o, Object arg) {
		switch (pj.getTile().getType()) {
		case Wood:
		case Forest:
			this.setEnabled(true);
			break;
		default:
			this.setEnabled(false);
		}
	}
}