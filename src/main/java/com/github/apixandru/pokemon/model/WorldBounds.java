/**
 *
 */
package com.github.apixandru.pokemon.model;

/**
 * @author Alexandru Bledea
 * @since Jun 14, 2015
 */
public interface WorldBounds {

	/**
	 * @param x
	 * @param y
	 * @return
	 */
	boolean isBlocked(int x, int y);

}
