package io.github.algorys.agshmne.action;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractAction;

import io.github.algorys.agshmne.character.Character;

public class SkillSearchCityAction extends AbstractAction implements Observer {
	private final Character pj;
	
	public SkillSearchCityAction(Character pj) {
		super("Fouiller la Ville");
		this.pj = pj;
		pj.addObserver(this);
		this.update(pj, null);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Vous fouillez la Ville !");
		// TODO Faire en sorte qu'on puisse trouver des choses dans une ville
	}

	@Override
	public void update(Observable o, Object arg) {	
		if(pj.getTile().isCivilized()){
			this.setEnabled(true);
		} else {
			this.setEnabled(false);
		}
	}

}
