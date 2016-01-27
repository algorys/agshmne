package io.github.algorys.agshmne.region;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import io.github.algorys.agshmne.movement.Position;
import io.github.algorys.agshmne.region.Region;
import io.github.algorys.agshmne.tile.Tile;
import io.github.algorys.agshmne.tile.TileType;

@SuppressWarnings("serial")
public class JFullMap extends JPanel {
	/**
	 * Le gardien du temple... Il garde la seule image chargée par type de
	 * tuile.
	 */
	private Map<TileType, Image> imagePerTileType = new HashMap<>();

	/** Une référence vers la région affichée par le panneau actuel */
	private Region region;

	public JFullMap(Region region) {
		super();
		this.region = region;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	/**
	 * Récupère l'image correspondant au type de tuile.
	 * 
	 * @param type
	 *            Le type de tuile à afficher
	 * @return L'image chargée si elle existe, <code>null</code> sinon
	 */
	private Image getImageFor(TileType type) {
		if (!this.imagePerTileType.containsKey(type)) {
			// Si notre gardien n'a pas encore la tuile
			try {
				// on essaye de la charger
				Image img = ImageIO
						.read(this.getClass().getClassLoader().getResource(type.name().toLowerCase() + ".png"));
				// et on la stocke
				this.imagePerTileType.put(type, img);
			} catch (IOException e) {
				// En cas d'erreur (fichier inexistant ? format illisible ?
				// etc.)
				e.printStackTrace();
			}
		}
		// On retourne ce que l'on a
		return this.imagePerTileType.get(type);
	}

	public void paintComponent(Graphics g) {
		// Le nombre de colonnes : au maximum le nombre de colonne de notre
		// région, mais ne peut pas dépasser le nombre de colonnes affichables
		// dans notre espace
		int nbCol = Math.min(this.getWidth() / 50, Position.MAX_X - Position.MIN_X + 1);
		// de meme pour le nombre de ligne
		int nbRow = Math.min(this.getHeight() / 50, Position.MAX_Y - Position.MIN_Y + 1);

		// L'espace à laisser à gauche pour centrer nos colonnes
		int spaceCol = (this.getWidth() - (nbCol * 50)) / 2;
		int spaceRow = (this.getHeight() - (nbRow * 50)) / 2;

		for (int i = 0; i < nbRow; i++) {
			for (int j = 0; j < nbCol; j++) {
				// On récupère notre tuile
				Tile tile = region.getTileFromPosition(new Position(j + Position.MIN_X, i + Position.MIN_Y));
				// On récupère l'image pour la tuile
				Image img = this.getImageFor(tile.getType());
				if (img == null) {
					// Par défaut, si l'image n'a pu être chargée, on affiche
					// une croix
					g.drawLine(j * 50 + 1 + spaceCol, i * 50 + 1 + spaceRow, j * 50 + 1 + spaceCol + 50,
							i * 50 + 1 + spaceRow + 50);
					g.drawLine(j * 50 + 1 + spaceCol + 50, i * 50 + 1 + spaceRow, j * 50 + 1 + spaceCol,
							i * 50 + 1 + spaceRow + 50);
				} else {
					// Dans le meilleur cas, on affiche l'image... ou les 48x48
					// premiers pixels en tous cas
					g.drawImage(img, j * 50 + 1 + spaceCol, i * 50 + 1 + spaceRow, 48, 48, this);
				}
			}
		}
	}
}
