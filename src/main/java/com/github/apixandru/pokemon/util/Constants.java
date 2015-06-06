/**
 *
 */
package com.github.apixandru.pokemon.util;

/**
 * @author Alexandru Bledea
 * @since Jun 5, 2015
 */
public interface Constants {

	byte TILE_WIDTH = 32;
	byte TILE_HEIGHT = 32;

	byte DIRECTION_UP = 0;
	byte DIRECTION_RIGHT = 1;
	byte DIRECTION_DOWN = 2;
	byte DIRECTION_LEFT = 3;

	byte POS_X = 0;
	byte POS_Y = 1;

	byte[][] DIRECTION_MODIFIERS = {
			{+0, -1},
			{+1, +0},
			{+0, +1},
			{-1, +0},
	};

}
