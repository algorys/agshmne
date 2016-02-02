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
		System.out.println("----- ROUND " + round + " -----");
		round += 1;
	}

	public int pjAttack() {
		int pjAttack = this.attack(pj.getCurrentAttributes().getDEX(), adv.getLevel());
		if (pjAttack < 0) {
			pjAttack = 0;
		}
		System.out.println("Attaque PJ= " + pjAttack);
		if (pjAttack > 0) {
			adv.getVital().setVie(adv.getVital().getVie() - pjAttack);
		}
		return pjAttack;
	}

	public int mobAttack() {
		int mobAttack = this.attack(adv.getCurrentAttributes().getDEX(), 10 + pj.getLevel());
		if (mobAttack < 0) {
			mobAttack = 0;
		}
		System.out.println("Attaque ADV = " + mobAttack);
		if (mobAttack > 0) {
			pj.getVital().setVie(pj.getVital().getVie() - mobAttack);
		}
		return mobAttack;
	}

	public boolean isFinish() {
		return this.pj.getVital().getVie() <= 0 || this.adv.getVital().getVie() <= 0;
	}

	private int attack(int carac, int level) {
		int dice = Tools.dice(20);
		int difficulty = 10 + level;
		int attack = dice + (carac / 2) - difficulty;
		return attack;
	}

	public Character getLeftOpponent() {
		return pj;
	}

	public Character getRightOpponent() {
		return adv;
	}
}
