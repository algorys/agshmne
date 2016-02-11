package io.github.algorys.agshmne.charactercreation;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JWallPaper extends JPanel {

	public JWallPaper() {
		JLabel jlTitle = new JLabel("Agshmne");
		jlTitle.setFont(new Font("URW Chancery L", Font.PLAIN,70));
		this.add(jlTitle);
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
