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
		position.x = round(position.x, TILE_WIDTH);
		position.y = round(position.y, TILE_HEIGHT);
	}

	/**
	 * @param currentPosition
	 * @param maxDimension
	 * @return
	 */
	private static int round(final float currentPosition, final int maxDimension) {
		float i = currentPosition / maxDimension;
		final float remainder = i % 1.0f;
		if (remainder > 0.5f) {
			i++;
		}
		return (int) i * maxDimension;
	}
}
