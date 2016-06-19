/**
 *
 */
package com.apixandru.pokemon.model.object;

import static com.apixandru.pokemon.model.Constants.getDirectionModifier;

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
        Point directionModifier = getDirectionModifier(moveDirection);
        final int xDestination = this.xCurrent + directionModifier.x;
        final int yDestination = this.yCurrent + directionModifier.y;
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
