package io.github.algorys.agshmne.events.fight;

import static org.junit.Assert.assertThat;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.events.IAdventure;
import io.github.algorys.agshmne.events.IAdventureFactory;

public class FightFactoryTest {

	@Test
	public void testConstructor() {
		FightFactory underTest = new FightFactory();
		assertThat(underTest, IsInstanceOf.instanceOf(IAdventureFactory.class));
	}

	@Test
	public void testDefaultCreatedIsFight() {
		FightFactory underTest = new FightFactory();
		Player pj = new Player(null);
		pj.initVital();
		IAdventure creation = underTest.createAdventure(pj);
		assertThat(creation, IsInstanceOf.instanceOf(Fight.class));
	}
}
