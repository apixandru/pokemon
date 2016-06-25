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

    @Deprecated
    public Point(final float x, final float y) {
        this((int) x, (int) y);
    }

    public final Point merge(final Point other) {
        return merge(other.x, other.y);
    }

    public final Point merge(final float x, final float y) {
        return new Point(this.x + x, this.y + y);
    }

    public final boolean sameXY(final Point other) {
        return x == other.x && y == other.y;
    }

}
