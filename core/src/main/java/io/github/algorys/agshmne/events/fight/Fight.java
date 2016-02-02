package io.github.algorys.agshmne.events.fight;

import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.events.IAdventure;
import io.github.algorys.agshmne.tools.Tools;

public class Fight implements IAdventure {
	private int round = 1;
	private int currentAdvLife;
	private int currentPjLife;
	private int pjDamage;
	private int mobDamage;
	private Character pj;
	private Character adv;
	
	public Fight(Character pj, Character adv) {
		this.pj = pj;
		this.adv = adv;
		this.currentPjLife = pj.getVital().getVie();
		this.currentAdvLife = adv.getVital().getVie();
	}
	
	public void newRound() {		
		System.out.println("----- ROUND " + round + " -----");
		round += 1;
	}
	
	public void pjAttack() {
		int pjAttack = this.attack(pj.getCurrentAttributes().getDEX(), adv.getLevel());
		System.out.println("Attaque PJ= " + pjAttack);
		this.pjDamage = pjAttack;
		if(pjAttack > 0) {
			this.currentAdvLife -= pjAttack;
			adv.getVital().setVie(currentAdvLife);
		}
	}
	
	public void mobAttack() {
		int mobAttack = this.attack(adv.getCurrentAttributes().getDEX(), 10 + pj.getLevel());
		System.out.println("Attaque ADV = " + mobAttack);
		this.mobDamage = mobAttack;
		if(mobAttack > 0) {
			this.currentPjLife -= mobAttack;
			pj.getVital().setVie(currentPjLife);
		}
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
	
	public String stringAttack() {
		String styleAttack;
		if(this.pjDamage == this.mobDamage) {
			styleAttack = "Match nul !";
		} else if(this.pjDamage >= this.mobDamage){
			styleAttack = this.pj.getName() + " mène une belle attaque...";
		}else {
			styleAttack = this.adv.getName() + " vous en met plein la tronche !!!";
		}
		return styleAttack;
	}

	public String stringDamage() {
		String stringDamage = "Dégats : "+pj.getName()+" ["+this.getPjDamage()+"],  "+adv.getName()+" ["+this.getMobDamage()+"]";
		return stringDamage;
	}

	public int getPjDamage() {
		return pjDamage;
	}


	public int getMobDamage() {
		return mobDamage;
	}
}
