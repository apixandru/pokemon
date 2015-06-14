/**
 *
 */
package com.github.apixandru.pokemon.model.object;

import com.github.apixandru.pokemon.model.WorldBounds;

/**
 * @author Alexandru Bledea
 * @since Jun 13, 2015
 */
public interface CharacterMoveListener extends WorldBounds {

	/**
	 * @param character
	 * @param direction
	 */
	void characterMoveStart(Character character, byte direction);

	/**
	 * @param character
	 */
	void characterMoveEnd(Character character);

}
