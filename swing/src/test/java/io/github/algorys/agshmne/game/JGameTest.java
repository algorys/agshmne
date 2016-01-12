package io.github.algorys.agshmne.game;

import io.github.algorys.agshmne.game.JGame;
import io.github.algorys.agshmne.region.Region;
import io.github.algorys.agshmne.character.Character;;

public class JGameTest {
	
	
	public static void main(String[] args) {
		Region region = new Region();
		Character pj = new Character(region);
		pj.initVital();
		JGame game = new JGame(pj);
		game.setVisible(true);

	}

}
