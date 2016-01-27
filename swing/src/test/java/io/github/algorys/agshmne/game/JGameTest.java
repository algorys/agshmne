package io.github.algorys.agshmne.game;

import io.github.algorys.agshmne.game.JGame;
import io.github.algorys.agshmne.map.region.Region;
import io.github.algorys.agshmne.character.Player;;

public class JGameTest {
	
	
	public static void main(String[] args) {
		Region region = new Region();
		Player pj = new Player(region);
		pj.initVital();
		JGame game = new JGame(pj);
		game.setVisible(true);

	}

}
