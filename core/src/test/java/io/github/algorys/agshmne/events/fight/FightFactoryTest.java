package io.github.algorys.agshmne.events.fight;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.character.player.PlayerBuilder;
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
		Player pj = new PlayerBuilder().create();
		pj.initVital();
		Fight creation = underTest.createAdventure(pj);
		assertThat(creation, IsInstanceOf.instanceOf(Fight.class));
	}
	
	@Test
	public void testDefaultCreated_hasOpponent() {
		FightFactory underTest = new FightFactory();
		Player pj = new PlayerBuilder().create();
		pj.initVital();
		Fight creation = underTest.createAdventure(pj);
		assertNotNull(creation.getLeftOpponent());
		assertNotNull(creation.getRightOpponent());
	}

	@Test
	public void testDefaultCreated_hasOpponentWithHealth() {
		FightFactory underTest = new FightFactory();
		Player pj = new PlayerBuilder().create();
		pj.initVital();
		Fight creation = underTest.createAdventure(pj);
		assertTrue(creation.getRightOpponent().getVital().getLife() > 0);
	}
}
