/**
 *
 */
package com.github.apixandru.pokemon.model;

import com.apixandru.pokemon.model.object.Character;
import com.apixandru.pokemon.model.object.WarpPoint;

/**
 * @author Alexandru Bledea
 * @since Jun 14, 2015
 */
public interface MapEventListener {

    void onWarpPoint(Character character, WarpPoint warpPoint);

}
