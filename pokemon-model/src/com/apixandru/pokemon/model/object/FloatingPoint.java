package com.apixandru.pokemon.model.object;

/**
 * @author Alexandru-Constantin Bledea
 * @since Jun 25, 2016
 */
public final strictfp class FloatingPoint {

    public static final FloatingPoint ZERO = new FloatingPoint();

    public float x, y;

    public FloatingPoint() {
    }

    public FloatingPoint(float x, float y) {
        this.x = x;
        this.y = y;
    }

}
