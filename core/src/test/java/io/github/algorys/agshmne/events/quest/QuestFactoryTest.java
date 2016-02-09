package io.github.algorys.agshmne.events.quest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.character.player.PlayerBuilder;
import io.github.algorys.agshmne.map.region.RandomRegionFactory;
import io.github.algorys.agshmne.map.region.Region;

public class QuestFactoryTest {

	@Test
	public void fetchQuestDifferent() {
		QuestFactory underTest = new QuestFactory();
		Region region = new RandomRegionFactory().create();
		IQuest quest = underTest.createFetchQuest(new Player(region));
		assertNotNull(quest);
		IQuest second = underTest.createFetchQuest(new Player(region));
		assertNotNull(second);
		assertNotSame(quest, second);
	}

	@Test
	public void randomQuestDifferent() {
		QuestFactory underTest = new QuestFactory();
		Region region = new RandomRegionFactory().create();
		IQuest quest = underTest.createAdventure(new Player(region));
		assertNotNull(quest);
		IQuest second = underTest.createAdventure(new Player(region));
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
