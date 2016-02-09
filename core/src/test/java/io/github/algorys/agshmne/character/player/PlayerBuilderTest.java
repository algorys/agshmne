package io.github.algorys.agshmne.character.player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class PlayerBuilderTest {
	@Test
	public void createPlayer_whenRegionIsNotNull() {
		PlayerBuilder underTest = new PlayerBuilder();
		Player created = underTest.create();
		assertNotNull(created);
	}

	@Test
	public void createPlayer_withFullAttributes() {
		Player created = new PlayerBuilder().setFOR(10).setDEX(10).setINT(10).setCON(10).setCHA(10).create();
		assertNotNull(created);
		assertEquals(10, created.getAttributes().getFOR());
		assertEquals(10, created.getAttributes().getDEX());
		assertEquals(10, created.getAttributes().getINT());
		assertEquals(10, created.getAttributes().getCON());
		assertEquals(10, created.getAttributes().getCHA());
	}
	
	@Test
	public void createPlayer_noNullItem() {
		PlayerBuilder underTest = new PlayerBuilder();
		Player pj = underTest.create();
		assertFalse(pj.getInventory().getListBackpack().contains(null));
	}
}
