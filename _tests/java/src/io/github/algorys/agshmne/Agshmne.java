package io.github.algorys.agshmne;

import io.github.algorys.agshmne.Personnage.Direction;
import io.github.algorys.agshmne.region.Region;
import io.github.algorys.agshmne.world.DefaultWorldFactory;
import io.github.algorys.agshmne.world.World;

public class Agshmne {
	public static void main(String[] args) {
		/*
		 * TEST PERSO
		 */
		
		World world = (new DefaultWorldFactory()).create();
		Region map = world.getDefaultRegion();
		Personnage pj = new Personnage(map);
		
		int d = Outils.dice(6);
		System.out.println("Vous lancez un dé : " + d);

		MapUtils mapUtils = new MapUtils(map);

		System.out.println("Votre carte : " + map);

		mapUtils.showStatus(pj);
		pj.move(Direction.SOUTH);
		mapUtils.showStatus(pj);
		pj.move(Direction.NORTH);
		mapUtils.showStatus(pj);
		pj.move(Direction.EAST);
		mapUtils.showStatus(pj);
		pj.move(Direction.WEST);
		mapUtils.showStatus(pj);
		pj.move(Direction.EAST);
		mapUtils.showStatus(pj);

	}
}
