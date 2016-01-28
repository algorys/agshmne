package io.github.algorys.agshmne.game.actions;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;

import io.github.algorys.agshmne.character.player.Player;

@SuppressWarnings("serial")
public class SkillSearchCityAction extends AbstractAction implements PropertyChangeListener {
	private final Player pj;

	public SkillSearchCityAction(Player pj) {
		super("Fouiller la Ville");
		this.pj = pj;
		pj.addPropertyChangeListener(this);
		this.setEnabled(pj.getTile().isCivilized());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Vous fouillez la Ville !");
		// TODO Faire en sorte qu'on puisse trouver des choses dans une ville
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		this.setEnabled(pj.getTile().isCivilized());
	}

}
