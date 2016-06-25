package com.apixandru.pokemon.model.object;

/**
 * @author Alexandru-Constantin Bledea
 * @since Jun 25, 2016
 */
public final strictfp class FloatingPoint {

    public static final FloatingPoint ZERO = new FloatingPoint(0, 0);

    public final float x, y;

    public FloatingPoint(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public FloatingPoint add(final Point other) {
        return add(other.x, other.y);
    }

    public final FloatingPoint add(final float x, final float y) {
        return new FloatingPoint(this.x + x, this.y + y);
    }

}
