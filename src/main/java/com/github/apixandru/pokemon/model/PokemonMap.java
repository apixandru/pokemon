/**
 *
 */
package com.github.apixandru.pokemon.model;


/**
 * @author Alexandru Bledea
 * @since Jun 7, 2015
 */
public final class PokemonMap {

	private final int rows, cols;
	private final boolean[][] content;

	/**
	 * @param rows
	 * @param cols
	 */
	public PokemonMap(final int rows, final int cols) {
		this.rows = rows;
		this.cols = cols;
		this.content = new boolean[rows][cols];
	}

	/**
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean isBlocked(final int x, final int y) {
		if (isOutOfBounds(x, y)) {
			return true;
		}
		return this.content[y][x];
	}

	/**
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean isOutOfBounds(final int x, final int y) {
		return x < 0 || y < 0 || x >= cols || y >= rows;
	}

	/**
	 * @param x
	 * @param y
	 */
	public void block(final int x, final int y) {
		this.content[y][x] = true;
	}

}
