/**
 *
 */
package com.github.apixandru.pokemon.model;

/**
 * @author Alexandru Bledea
 * @since Jun 11, 2015
 */
public interface PokemonMap {

	/**
	 * @param x
	 * @param y
	 * @return
	 */
	boolean isBlocked(int x, int y);

}
