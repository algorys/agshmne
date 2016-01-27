package io.github.algorys.agshmne.game;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.player.skills.SkillType;
import io.github.algorys.agshmne.character.player.skills.factory.SkillFactory;
import io.github.algorys.agshmne.tile.JTile;

@SuppressWarnings("serial")
public class JTabComp extends JPanel {
	//private SkillFactory skillFact;
	
	public JTabComp(SkillFactory skillFact) {
		//this.skillFact = skillFact;
		// GidBag Layout
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbccSkill = new GridBagConstraints();
		// Ajuste la taille du GridBag
		gbccSkill.insets = new Insets(5, 5, 5, 5);

		// TITRE
		gbccSkill.gridy = 0;
		gbccSkill.gridheight = 1;
		gbccSkill.gridx = 0;
		gbccSkill.gridwidth = 4;
		gbccSkill.anchor = GridBagConstraints.CENTER;
		gbccSkill.fill = GridBagConstraints.NONE;
		this.add(new JLabel("COMPETENCES"), gbccSkill);
		
		// Cuisiner
		gbccSkill.gridy = 1;
		gbccSkill.gridheight = 1;
		gbccSkill.gridx = 0;
		gbccSkill.gridwidth = 2;
		gbccSkill.anchor = GridBagConstraints.WEST;
		gbccSkill.fill = GridBagConstraints.NONE;
		this.add(new JLabel(skillFact.getSkillName(SkillType.cuisine)), gbccSkill);
		gbccSkill.gridy = 1;
		gbccSkill.gridheight = 1;
		gbccSkill.gridx = 2;
		gbccSkill.gridwidth = 1;
		gbccSkill.anchor = GridBagConstraints.EAST;
		gbccSkill.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Niv : "+skillFact.getSkillLevel(SkillType.cuisine)), gbccSkill);
		
		// Fouiller
		gbccSkill.gridy = 2;
		gbccSkill.gridheight = 1;
		gbccSkill.gridx = 0;
		gbccSkill.gridwidth = 2;
		gbccSkill.anchor = GridBagConstraints.WEST;
		gbccSkill.fill = GridBagConstraints.NONE;
		this.add(new JLabel(skillFact.getSkillName(SkillType.fouiller)), gbccSkill);
		gbccSkill.gridy = 2;
		gbccSkill.gridheight = 1;
		gbccSkill.gridx = 2;
		gbccSkill.gridwidth = 1;
		gbccSkill.anchor = GridBagConstraints.EAST;
		gbccSkill.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Niv : "+skillFact.getSkillLevel(SkillType.fouiller)), gbccSkill);
		
		// Boucherie
		gbccSkill.gridy = 3;
		gbccSkill.gridheight = 1;
		gbccSkill.gridx = 0;
		gbccSkill.gridwidth = 2;
		gbccSkill.anchor = GridBagConstraints.WEST;
		gbccSkill.fill = GridBagConstraints.NONE;
		this.add(new JLabel(skillFact.getSkillName(SkillType.boucherie)), gbccSkill);
		gbccSkill.gridy = 3;
		gbccSkill.gridheight = 1;
		gbccSkill.gridx = 2;
		gbccSkill.gridwidth = 1;
		gbccSkill.anchor = GridBagConstraints.EAST;
		gbccSkill.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Niv : "+skillFact.getSkillLevel(SkillType.boucherie)), gbccSkill);
		
		// Bucheron
		gbccSkill.gridy = 4;
		gbccSkill.gridheight = 1;
		gbccSkill.gridx = 0;
		gbccSkill.gridwidth = 2;
		gbccSkill.anchor = GridBagConstraints.WEST;
		gbccSkill.fill = GridBagConstraints.NONE;
		this.add(new JLabel(skillFact.getSkillName(SkillType.bucheron)), gbccSkill);
		gbccSkill.gridy = 4;
		gbccSkill.gridheight = 1;
		gbccSkill.gridx = 2;
		gbccSkill.gridwidth = 1;
		gbccSkill.anchor = GridBagConstraints.EAST;
		gbccSkill.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Niv : "+skillFact.getSkillLevel(SkillType.bucheron)), gbccSkill);
		
		// Miner
		gbccSkill.gridy = 5;
		gbccSkill.gridheight = 1;
		gbccSkill.gridx = 0;
		gbccSkill.gridwidth = 2;
		gbccSkill.anchor = GridBagConstraints.WEST;
		gbccSkill.fill = GridBagConstraints.NONE;
		this.add(new JLabel(skillFact.getSkillName(SkillType.miner)), gbccSkill);
		gbccSkill.gridy = 5;
		gbccSkill.gridheight = 1;
		gbccSkill.gridx = 2;
		gbccSkill.gridwidth = 1;
		gbccSkill.anchor = GridBagConstraints.EAST;
		gbccSkill.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Niv : "+skillFact.getSkillLevel(SkillType.miner)), gbccSkill);
		
		// Cultiver
		gbccSkill.gridy = 6;
		gbccSkill.gridheight = 1;
		gbccSkill.gridx = 0;
		gbccSkill.gridwidth = 2;
		gbccSkill.anchor = GridBagConstraints.WEST;
		gbccSkill.fill = GridBagConstraints.NONE;
		this.add(new JLabel(skillFact.getSkillName(SkillType.cultiver)), gbccSkill);
		gbccSkill.gridy = 6;
		gbccSkill.gridheight = 1;
		gbccSkill.gridx = 2;
		gbccSkill.gridwidth = 1;
		gbccSkill.anchor = GridBagConstraints.EAST;
		gbccSkill.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Niv : "+skillFact.getSkillLevel(SkillType.cultiver)), gbccSkill);
		
		// Pecher
		gbccSkill.gridy = 7;
		gbccSkill.gridheight = 1;
		gbccSkill.gridx = 0;
		gbccSkill.gridwidth = 2;
		gbccSkill.anchor = GridBagConstraints.WEST;
		gbccSkill.fill = GridBagConstraints.NONE;
		this.add(new JLabel(skillFact.getSkillName(SkillType.pecher)), gbccSkill);
		gbccSkill.gridy = 7;
		gbccSkill.gridheight = 1;
		gbccSkill.gridx = 2;
		gbccSkill.gridwidth = 1;
		gbccSkill.anchor = GridBagConstraints.EAST;
		gbccSkill.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Niv : "+skillFact.getSkillLevel(SkillType.pecher)), gbccSkill);
		
		// Magie
		gbccSkill.gridy = 8;
		gbccSkill.gridheight = 1;
		gbccSkill.gridx = 0;
		gbccSkill.gridwidth = 2;
		gbccSkill.anchor = GridBagConstraints.WEST;
		gbccSkill.fill = GridBagConstraints.NONE;
		this.add(new JLabel(skillFact.getSkillName(SkillType.magie)), gbccSkill);
		gbccSkill.gridy = 8;
		gbccSkill.gridheight = 1;
		gbccSkill.gridx = 2;
		gbccSkill.gridwidth = 1;
		gbccSkill.anchor = GridBagConstraints.EAST;
		gbccSkill.fill = GridBagConstraints.NONE;
		this.add(new JLabel("Niv : "+skillFact.getSkillLevel(SkillType.magie)), gbccSkill);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			Image img = ImageIO.read(JTile.class.getClassLoader().getResource("parchemin.png"));
			Image imgBack = ImageIO.read(JTile.class.getClassLoader().getResource("table.png") );
			g.drawImage(imgBack, 0, 0, this.getWidth(), this.getHeight(), this);
			g.drawImage(img, 0, 0,  this.getWidth(), this.getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
