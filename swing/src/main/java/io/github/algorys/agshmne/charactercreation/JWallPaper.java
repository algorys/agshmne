package io.github.algorys.agshmne.charactercreation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class JWallPaper extends JPanel {

	public JWallPaper() {
		// this.setPreferredSize(new Dimension(800, 500));
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbcWall = new GridBagConstraints();
		gbcWall.insets = new Insets(5, 5, 5, 5);

		// TITRE
		gbcWall.gridy = 0;
		gbcWall.gridheight = 1;
		gbcWall.gridx = 0;
		gbcWall.gridwidth = 2;
		gbcWall.anchor = GridBagConstraints.NORTH;
		gbcWall.fill = GridBagConstraints.NONE;
		JLabel jlTitle = new JLabel("Agshmne");
		jlTitle.setFont(new Font("URW Chancery L", Font.PLAIN, 70));
		jlTitle.setForeground(Color.green);
		this.add(jlTitle, gbcWall);

		gbcWall.gridy = 1;
		gbcWall.gridheight = 1;
		gbcWall.gridx = 0;
		gbcWall.gridwidth = 2;
		gbcWall.anchor = GridBagConstraints.WEST;
		gbcWall.fill = GridBagConstraints.NONE;
		JLabel info = new JLabel("Informations");
		info.setFont(new Font("Courier New", Font.ITALIC, 20));
		info.setForeground(Color.white);
		info.setPreferredSize(new Dimension(700, 200));
		this.add(info, gbcWall);

		gbcWall.gridy = 2;
		gbcWall.gridheight = 1;
		gbcWall.gridx = 0;
		gbcWall.gridwidth = 4;
		gbcWall.anchor = GridBagConstraints.WEST;
		gbcWall.fill = GridBagConstraints.BOTH;
		JTextArea infoArea = new JTextArea();
		infoArea.setForeground(Color.white);
		infoArea.setText(
				"Bienvenue dans Agshmne, ce jeu n'est encore qu'en phase ALPHA de développement et il peut subir "
				+ "des changements radicaux. La plupart des fonctionnalités ne sont donc pas encore implémentées. "
				+ "Le jeu n'est également pas encore équilibré et sera ajusté au fur et à mesure du développement. "
				+ "Le contenu sera aussi étoffé par la suite progressivement.");
		infoArea.setWrapStyleWord(true);
		infoArea.setLineWrap(true);
		infoArea.setFont(new Font("Courier New", Font.ITALIC, 14));
		infoArea.setOpaque(false);
		this.add(infoArea, gbcWall);
		
		gbcWall.gridy = 3;
		gbcWall.gridheight = 1;
		gbcWall.gridx = 0;
		gbcWall.gridwidth = 4;
		gbcWall.anchor = GridBagConstraints.WEST;
		gbcWall.fill = GridBagConstraints.BOTH;
		JTextArea howToPlay = new JTextArea(
				"Pour jouer, vous devez tout d'abord créer votre personnage. Une fois que cela est fait, "
				+ "vous pouvez vous déplacer sur les différentes cases du jeu avec les touches flechées de votre clavier ou "
				+ "en cliquant sur les cases autour de vous. Le monde est déjà vaste et vous aurez accès à quelques quêtes,"
				+ " des combats, divers objets à vendre ou à acheter. "
				+ "Amusez vous bien !");
		howToPlay.setForeground(Color.white);
		howToPlay.setWrapStyleWord(true);
		howToPlay.setLineWrap(true);
		howToPlay.setFont(new Font("Courier New", Font.ITALIC, 14));
		howToPlay.setOpaque(false);
		this.add(howToPlay, gbcWall);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			Image imgBack = ImageIO.read(JWallPaper.class.getClassLoader().getResource("wallpaper.png"));
			g.drawImage(imgBack, 0, 0, this.getWidth(), this.getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
