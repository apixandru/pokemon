/**
 *
 */
package com.github.apixandru.pokemon.util;

/**
 * @author Alexandru Bledea
 * @since Jun 5, 2015
 */
public interface Constants {
	byte SCALE = 3;
	byte BLOCK_WIDTH = 16;
	byte BLOCK_HEIGHT = 16;

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

	byte[][] DIRECTION_MODIFIERS_NO_SIGN = {
			{0, 1},
			{1, 0},
			{0, 1},
			{1, 0},
	};

}
