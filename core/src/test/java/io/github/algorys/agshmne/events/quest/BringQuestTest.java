package io.github.algorys.agshmne.events.quest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.github.algorys.agshmne.Game;
import io.github.algorys.agshmne.adventure.quest.BringQuest;
import io.github.algorys.agshmne.adventure.quest.QuestFactory;
import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.character.player.PlayerBuilder;
import io.github.algorys.agshmne.map.Position;

public class BringQuestTest {

	@Test
	public void win_objectAndPosition() {
		// given
		PlayerBuilder playerBuilder = new PlayerBuilder();
		Player pj = playerBuilder.create();
		Game game = playerBuilder.getGame();
		BringQuest underTest = new QuestFactory().createBringQuest(game);
		underTest.accept(pj);
		
		// when
		Position toGo = new Position(underTest.getQuestDestination().getX(), underTest.getQuestDestination().getY());
		game.setPosition(toGo);
		
		boolean res = underTest.isWin(pj);
		
		// then
		assertTrue(res);
	}

}
