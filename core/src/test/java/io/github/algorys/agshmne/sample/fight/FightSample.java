package io.github.algorys.agshmne.sample.fight;

import io.github.algorys.agshmne.character.opponent.beast.Beast;
import io.github.algorys.agshmne.character.opponent.beast.BeastFactory;
import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.events.fight.Fight;

public class FightSample {

	public static void main(String[] args) {
		Beast wolf = new BeastFactory().createBeast();
		Player pj = new Player(null, null);
		pj.getSocial().setName("Joueur");
		pj.getAttributes().setFOR(12);
		pj.getAttributes().setDEX(12);
		pj.getAttributes().setCON(11);
		pj.initVital();
		
		Fight fight = new Fight(pj, wolf);
		System.out.println(pj.toString());
		System.out.println(wolf.toString());
		while(!fight.isFinish()) {
			fight.newRound();
		}
	}

}
