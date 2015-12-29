package io.github.algorys.agshmne.fenetre;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class JFicheNav extends JPanel {
	/*
* 5 Caractéristiques (Force, Dextérité, Constitution, Intelligence et Charisme)
* 4 Vitales : Vie et Mana → dépensées par combat / compétences, Fatigue et Faim → incrémenté à chaque déplacement.
* 1 caractéristique Position
* 1 Équipement : Tête, Torse, Bras, Jambes, 2 Mains, 2 anneaux
* Compétences : celles de bases et celles apprises.
* Expérience et Niveau : augmentera selon les succès du joueur. Cela apportera des bonus et des points à distribuer.
* Argent : gagné de diverses façons.
	 */
	public static enum Step {
		SOCIAL, CARAC, EQUIPMENT, COMPETENCES, RESUME, CONFIRMATION
	}

	private JLabel jlPane;
	
	private Step step;
	private Action next;
	private Action previous;

	public JFicheNav() {
		next = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JFicheNav.this.step == Step.CONFIRMATION) {
					System.out.println("FINI !!!");
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

		this.setLayout(new GridLayout(0, 2));
		
		jlPane = new JLabel("Coucou");
		this.add(jlPane);
		this.add(new JButton(previous));
		this.add(new JButton(next));
	
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
			this.next.putValue(Action.NAME, "Valider");
		} else {
			this.next.putValue(Action.NAME, "Suivant");
		}
		
		if(this.step == Step.SOCIAL) {
			this.previous.setEnabled(false);
		} else {
			this.previous.setEnabled(true);
		}
		
		this.jlPane.setText(this.step.name());
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
			this.setStep(Step.RESUME);
			break;
		case RESUME:
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
		case RESUME:
			this.setStep(Step.COMPETENCES);
			break;
		case CONFIRMATION:
			this.setStep(Step.RESUME);
			break;
		default:
			throw new IllegalArgumentException("Pas de next !");
		}
	}
	
	public static void main(String[] args) {
		JFrame jf = new JFrame("FicheNav");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JFicheNav jToto = new JFicheNav();
		jf.getContentPane().add(jToto);
		
		JMenuBar jmb = new JMenuBar();
		JMenu jm = new JMenu("Menu");
		JMenuItem item = new JMenuItem(jToto.getNextAction());
		JMenuItem item2 = new JMenuItem(jToto.getPreviousAction());
		
		jm.add(item);
		jm.add(item2);
		jmb.add(jm);
		
		jf.setJMenuBar(jmb);
		
		jf.setSize(jf.getPreferredSize());
		jf.setVisible(true);
	}
}
