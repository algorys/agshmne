package io.github.algorys.agshmne.game;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.game.JGame;
import io.github.algorys.agshmne.map.region.Region;;

public class JGameTest {
	
	
	public static void main(String[] args) {
		Region region = new Region();
		Player pj = new Player(region);
		pj.initVital();
		JGame game = new JGame(pj);
		game.setVisible(true);

	}

}
