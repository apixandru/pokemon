/**
 *
 */
package com.github.apixandru.pokemon.model;

import com.apixandru.pokemon.model.WorldBounds;
import com.apixandru.pokemon.model.object.WorldMap;

/**
 * @author Alexandru Bledea
 * @since Jun 11, 2015
 */
public interface PokemonMap extends WorldBounds {

    WorldMap asCharacterMoveListener();

}
