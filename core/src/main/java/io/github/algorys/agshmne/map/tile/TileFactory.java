package io.github.algorys.agshmne.map.tile;

import io.github.algorys.agshmne.map.Position;

public interface TileFactory {

	Tile createTile(Position position);

}