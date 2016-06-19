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

    public static final byte SCALE = 3;

    public static final byte DIRECTION_RIGHT = 1;

    private static final List<Point> DIRECTION_MODIFIERS = unmodifiableList(asList(
            new Point(+0, -1),
            new Point(+1, +0),
            new Point(+0, +1),
            new Point(-1, +0)
    ));

    private static final List<Point> DIRECTION_MODIFIERS_NO_SIGN = unmodifiableList(asList(
            new Point(0, 1),
            new Point(1, 0),
            new Point(0, 1),
            new Point(1, 0)
    ));

    private Constants() {
    }

    public static Point getDirectionModifier(final MoveDirection moveDirection) {
        return getModifier(DIRECTION_MODIFIERS, moveDirection);
    }

    public static Point getDirectionModifierUnsigned(final MoveDirection moveDirection) {
        return getModifier(DIRECTION_MODIFIERS_NO_SIGN, moveDirection);
    }

    private static Point getModifier(List<Point> points, final MoveDirection moveDirection) {
        return points.get(moveDirection.ordinal());
    }

    public enum MoveDirection {
        UP,
        RIGHT,
        DOWN,
        LEFT
    }

}
