package io.github.algorys.agshmne.events.quest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import io.github.algorys.agshmne.character.player.PlayerBuilder;

public class QuestFactoryTest {

	@Test
	public void fetchQuestDifferent() {
		QuestFactory underTest = new QuestFactory();
		PlayerBuilder playerBuilder = new PlayerBuilder();
		playerBuilder.create();
		IQuest quest = underTest.createFetchQuest(playerBuilder.getGame());
		assertNotNull(quest);
		IQuest second = underTest.createFetchQuest(playerBuilder.getGame());
		assertNotNull(second);
		assertNotSame(quest, second);
	}

	@Test
	public void randomQuestDifferent() {
		QuestFactory underTest = new QuestFactory();
		PlayerBuilder playerBuilder = new PlayerBuilder();
		playerBuilder.create();
		IQuest quest = underTest.createAdventure(playerBuilder.getGame());
		assertNotNull(quest);
		IQuest second = underTest.createAdventure(playerBuilder.getGame());
		assertNotNull(second);
		assertNotSame(quest, second);
	}

	@Test
	public void bringQuest() {
		QuestFactory underTest = new QuestFactory();
		PlayerBuilder playerBuilder = new PlayerBuilder();
		IQuest quest = underTest.createBringQuest(playerBuilder.getGame());
		assertNotNull(quest);
	}
}
