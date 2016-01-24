package io.github.algorys.agshmne.action;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractAction;

import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.skills.SkillTool;
import io.github.algorys.agshmne.skills.SkillType;

public class SkillFishAction extends AbstractAction implements Observer {
	private final Character pj;
	
	public SkillFishAction(Character pj) {
		super("Pêcher");
		this.pj = pj;
		pj.addObserver(this);
		this.update(pj, null);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		int mineLevel = pj.getSkills().getSkillLevel(SkillType.pecher);
		if(SkillTool.Dice(mineLevel, 10)){
			System.out.println("Poisson trouvé !");
			// TODO Ajouter Poisson
		}else {
			System.out.println("Ca n'a pas mordu...");
		}
	}

	@Override
	public void update(Observable o, Object arg) {	
		switch (pj.getTile().getType()) {
		case Lake:
		case River:
		case Sea:
			this.setEnabled(true);
			break;
		default:
			this.setEnabled(false);
		}
	}

}
