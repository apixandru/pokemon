/**
 *
 */
package com.github.apixandru.pokemon.model;

import com.github.apixandru.pokemon.model.object.CharacterMoveListener;

/**
 * @author Alexandru Bledea
 * @since Jun 11, 2015
 */
public interface PokemonMap extends WorldBounds {

	/**
	 * @return
	 */
	CharacterMoveListener asCharacterMoveListener();

}
