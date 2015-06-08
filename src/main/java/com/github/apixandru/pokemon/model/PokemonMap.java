/**
 *
 */
package com.github.apixandru.pokemon.model;

import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

/**
 * @author Alexandru Bledea
 * @since Jun 7, 2015
 */
public final class PokemonMap implements TileBasedMap {

	private final int rows, cols;

	/**
	 * @param rows
	 * @param cols
	 */
	public PokemonMap(final int rows, final int cols) {
		this.rows = rows;
		this.cols = cols;
	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.util.pathfinding.TileBasedMap#getWidthInTiles()
	 */
	@Override
	public int getWidthInTiles() {
		return cols;
	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.util.pathfinding.TileBasedMap#getHeightInTiles()
	 */
	@Override
	public int getHeightInTiles() {
		return rows;
	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.util.pathfinding.TileBasedMap#pathFinderVisited(int, int)
	 */
	@Override
	public void pathFinderVisited(final int x, final int y) {
	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.util.pathfinding.TileBasedMap#blocked(org.newdawn.slick.util.pathfinding.PathFindingContext, int, int)
	 */
	@Override
	public boolean blocked(final PathFindingContext context, final int tx, final int ty) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.util.pathfinding.TileBasedMap#getCost(org.newdawn.slick.util.pathfinding.PathFindingContext, int, int)
	 */
	@Override
	public float getCost(final PathFindingContext context, final int tx, final int ty) {
		return 1f;
	}

}
