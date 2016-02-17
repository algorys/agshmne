package io.github.algorys.agshmne.events.quest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.character.player.PlayerBuilder;

public class QuestFactoryTest {

	@Test
	public void fetchQuestDifferent() {
		QuestFactory underTest = new QuestFactory();
		Player pj = new PlayerBuilder().create();
		IQuest quest = underTest.createFetchQuest(pj);
		assertNotNull(quest);
		IQuest second = underTest.createFetchQuest(pj);
		assertNotNull(second);
		assertNotSame(quest, second);
	}

	@Test
	public void randomQuestDifferent() {
		QuestFactory underTest = new QuestFactory();
		Player pj = new PlayerBuilder().create();
		IQuest quest = underTest.createAdventure(pj);
		assertNotNull(quest);
		IQuest second = underTest.createAdventure(pj);
		assertNotNull(second);
		assertNotSame(quest, second);
	}
	
	@Test
	public void bringQuest() {
		QuestFactory underTest = new QuestFactory();
		IQuest quest = underTest.createBringQuest(new PlayerBuilder().create());
		assertNotNull(quest);
	}
}
