/**
 *
 */
package com.github.apixandru.pokemon.ui.util;

import static com.github.apixandru.pokemon.util.Constants.TILE_HEIGHT;
import static com.github.apixandru.pokemon.util.Constants.TILE_WIDTH;

import org.newdawn.slick.geom.Vector2f;

/**
 * @author Alexandru Bledea
 * @since Jun 6, 2015
 */
public final class PositionUtil {

	/**
	 *
	 */
	private PositionUtil() {
	}

	/**
	 * @param position
	 * @param width
	 * @param height
	 */
	public static void round(final Vector2f position) {
		position.x = (int) (position.x / TILE_WIDTH) * TILE_WIDTH;
		position.y = (int) (position.y / TILE_HEIGHT) * TILE_HEIGHT;
	}

}
