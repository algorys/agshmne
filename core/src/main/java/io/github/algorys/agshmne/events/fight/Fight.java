package io.github.algorys.agshmne.events.fight;

import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.events.IAdventure;
import io.github.algorys.agshmne.tools.Tools;

public class Fight implements IAdventure {
	private int round = 1;
	private Character pj;
	private Character adv;

	public Fight(Character pj, Character adv) {
		this.pj = pj;
		this.adv = adv;
	}

	public void newRound() {
		round += 1;
	}

	public int pjAttack() {
		int pjAttack = 0;
		if(pj.getCurrentAttributes().getDEX() > pj.getCurrentAttributes().getFOR()) {
			pjAttack = this.attack(pj.getCurrentAttributes().getDEX(), adv.getLevel());
		}else{
			pjAttack = this.attack(pj.getCurrentAttributes().getFOR(), adv.getLevel());
		}
		if (pjAttack < -5) {
			pjAttack = -5;
		}
		if (pjAttack > 0) {
			adv.getVital().setLife(adv.getVital().getLife() - pjAttack);
		} else if(pjAttack == 0) {
			adv.getVital().setLife(adv.getVital().getLife() - 1);
		}
		return pjAttack;
	}

	public int mobAttack() {
		int mobAttack = this.attack(adv.getCurrentAttributes().getDEX(), 10 + pj.getLevel());
		if (mobAttack < -5) {
			mobAttack = -5;
		}
		if (mobAttack > 0) {
			pj.getVital().setLife(pj.getVital().getLife() - mobAttack);
		} else if(mobAttack == 0) {
			pj.getVital().setLife(pj.getVital().getLife() - 1);
		}
		return mobAttack;
	}

	public boolean isFinish() {
		return this.pj.getVital().getLife() <= 0 || this.adv.getVital().getLife() <= 0;
	}

	private int attack(int carac, int level) {
		int dice = Tools.dice(20);
		int difficulty = 10 + (level*2);
		int attack = dice + (carac / 2) - difficulty;
		return attack;
	}

	public Character getLeftOpponent() {
		return pj;
	}

	public Character getRightOpponent() {
		return adv;
	}

	public int getRound() {
		return round;
	}
}
