package io.github.algorys.agshmne.game;

import java.awt.Color;

import javax.swing.JFrame;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.character.player.PlayerBuilder;
import io.github.algorys.agshmne.game.fight.JCharacter;

public class JCharacterTest {

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		jf.setBackground(Color.black);
		Player pj = new PlayerBuilder().create();
		pj.getSocial().setName("Player");
		pj.initVital();
		JCharacter jc = new JCharacter(pj);
		jc.setOpaque(true);
		jf.add(jc);
		
		jf.setVisible(true);
	}

}
