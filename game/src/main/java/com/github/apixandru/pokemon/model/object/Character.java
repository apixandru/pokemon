/**
 *
 */
package com.github.apixandru.pokemon.model.object;

import static com.github.apixandru.pokemon.util.Constants.DIRECTION_MODIFIERS;
import static com.github.apixandru.pokemon.util.Constants.POS_X;
import static com.github.apixandru.pokemon.util.Constants.POS_Y;

/**
 * @author Alexandru Bledea
 * @since Jun 11, 2015
 */
public final class Character {

    public int xCurrent, yCurrent;
    public byte moveDirection;
    private int xDestination, yDestination;
    private WorldMap currentMap;

    public Character(final int x, final int y) {
        this.xCurrent = x;
        this.yCurrent = y;
    }

    public boolean moveBegin(final byte moveDirection) {
        this.moveDirection = moveDirection;
        final int xDestination = this.xCurrent + DIRECTION_MODIFIERS[moveDirection][POS_X];
        final int yDestination = this.yCurrent + DIRECTION_MODIFIERS[moveDirection][POS_Y];
        if (currentMap.isBlocked(xDestination, yDestination)) {
            return false;
        }
        this.xDestination = xDestination;
        this.yDestination = yDestination;
        return true;
    }

    public void moveEnd() {
        this.xCurrent = xDestination;
        this.yCurrent = yDestination;
        currentMap.characterMoveEnd(this);
    }

    public void setCurrentMap(final WorldMap currentMap) {
        this.currentMap = currentMap;
    }

}
