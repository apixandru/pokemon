/**
 *
 */
package com.apixandru.pokemon.model.object;


import com.apixandru.pokemon.model.WorldBounds;

/**
 * @author Alexandru Bledea
 * @since Jun 13, 2015
 */
public interface WorldMap extends WorldBounds {

    void characterMoveEnd(Character character);

}
