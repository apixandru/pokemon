/**
 *
 */
package com.apixandru.pokemon.model;

import com.apixandru.pokemon.model.object.Point;

/**
 * @author Alexandru Bledea
 * @since Jun 5, 2015
 */
public final class Constants {

    private Constants() {
    }

    public static final byte SCALE = 3;
    public static final byte BLOCK_WIDTH = 16;
    public static final byte BLOCK_HEIGHT = 16;

    public static final byte DIRECTION_UP = 0;
    public static final byte DIRECTION_RIGHT = 1;
    public static final byte DIRECTION_DOWN = 2;
    public static final byte DIRECTION_LEFT = 3;

    public static final byte POS_X = 0;
    public static final byte POS_Y = 1;

    private static final byte[][] DIRECTION_MODIFIERS = {
            {+0, -1},
            {+1, +0},
            {+0, +1},
            {-1, +0},
    };

    public static final byte[][] DIRECTION_MODIFIERS_NO_SIGN = {
            {0, 1},
            {1, 0},
            {0, 1},
            {1, 0},
    };

    public static Point getDirectionModifier(byte moveDirection) {
        byte[] directionModifier = DIRECTION_MODIFIERS[moveDirection];
        return new Point(directionModifier[POS_X], directionModifier[POS_Y]);
    }

}
