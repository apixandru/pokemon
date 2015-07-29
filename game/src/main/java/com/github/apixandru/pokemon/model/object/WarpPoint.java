/**
 *
 */
package com.github.apixandru.pokemon.model.object;

/**
 * @author Alexandru Bledea
 * @since Jun 11, 2015
 */
public final class WarpPoint extends Point {

	public final String destName;
	public final int spawnIndex;

	/**
	 * @param x
	 * @param y
	 * @param destName
	 * @param spawnIndex
	 */
	public WarpPoint(final int x, final int y, final String destName, final int spawnIndex) {
		super(x, y);
		this.destName = destName;
		this.spawnIndex = spawnIndex;
	}

}
