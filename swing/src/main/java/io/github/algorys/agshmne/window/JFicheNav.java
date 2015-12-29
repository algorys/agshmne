package io.github.algorys.agshmne.window;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import io.github.algorys.agshmne.tile.JTile;

public class JFicheNav extends JPanel {
	/*
	 * 5 Caractéristiques (Force, Dextérité, Constitution, Intelligence et
	 * Charisme) 4 Vitales : Vie et Mana → dépensées par combat / compétences,
	 * Fatigue et Faim → incrémenté à chaque déplacement. 1 caractéristique
	 * Position 1 Équipement : Tête, Torse, Bras, Jambes, 2 Mains, 2 anneaux
	 * Compétences : celles de bases et celles apprises. Expérience et Niveau :
	 * augmentera selon les succès du joueur. Cela apportera des bonus et des
	 * points à distribuer. Argent : gagné de diverses façons.
	 */
	public static enum Step {
		SOCIAL, CARAC, EQUIPMENT, COMPETENCES, RESUME, CONFIRMATION
	}

	private JSocialPanel socialPanel; 
	//private JLabel jlPane;
	private CardLayout cl;
	private Step step;
	private Action next;
	private Action previous;
	private JPanel jpPrincipal;
	private JPanel jpSocial;
	private JTextField jtfVerificationName;

	public JFicheNav() {
		next = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JFicheNav.this.step == Step.CONFIRMATION) {
						String name = socialPanel.getMyName();
						System.out.println("FINI !!!");
						System.out.println("Je remplis la fiche de perso pour " + name);
				} else {
					JFicheNav.this.next();
				}
			}
		};
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

		this.setLayout(new BorderLayout());

		cl = new CardLayout();
		jpPrincipal = new JPanel(cl);
		jpPrincipal.setOpaque(false);
		this.add(jpPrincipal, BorderLayout.CENTER);
		
		jpSocial = new JSocialPanel();
		jpSocial.setOpaque(false);
		jpPrincipal.add(jpSocial, Step.SOCIAL.name());

		// CARACTERISTIQUES
		JPanel jpCARAC = new JPanel();
		jpCARAC.add(new JLabel("CARAC"));
		jpPrincipal.add(jpCARAC, Step.CARAC.name());

		// EQUIPEMENT
		JPanel jpEQUIPMENT = new JPanel();
		jpEQUIPMENT.add(new JLabel("EQUIPMENT"));
		jpPrincipal.add(jpEQUIPMENT, Step.EQUIPMENT.name());

		// COMPETENCES
		JPanel jpCOMPETENCES = new JPanel();
		jpCOMPETENCES.add(new JLabel("COMPETENCES"));
		jpPrincipal.add(jpCOMPETENCES, Step.COMPETENCES.name());

		
		//JPanel jpRESUME = new JPanel();
		//jpRESUME.add(new JLabel("RESUME"));
		//jpPrincipal.add(jpRESUME, Step.RESUME.name());

		JPanel jpCONFIRMATION = new JPanel();
		jpCONFIRMATION.add(new JLabel("CONFIRMATION"));
		jtfVerificationName = new JTextField();
		jtfVerificationName.setEditable(false);
		jpCONFIRMATION.add(jtfVerificationName);

		jpPrincipal.add(jpCONFIRMATION, Step.CONFIRMATION.name());

		cl.show(jpPrincipal, Step.SOCIAL.name());

		JPanel jpButton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jpButton.setOpaque(false);
		jpButton.add(new JButton(previous));
		jpButton.add(new JButton(next));
		this.add(jpButton, BorderLayout.SOUTH);

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
			jtfVerificationName.setText(socialPanel.getMyName());
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
			this.setStep(Step.EQUIPMENT);
			break;
		case EQUIPMENT:
			this.setStep(Step.COMPETENCES);
			break;
		case COMPETENCES:
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
		case EQUIPMENT:
			this.setStep(Step.CARAC);
			break;
		case COMPETENCES:
			this.setStep(Step.EQUIPMENT);
			break;
		case CONFIRMATION:
			this.setStep(Step.COMPETENCES);
			break;
		default:
			throw new IllegalArgumentException("Pas de next !");
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		try {
			Image img = ImageIO.read(JTile.class.getClassLoader().getResource("parchemin.jpg"));
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
