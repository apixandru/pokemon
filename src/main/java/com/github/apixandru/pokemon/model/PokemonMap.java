/**
 *
 */
package com.github.apixandru.pokemon.model;

import com.github.apixandru.pokemon.model.object.Character;
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

	/**
	 * @param character
	 * @param moveDirection
	 * @return
	 */
	boolean canMoveCharacter(Character character, byte moveDirection);

	/**
	 * @param character
	 */
	void characterMoveStart(Character character, byte moveDirection);

	/**
	 * @param character
	 */
	void characterMoveEnd(Character character);

}
