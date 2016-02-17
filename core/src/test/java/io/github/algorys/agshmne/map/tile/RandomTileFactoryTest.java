package io.github.algorys.agshmne.map.tile;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;

import io.github.algorys.agshmne.map.Position;

public class RandomTileFactoryTest {

	@Test
	public void randomTileFactCreateATileShouldNotBeNull() {
		RandomTileFactory underTest = new RandomTileFactory();
		assertNotNull(underTest.createTile(new Position(0, 0)));
	}
	
	@Test
	public void randomTileFactCreateATileShouldCreateATile() {
		RandomTileFactory underTest = new RandomTileFactory();
		Tile res = underTest.createTile(new Position(0, 0));
		assertNotNull(res);
		assertThat(res, IsInstanceOf.instanceOf(Tile.class));
	}

}
