package io.github.algorys.agshmne.world;

import io.github.algorys.agshmne.region.AquaticRegionFactory;
import io.github.algorys.agshmne.region.DeserticRegionFactory;
import io.github.algorys.agshmne.region.Region;
import io.github.algorys.agshmne.region.RegionFactory;

public class DefaultWorldFactory implements WorldFactory {

	@Override
	public World create() {
		Region[][] regions = new Region[3][3];
		
		RegionFactory desertic = new DeserticRegionFactory();
		RegionFactory aquatic = new AquaticRegionFactory();
		
		regions[1][1] = new Region();
		regions[0][0] = desertic.create();
		regions[0][2] = desertic.create();
		regions[0][1] = aquatic.create();
		
		// TODO les autres regions
		
		
		return new World(regions);
	}

}
