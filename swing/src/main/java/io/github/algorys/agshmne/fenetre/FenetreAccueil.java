package io.github.algorys.agshmne.fenetre;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetreAccueil extends JFrame{
	    private JPanel cardPanel, jpAccueil, jpPerso, jpParams, buttonPanel;
	    private JLabel jl1, jl2, jl3;
	    private JButton btn1, btn2;
	    private CardLayout cardLayout = new CardLayout();

	    public FenetreAccueil() {
	        setTitle("Agshmne running...");
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	        
	        cardPanel = new JPanel();
	        buttonPanel = new JPanel();
	        cardPanel.setLayout(cardLayout);
	        jpAccueil = new JPanel();
	        jpPerso = new JPanel();
	        jpParams = new JPanel();
	        jl1 = new JLabel("Accueil");
	        jl2 = new JLabel("Création Personnage");
	        jl3 = new JLabel("Paramètres");
	        jpAccueil.add(jl1);
	        jpPerso.add(jl2);
	        jpParams.add(jl3);
	        cardPanel.add(jpAccueil, "1");
	        cardPanel.add(jpPerso, "2");
	        cardPanel.add(jpParams, "3");
	        btn1 = new JButton("Nouvelle Partie");
	        btn1.addActionListener(new ActionListener() {

	            public void actionPerformed(ActionEvent e) {
	                cardLayout.show(cardPanel, "2");
	            }
	        });
	        btn2 = new JButton("Paramètres");
	        btn2.addActionListener(new ActionListener() {

	            public void actionPerformed(ActionEvent e) {
	                cardLayout.show(cardPanel, "3");
	            }
	        });
	        buttonPanel.add(btn1);
	        buttonPanel.add(btn2);
	        add(cardPanel, BorderLayout.CENTER);
	        add(buttonPanel, BorderLayout.NORTH);
	    }
     
}