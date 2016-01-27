package io.github.algorys.agshmne.map.region;

import io.github.algorys.agshmne.map.tile.RandomTileFactory;

public class RandomRegionFactory implements RegionFactory {

	@Override
	public Region create() {
		return new Region(new RandomTileFactory());
	}

}
