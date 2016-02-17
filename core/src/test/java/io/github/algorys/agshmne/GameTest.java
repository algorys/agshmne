package io.github.algorys.agshmne;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.github.algorys.agshmne.map.Position;

public class GameTest {
	@Test
	public void whenCharacterIsCreated_positionShouldBe00() {
		Game underTest = new Game(null);
		assertEquals(new Position(0, 0), underTest.getPosition());
	}
}
