package io.github.algorys.agshmne.map.city;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JTabbedPane;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.map.city.shop.JShop;
import io.github.algorys.agshmne.map.city.shop.Shop;
import io.github.algorys.agshmne.map.tile.Tile;

@SuppressWarnings("serial")
public class JPanCity extends JTabbedPane {

	public JPanCity(Player pj) {
		this.setTabPlacement(JTabbedPane.LEFT);
		JCityCenter cityCenter = new JCityCenter(pj); // Contiendra l'auberge et
														// la taverne
		final JShop cityMarket = new JShop(Shop.NONE, pj.getInventory(), pj.getName()); // Contiendra
																						// les
																						// magasins
		if (pj.getTile().isCivilized()) {
			cityMarket.setShop(pj.getTile().getCity().getShop());
		} else {
			cityMarket.setShop(Shop.NONE);
		}
		pj.addPropertyChangeListener(Player.PROPERTY_TILE, new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getNewValue() instanceof Tile) {
					Tile newTile = (Tile) evt.getNewValue();
					if (newTile.isCivilized()) {
						cityMarket.setShop(newTile.getCity().getShop());
					} else {
						cityMarket.setShop(Shop.NONE);
					}
				}
			}
		});
		this.addTab("<html><body><p style=text-align:center;>Centre <br>Ville</table></body></html>", cityCenter);
		this.addTab("<html><body><p style=text-align:center;>Place <br>du <br>Marché</table></body></html>",
				cityMarket);

	}

}
