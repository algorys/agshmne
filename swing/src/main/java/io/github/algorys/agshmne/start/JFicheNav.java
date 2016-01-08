package io.github.algorys.agshmne.start;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import io.github.algorys.agshmne.character.Character;
import io.github.algorys.agshmne.game.JGameWorld;
import io.github.algorys.agshmne.region.Region;
import io.github.algorys.agshmne.tile.JTile;

public class JFicheNav extends JPanel {
	
	public static enum Step {
		SOCIAL, CARAC, COMPETENCES, EQUIPMENT, RESUME, CONFIRMATION
	}

	private CardLayout cl;
	private Step step;
	private Action next;
	private Action previous;
	private JPanel jpPrincipal;
	private JSocialPanel jpSocial;
	private JCaracPanel jpCarac;
	private JCompPanel jpComp;
	private JInvPanel jpInv;
	private JConfirmPanel jpConfirm;
	
	private int FOR;
	private int DEX;
	private JTextField jtfVerificationName;
	private JTextField jtfFor;

	public JFicheNav() {
		this.setBackground(Color.BLACK);
		
		// Next Abstract Action
		next = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JFicheNav.this.step == Step.CONFIRMATION) {
					System.out.println("Personnage FOR : " + jpCarac.getFOR());
					System.out.println("Personnage Cuisiner : " + jpComp.getCuisiner());	
				} else {
					JFicheNav.this.next();
				}
			}
		};
		
		System.out.println("FOR = " + FOR);
		System.out.println("DEX = " + DEX);
		// Previous Abstract Action
		previous = new AbstractAction("Précédent") {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (JFicheNav.this.step == Step.SOCIAL) {
					System.out.println("Retour au menu principal");
				} else {
					JFicheNav.this.previous();
				}
			}
		};

		// Layout
		this.setLayout(new BorderLayout());
		cl = new CardLayout();
		
		// Panel Principal
		jpPrincipal = new JPanel(cl);
		jpPrincipal.setOpaque(false);
		this.add(jpPrincipal, BorderLayout.CENTER);

		// SOCIAL
		jpSocial = new JSocialPanel();
		jpSocial.setOpaque(false);
		jpPrincipal.add(jpSocial, Step.SOCIAL.name());

		// CARACTERISTIQUES
		jpCarac = new JCaracPanel();
		jpCarac.setOpaque(false);
		jpPrincipal.add(jpCarac, Step.CARAC.name());
		
		// COMPETENCES
		jpComp = new JCompPanel();
		jpComp.setOpaque(false);
		jpPrincipal.add(jpComp, Step.COMPETENCES.name());
		
		// EQUIPEMENT
		jpInv = new JInvPanel();
		jpInv.setOpaque(false);
		jpPrincipal.add(jpInv, Step.EQUIPMENT.name());

		cl.show(jpPrincipal, Step.SOCIAL.name());

		JPanel jpButton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jpButton.setOpaque(false);
		jpButton.add(new JButton(previous));
		jpButton.add(new JButton(next));
		this.add(jpButton, BorderLayout.SOUTH);

		// Initialisation à Social
		this.setStep(Step.SOCIAL);
	}

	public Action getNextAction() {
		return next;
	}

	public Action getPreviousAction() {
		return previous;
	}

	private void setStep(Step step) {
		this.step = step;
		if (this.step == Step.CONFIRMATION) {
			jpConfirm = new JConfirmPanel(jpSocial, jpCarac, jpComp, jpInv);
			jpConfirm.setOpaque(false);
			jpPrincipal.add(jpConfirm, Step.CONFIRMATION.name());
			this.next.putValue(Action.NAME, "Valider");
		} else {
			this.next.putValue(Action.NAME, "Suivant");
		}

		if (this.step == Step.SOCIAL) {
			this.previous.setEnabled(false);
		} else {
			this.previous.setEnabled(true);
		}

		cl.show(jpPrincipal, this.step.name());
	}

	public void next() {
		switch (this.step) {
		case SOCIAL:
			this.setStep(Step.CARAC);
			break;
		case CARAC:
			this.setStep(Step.COMPETENCES);
			break;
		case COMPETENCES:
			this.setStep(Step.EQUIPMENT);
			break;	
		case EQUIPMENT:
			this.setStep(Step.CONFIRMATION);
			break;
		default:
			throw new IllegalArgumentException("Pas de next !");
		}
	}

	public void previous() {
		switch (this.step) {
		case CARAC:
			this.setStep(Step.SOCIAL);
			break;
		case COMPETENCES:
			this.setStep(Step.CARAC);
			break;
		case EQUIPMENT:
			this.setStep(Step.COMPETENCES);
			break;
		case CONFIRMATION:
			this.setStep(Step.EQUIPMENT);
			break;
		default:
			throw new IllegalArgumentException("Pas de next !");
		}
	}

	@Override
	public Dimension getPreferredSize() {
		Dimension preferredSize = super.getPreferredSize();
		preferredSize.width += 150;
		preferredSize.height += 300;
		return preferredSize;
	}

	@Override
	public Dimension getMinimumSize() {
		return this.getPreferredSize();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int width = getPreferredSize().width;
		int height = getPreferredSize().height;
		int x = (this.getWidth() - width) / 2;
		int y = (this.getHeight() - height) / 2;
		try {
			Image img = ImageIO.read(JTile.class.getClassLoader().getResource("parchemin.png"));
			Image imgBack = ImageIO.read(JTile.class.getClassLoader().getResource("table.png") );
			g.drawImage(imgBack, 0, 0, this.getWidth(), this.getHeight(), this);
			g.drawImage(img, x, y, width, height, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
