package io.github.algorys.agshmne.fenetre;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetreAccueil extends JFrame{
  JPanel fAccueil = new JPanel();
  CardLayout cl = new CardLayout();
  
  public FenetreAccueil(){
    this.setTitle("Agshmne running...");
    //this.setSize(300, 150);
    this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    
    JPanel fParams = new JPanel();
    fParams.setBackground(Color.YELLOW);
    JPanel fCreaPerso = new JPanel();
    fCreaPerso.setName("Création de Personnage");
    fCreaPerso.setBackground(Color.BLACK);
    
    JButton begin = new JButton("Démarrer une partie");
    JButton params = new JButton("Paramètres");
    JButton retour = new JButton("Retour");
    
    JPanel boutonPane = new JPanel();
    begin.addActionListener (new ActionListener(){
        public void actionPerformed(ActionEvent event){
          //Via cette instruction, on passe au prochain conteneur de la pile
          cl.show(fAccueil, getName());
        }
    });
    
    params.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent event){
    		cl.show(fAccueil, getName());
    	}
    });
    
    fAccueil.add(fCreaPerso, "Création de Personnage");
    fAccueil.add(fParams, "Paramètres");
    //Ajout du bouton à notre content pane
    boutonPane.add(begin);
    boutonPane.add(params);
    this.getContentPane().add(boutonPane, BorderLayout.EAST);
    this.getContentPane().add(fAccueil, BorderLayout.CENTER);
    //this.setContentPane(fAccueil);
    //this.setVisible(true);
  }       
}