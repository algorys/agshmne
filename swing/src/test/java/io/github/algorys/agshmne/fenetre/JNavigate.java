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

public class JNavigate extends JPanel {
	public static enum Step {
		GENDER, FACIAL, EQUIPMENT, STATS, CONFIRMATION
	}

	private JLabel jlPane;
	
	private Step step;
	private Action next;
	private Action previous;

	public JNavigate() {
		next = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JNavigate.this.step == Step.CONFIRMATION) {
					System.out.println("FINI !!!");
				} else {
					JNavigate.this.next();
				}
			}
		};
		previous = new AbstractAction("Précédent") {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (JNavigate.this.step == Step.GENDER) {
					System.out.println("Retour au menu principal");
				} else {
					JNavigate.this.previous();
				}
			}
		};

		this.setLayout(new GridLayout(0, 2));
		
		jlPane = new JLabel("Coucou");
		this.add(jlPane);
		this.add(new JButton(previous));
		this.add(new JButton(next));
	
		this.setStep(Step.GENDER);
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
		
		if(this.step == Step.GENDER) {
			this.previous.setEnabled(false);
		} else {
			this.previous.setEnabled(true);
		}
		
		this.jlPane.setText(this.step.name());
	}

	public void next() {
		switch (this.step) {
		case GENDER:
			this.setStep(Step.FACIAL);
			break;
		case FACIAL:
			this.setStep(Step.EQUIPMENT);
			break;
		case EQUIPMENT:
			this.setStep(Step.STATS);
			break;
		case STATS:
			this.setStep(Step.CONFIRMATION);
			break;
		default:
			throw new IllegalArgumentException("Pas de next !");
		}
	}

	public void previous() {
		switch (this.step) {
		case FACIAL:
			this.setStep(Step.GENDER);
			break;
		case EQUIPMENT:
			this.setStep(Step.FACIAL);
			break;
		case STATS:
			this.setStep(Step.EQUIPMENT);
			break;
		case CONFIRMATION:
			this.setStep(Step.STATS);
			break;
		default:
			throw new IllegalArgumentException("Pas de next !");
		}
	}
	
	public static void main(String[] args) {
		JFrame jf = new JFrame("toto");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JNavigate jToto = new JNavigate();
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
