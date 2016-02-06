package io.github.algorys.agshmne.map.city;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import io.github.algorys.agshmne.character.player.Player;

@SuppressWarnings("serial")
public class JPanCity extends JTabbedPane{

	public JPanCity(Player pj) {
		this.setTabPlacement(JTabbedPane.LEFT);
		
		JCityCenter cityCenter = new JCityCenter(pj); // Contiendra l'auberge et la taverne
		JPanel cityMarket = new JPanel(); // Contiendra les magasins
		
		this.addTab("<html><body><p style=text-align:center;>Centre <br>Ville</table></body></html>", cityCenter);
		this.addTab("<html><body><p style=text-align:center;>Place <br>du <br>Marché</table></body></html>", cityMarket);
		
	}
	
}
