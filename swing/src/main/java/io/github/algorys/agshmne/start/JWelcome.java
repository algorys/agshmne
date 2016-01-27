package io.github.algorys.agshmne.start;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JWelcome extends JFrame {
	private static final String MAIN_MENU = "Main Menu";
	private static final String CHARACTER_SKILLS = "fiche";
	private JPanel cardPanel;
	private CardLayout cardLayout = new CardLayout();
	private Action actionShowNewGame;
	private Action actionShowSettings;
	private Action actionMainMenu;
	private JButton btLeft;

	public JWelcome() {
		setTitle("Agshmne running...");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		cardPanel = new JPanel();
		cardPanel.setLayout(cardLayout);

		JPanel jpAccueil = new JPanel();
		JLabel jlTitle = new JLabel("Agshmne");
		jlTitle.setFont(new Font("URW Chancery L", Font.PLAIN,70));
		jpAccueil.add(jlTitle);

		JPanel jpPerso = new JPanel();
		jpPerso.add(new JLabel("Création Personnage"));

		JPanel jpParams = new JPanel();
		jpParams.add(new JLabel("Paramètres"));

		cardPanel.add(jpAccueil, MAIN_MENU);
		cardPanel.add(jpPerso, "2");
		cardPanel.add(jpParams, "3");

		btLeft = new JButton();
		JButton btSettings = new JButton();

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(btLeft);
		buttonPanel.add(btSettings);

		add(cardPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.NORTH);

		actionShowNewGame = new AbstractAction("Nouvelle Partie") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btLeft.setAction(actionMainMenu);
				cardPanel.add(new JFicheNav(JWelcome.this), CHARACTER_SKILLS);
				cardLayout.show(cardPanel, CHARACTER_SKILLS);
			}
		};
		actionMainMenu = new AbstractAction("Menu principal") {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, MAIN_MENU);
				btLeft.setAction(actionShowNewGame);
			};
		};
		actionShowSettings = new AbstractAction("Paramètres") {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "3");
			}
		};

		btLeft.setAction(actionShowNewGame);
		btSettings.setAction(actionShowSettings);
		
	}

}