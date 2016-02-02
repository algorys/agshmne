package io.github.algorys.agshmne.events.quest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import io.github.algorys.agshmne.character.player.Player;

public class QuestFactoryTest {

	@Test
	public void fetchQuestDifferent() {
		QuestFactory underTest = new QuestFactory();
		IQuest quest = underTest.createFetchQuest(new Player(null));
		assertNotNull(quest);
		IQuest second = underTest.createFetchQuest(new Player(null));
		assertNotNull(second);
		assertNotSame(quest, second);
	}

	@Test
	public void randomQuestDifferent() {
		QuestFactory underTest = new QuestFactory();
		IQuest quest = underTest.createAdventure(new Player(null));
		assertNotNull(quest);
		IQuest second = underTest.createAdventure(new Player(null));
		assertNotNull(second);
		assertNotSame(quest, second);
	}
	
	@Test
	public void bringQuest() {
		QuestFactory underTest = new QuestFactory();
		IQuest quest = underTest.createBringQuest(new Player(null));
		assertNotNull(quest);
	}
}
