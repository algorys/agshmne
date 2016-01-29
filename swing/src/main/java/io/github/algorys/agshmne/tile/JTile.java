package io.github.algorys.agshmne.tile;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import io.github.algorys.agshmne.map.tile.Tile;
import io.github.algorys.agshmne.map.tile.TileType;

@SuppressWarnings("serial")
public class JTile extends JComponent {
	/**
	 * Le gardien du temple... Il garde la seule image chargée par type de
	 * tuile.
	 */
	private static Map<TileType, Image> imagePerTileType = new HashMap<>();

	private Tile model;

	/**
	 * Récupère l'image correspondant au type de tuile.
	 * 
	 * @param type
	 *            Le type de tuile à afficher
	 * @return L'image chargée si elle existe, <code>null</code> sinon
	 */
	private static Image getImageFor(TileType type) {
		if (!JTile.imagePerTileType.containsKey(type)) {
			// Si notre gardien n'a pas encore la tuile
			try {
				// on essaye de la charger
				Image img = ImageIO.read(JTile.class.getClassLoader().getResource(type.name().toLowerCase() + ".png"));
				// et on la stocke
				JTile.imagePerTileType.put(type, img);
			} catch (IOException e) {
				// En cas d'erreur (fichier inexistant ? format illisible ?
				// etc.)
				e.printStackTrace();
			}
		}
		// On retourne ce que l'on a
		return JTile.imagePerTileType.get(type);
	}

	public Tile getModel() {
		return model;
	}

	public void setModel(Tile model) {
		if (model == null) {
			throw new NullPointerException("model cannot be null");
		}
		this.model = model;
	}

	public JTile(Tile model) {
		super();
		if (model == null) {
			throw new NullPointerException("model cannot be null");
		}
		this.model = model;
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(128, 128);
	}

	public void paintComponent(Graphics g) {
		// On récupère l'image pour la tuile
		Image img = JTile.getImageFor(this.model.getType());
		if (img == null) {
			// Par défaut, si l'image n'a pu être chargée, on affiche
			// une croix
			g.drawLine(1, 1, 130, 130);
			g.drawLine(130, 1, 1, 130);
		} else {
			// Dans le meilleur cas, on affiche l'image... ou les 48x48
			// premiers pixels en tous cas
			//System.out.println(this.getSize());
			g.drawImage(img, 1, 1, this.getWidth() - 2, this.getHeight() - 2, this);
		}
	}
}
