package io.github.algorys.agshmne.map.tile;

import static org.junit.Assert.*;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;

public class RandomTileFactoryTest {

	@Test
	public void randomTileFactCreateATileShouldNotBeNull() {
		RandomTileFactory underTest = new RandomTileFactory();
		assertNotNull(underTest.createTile());
	}
	
	@Test
	public void randomTileFactCreateATileShouldCreateATile() {
		RandomTileFactory underTest = new RandomTileFactory();
		assertNotNull(underTest.createTile());
		assertThat(underTest.createTile(), IsInstanceOf.instanceOf(Tile.class));
	}

}
