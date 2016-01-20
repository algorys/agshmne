package io.github.algorys.agshmne.events;

import io.github.algorys.agshmne.danger.Danger;
import io.github.algorys.agshmne.tools.Tools;

public class Event {
	private Danger danger = new Danger();
	/*
	 * TODO
	 * Rencontre Amicale : le joueur peut se voir proposer une quête ou apprendre une compétence. (30% - DANGER)
	 * Rencontre Hostile : le joueur doit se battre ou monnayer sa fuite (si la rencontre le permet. Exemple : un joueur pourra marchander avec un bandit mais pas avec un loup). (20% + DANGER)
	 */
	public Event(Danger danger){
		this.danger = danger;
		int dice = Tools.dice(100);
		if(dice <= 29){
			System.out.println("-------------------");
			System.out.println("Rencontre AMICALE !");
			System.out.println("Résultat : " + dice);
			System.out.println("-------------------");
		} else if(dice <= 49){
			System.out.println("-------------------");
			System.out.println("Rencontre HOSTILE !");
			System.out.println("Résultat : " + dice);
			System.out.println("-------------------");
		} else if(dice <= 56){
			System.out.println("-------------------");
			System.out.println("Lieu-dit");
			System.out.println("Résultat : " + dice);
			System.out.println("-------------------");
		} else if(dice <= 59){
			System.out.println("-------------------");
			System.out.println("Donjon");
			System.out.println("Résultat : " + dice);
			System.out.println("-------------------");
		} else {
			System.out.println("Vous n'avez rien trouvé !");
			System.out.println("Résultat : " + dice);
		}
	}

}
