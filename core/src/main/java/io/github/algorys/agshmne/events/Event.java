package io.github.algorys.agshmne.events;

import io.github.algorys.agshmne.danger.Danger;
import io.github.algorys.agshmne.tools.Tools;

public class Event {
	private EncountType event;
	/*
	 * TODO
	 * Rencontre Amicale : le joueur peut se voir proposer une quête ou apprendre une compétence. (30% - DANGER)
	 * Rencontre Hostile : le joueur doit se battre ou monnayer sa fuite (si la rencontre le permet. Exemple : un joueur pourra marchander avec un bandit mais pas avec un loup). (20% + DANGER)
	 */
	public Event(Danger danger){
		event = ChoiceEvent(danger);
		Encounter encount = new Encounter(event);
	}
	
	private EncountType ChoiceEvent(Danger danger) {
		int dice = Tools.dice(100);
		danger.moreDanger();
		EncountType typeEvent;
		if(dice <= (29 - danger.getLvl())){
			typeEvent = EncountType.Friend;
		} else if(dice <= (49 + danger.getLvl())){
			typeEvent = EncountType.Hostil;
		} else if(dice <= 56){
			typeEvent = EncountType.Locality;
		} else if(dice <= 59){
			typeEvent = EncountType.Dungeon;
		} else {
			typeEvent = EncountType.Items;
		}
		
		return typeEvent;
	}

}
