package io.github.algorys.agshmne.character.player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import io.github.algorys.agshmne.map.region.RandomRegionFactory;

public class PlayerBuilderTest {

	@Test
	public void throwRTE_whenRegionIsNull() {
		PlayerBuilder underTest = new PlayerBuilder();
		try {
			underTest.create();
			fail("Must have an exception");
		} catch (RuntimeException e) {
			// Cool
		} catch (Exception e) {
			fail("Must have an exception");
		}
	}

	@Test
	public void createPlayer_whenRegionIsNotNull() {
		PlayerBuilder underTest = new PlayerBuilder();
		underTest.setRegion(new RandomRegionFactory().create());
		Player created = underTest.create();
		assertNotNull(created);
	}

	@Test
	public void createPlayer_withFullAttributes() {
		Player created = new PlayerBuilder().setRegion(new RandomRegionFactory().create()).setFOR(10).setDEX(10)
				.setINT(10).setCON(10).setCHA(10).create();
		assertNotNull(created);
		assertEquals(10, created.getAttributes().getFOR());
		assertEquals(10, created.getAttributes().getDEX());
		assertEquals(10, created.getAttributes().getINT());
		assertEquals(10, created.getAttributes().getCON());
		assertEquals(10, created.getAttributes().getCHA());
	}
}
