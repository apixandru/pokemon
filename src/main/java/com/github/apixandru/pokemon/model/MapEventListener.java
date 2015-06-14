/**
 *
 */
package com.github.apixandru.pokemon.model;

import com.github.apixandru.pokemon.model.object.Character;
import com.github.apixandru.pokemon.model.object.WarpPoint;

/**
 * @author Alexandru Bledea
 * @since Jun 14, 2015
 */
public interface MapEventListener {

	/**
	 * @param character
	 * @param warpPoint
	 */
	void onWarpPoint(Character character, WarpPoint warpPoint);

}
