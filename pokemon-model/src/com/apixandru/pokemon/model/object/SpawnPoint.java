/**
 *
 */
package com.apixandru.pokemon.model.object;

/**
 * @author Alexandru Bledea
 * @since Jun 11, 2015
 */
public final class SpawnPoint extends Point {

    public final int index;

    public SpawnPoint(final int x, final int y, final int index) {
        super(x, y);
        this.index = index;
    }

}
