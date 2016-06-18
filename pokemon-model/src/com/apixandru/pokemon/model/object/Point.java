/**
 *
 */
package com.apixandru.pokemon.model.object;

/**
 * @author Alexandru Bledea
 * @since Jun 11, 2015
 */
public abstract class Point {

    public final int x, y;

    protected Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

}
