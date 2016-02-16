package io.github.algorys.agshmne.events.quest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.character.player.PlayerBuilder;
import io.github.algorys.agshmne.items.GeneralItem;
import io.github.algorys.agshmne.map.Position;

public class BringQuestTest {

	@Test
	public void win_objectAndPosition() {
		// given
		Player pj = new PlayerBuilder().create();
		BringQuest underTest = new BringQuest(pj, new GeneralItem("test", 0));
		underTest.accept(pj);
		
		// when
		Position toGo = new Position(underTest.getQuestDestination().getX(), underTest.getQuestDestination().getY());
		pj.getGame().setPosition(toGo);
		
		boolean res = underTest.isWin(pj);
		
		// then
		assertTrue(res);
	}

}
