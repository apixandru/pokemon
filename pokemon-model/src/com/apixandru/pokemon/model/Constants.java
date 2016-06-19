/**
 *
 */
package com.apixandru.pokemon.model;

import com.apixandru.pokemon.model.object.Point;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

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

    public static final byte DIRECTION_RIGHT = 1;

    public static final byte POS_X = 0;
    public static final byte POS_Y = 1;

    private static final List<Point> DIRECTION_MODIFIERS = unmodifiableList(asList(
            new Point(+0, -1),
            new Point(+1, +0),
            new Point(+0, +1),
            new Point(-1, +0)
    ));

    public static final byte[][] DIRECTION_MODIFIERS_NO_SIGN = {
            {0, 1},
            {1, 0},
            {0, 1},
            {1, 0},
    };

    public static Point getDirectionModifier(byte moveDirection) {
        return DIRECTION_MODIFIERS.get(moveDirection);
    }

    public enum MoveDirection {
        UP,
        RIGHT,
        DOWN,
        LEFT
    }

}
