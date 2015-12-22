package io.github.algorys.agshmne.game;

import io.github.algorys.agshmne.MapUtils;
import io.github.algorys.agshmne.Personnage;
import io.github.algorys.agshmne.deplacement.Direction;
import io.github.algorys.agshmne.region.Region;
import io.github.algorys.agshmne.world.DefaultWorldFactory;
import io.github.algorys.agshmne.world.World;

public class Campagne {
	World world = new DefaultWorldFactory().create();
	Region map = world.getDefaultRegion();
	Personnage pj = new Personnage(map);
	
	public Campagne() {
		world.move(Direction.NORTH, pj);
		
		MapUtils mapUtils = new MapUtils(map);
		mapUtils.showStatus(pj);
		world.move(Direction.NORTH, pj);
		mapUtils.showStatus(pj);
	}
	
}
