package io.github.algorys.agshmne.game;

import io.github.algorys.agshmne.MapUtils;
import io.github.algorys.agshmne.Personnage;
import io.github.algorys.agshmne.Personnage.Direction;
import io.github.algorys.agshmne.deplacement.Move;
import io.github.algorys.agshmne.region.Region;
import io.github.algorys.agshmne.world.DefaultWorldFactory;
import io.github.algorys.agshmne.world.World;

public class Campagne {
	World world = new DefaultWorldFactory().create();
	Region map = world.getDefaultRegion();
	Personnage pj = new Personnage(map);
	Move move;
	
	public Campagne() {
		this.move = new Move(this.pj.NORTH), pj.getPosition());
		
		MapUtils mapUtils = new MapUtils(map);
		mapUtils.showStatus(pj);
		move = new Move(Direction.NORTH, pj.getPosition());
		mapUtils.showStatus(pj);
	}
	
}
