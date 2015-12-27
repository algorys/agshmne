package io.github.algorys.agshmne.game;

import javax.swing.JFrame;

import io.github.algorys.agshmne.fenetre.FenetreAccueil;
import io.github.algorys.agshmne.fenetre.FenetreMap;
import io.github.algorys.agshmne.outils.MapUtils;
import io.github.algorys.agshmne.personnage.Personnage;
import io.github.algorys.agshmne.region.Region;
import io.github.algorys.agshmne.world.DefaultWorldFactory;
import io.github.algorys.agshmne.world.World;

public class Campagne {
	World world = new DefaultWorldFactory().create();
	Region map = world.getDefaultRegion();
	Personnage pj = new Personnage(map);
	MapUtils mapUtils = new MapUtils(map);
	
	public Campagne() {
	}

	public void run() {
		//world.move(Direction.NORTH, pj);
		//mapUtils.showStatus(pj);
		//world.move(Direction.NORTH, pj);
		//mapUtils.showStatus(pj);
		
		// TEST FENETRE
		FenetreMap fMap = new FenetreMap(world);
		fMap.setVisible(false);
		
		FenetreAccueil fAccueil = new FenetreAccueil();
		fAccueil.setVisible(true);
	}
}
