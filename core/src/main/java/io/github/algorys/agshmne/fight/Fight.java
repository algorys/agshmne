package io.github.algorys.agshmne.fight;

import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.tools.Tools;

public class Fight {
	private int round = 1;
	private int currentAdvLife;
	private int currentPjLife;
	private Character pj;
	private Character adv;
	
	public Fight(Character pj, Character adv) {
		this.pj = pj;
		this.adv = adv;
		this.currentPjLife = pj.getVital().getVie();
		this.currentAdvLife = adv.getVital().getVie();
	}
	
	public void newRound() {		
		System.out.println("---- ROUND " + round + " ----");
		
		int pjAttack = this.attack(pj.getCurrentAttributes().getDEX(), adv.getLevel());
		System.out.println("Attaque PJ= " + pjAttack);
		if(pjAttack > 0) {
			this.currentAdvLife -= pjAttack;
			adv.getVital().setVie(currentAdvLife);
		}	
		
		int advAttack = this.attack(adv.getCurrentAttributes().getDEX(), 10 + pj.getLevel());
		System.out.println("Attaque ADV = " + advAttack);
		if(advAttack > 0) {
			this.currentPjLife -= advAttack;
			pj.getVital().setVie(currentPjLife);
		}
		
		System.out.println(pj.toString());
		System.out.println(adv.toString());
		
		round += 1;
	}
	
	public boolean isFinish() {
		return this.currentPjLife <= 0 || this.currentAdvLife <= 0;
	}
	
	private int attack(int carac, int level) {
    	int dice = Tools.dice(20);
    	int difficulty = 10 + level;
    	int attack = dice + (carac / 2) - difficulty;
		return attack;
	}
}
