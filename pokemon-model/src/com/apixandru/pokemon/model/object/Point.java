/**
 *
 */
package com.apixandru.pokemon.model.object;

/**
 * @author Alexandru Bledea
 * @since Jun 11, 2015
 */
public class Point {

    public final int x, y;

    public Point(final Point point) {
        this(point.x, point.y);
    }

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    final Point merge(final Point other) {
        return new Point(x + other.x, y + other.y);
    }

    public final boolean sameXY(final Point other) {
        return x == other.x && y == other.y;
    }

}
